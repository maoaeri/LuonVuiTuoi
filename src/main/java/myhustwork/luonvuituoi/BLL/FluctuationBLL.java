package myhustwork.luonvuituoi.BLL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import myhustwork.luonvuituoi.DAO.AccountDAO;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.DTO.MoneyDTO;
        
public class FluctuationBLL {//bien dong so du//
    private FluctuationDAO flucDAO;
    private AccountDAO accDAO;

    public FluctuationBLL() {
        flucDAO = new FluctuationDAO();
        accDAO = new AccountDAO();
    }
    
    public static void main(String[] args) {
        FluctuationBLL flucBLL = new FluctuationBLL();
        double[] a = null;
        try {
            a = flucBLL.PercentCategories(LocalDate.MIN, LocalDate.MAX);
        } catch (SQLException ex) {
            Logger.getLogger(FluctuationBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (double i: a){
            System.err.println(i);
        }
    }
    
    /**
     * Warning if there's a chance balance < 0
     * @return 
     */
    public Boolean WarningBalance() throws SQLException { //canh bao
        AccountDTO acc = accDAO.get(1);
        double save_per_month = acc.getSave_per_month(); // account lấy từ database
        double balance = acc.getBalance();
        return balance - save_per_month < 0;
    }

    
    public double[] PercentCategories(LocalDate date1, LocalDate date2) throws SQLException {
        double[] sumCategories = new double[26]; // có 25 hạng mục 
        double[] percentCategories = new double[26];
        for(int j = 1; j <= 25; j++) {
            sumCategories[j] = 0;
            percentCategories[j] = -1; // -1 là không tồn tại
        }
        FluctuationDTO[] flucArr = flucDAO.getAll();
        for(FluctuationDTO i: flucArr) {
            if(i.getDate().isAfter(date1) && i.getDate().isBefore(date2) ){
                switch (i.getCategory().getCategoryId()) {
                    case 1,2,3, 4, 5, 6, 7, 8, 9,10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 -> {
                        int j = i.getCategory().getCategoryId();
                        sumCategories[j] += i.getAmount();                   
                        break;
                    }
                }
            }
        }
        for(int j = 3; j <=9; j++) {
            sumCategories[1] += sumCategories[j]; 
        }
        sumCategories[10] = sumCategories[10] + sumCategories[14] + sumCategories[15] + sumCategories[16] + sumCategories[17] + sumCategories[18];
        sumCategories[11] = sumCategories[11] + sumCategories[19] + sumCategories[20] + sumCategories[21] + sumCategories[22] + sumCategories[23];
        sumCategories[13] = sumCategories[13] + sumCategories[24] + sumCategories[25];
        sumCategories[2] = sumCategories[2] + sumCategories[10] + sumCategories[11] + sumCategories[12] + sumCategories[13];
        
        for(int j = 3; j <= 9; j++) {
            percentCategories[j] = (sumCategories[j]/sumCategories[1])*100;
        }
        for(int j = 10; j <= 25; j++) {
            percentCategories[j] = (sumCategories[j]/sumCategories[2])*100;
        }
//        for(int j = 1; j <= 25; j++) {
//            System.err.println(j + " " + sumCategories[j]);
//        }
        return percentCategories;
        
//                if(i.getCategory().isIncome()) {
//                    sumIncome += i.getAmount();
//                    j = i.getCategory().getCategoryId();
//                    sumCategoriesIncome[j] += i.getAmount();
//                }
//                else {
//                    sumSpending += i.getAmount();
//                    j = i.getCategory().getCategoryId();
//                    sumCategoriesSpending[j] += i.getAmount();
//                }
//            }
//            for(j = 0; j < 12; j++) {
//                percentCategoriesIncome[j] = sumCategoriesIncome[j]/sumIncome;
//                percentCategoriesSpending[j] = sumCategoriesSpending[j]/sumSpending;
//            }
    }
    /**
     * sum per month
     *
     */  
    public void SumPerMonth(int Year) throws SQLException {
        double[] sumIncome = new double[13]; // tổng thu của 12 tháng
        double[] sumSpending = new double[13]; // tổng chi của 12 tháng
        for(int j = 1; j <= 12; j ++){
            sumIncome[j] = 0;
            sumSpending[j] = 0;
        }
        FluctuationDTO[] flucArr = flucDAO.getAll();
        for(FluctuationDTO i: flucArr) {
            if(Year == i.getDate().getYear() ) {
                int j = i.getDate().getMonthValue();
                if(i.getCategory().isIncome()) sumIncome[j] += i.getAmount(); // tính tổng thu từng tháng
                else sumSpending[j] += i.getAmount(); // tổng chi từng tháng
            }
        }
    }
    
    public double AutoCal() throws SQLException {
        AccountDTO acc = accDAO.get(1);
        Calendar cal = Calendar.getInstance();
        double balance = acc.getBalance();
        if(cal.get(Calendar.DAY_OF_MONTH) == 1){ // sang thang moi
            FluctuationDTO[] flucArr = flucDAO.getAll();
            for(FluctuationDTO i: flucArr) {
                if(i.isFixed()) {
                    if(i.getCategory().isIncome()) balance += i.getAmount();
                    else balance -= i.getAmount();
                }
            }
        } 
        return balance;
    }
    
    public int[] SuggestionNextMonth(LocalDate date1, LocalDate date2) throws SQLException {
        double[] percentCategories = new double[26];
        percentCategories = PercentCategories(date1, date2);
        int[] mark = {0, 0, 0, 0};
        if(percentCategories[10] > 0.6) mark[0] = 1; // = 1 là tiêu quá
        if(percentCategories[21] > 0.15) mark[1] = 1;
        if(percentCategories[19] + percentCategories[22] + percentCategories[23] > 0.15) mark[2] = 1;
        if(1 - percentCategories[10] - percentCategories[21] - percentCategories[19] - percentCategories[22] - percentCategories[23] > 0.1) mark[3] = 1;
        return mark;
    }
}

