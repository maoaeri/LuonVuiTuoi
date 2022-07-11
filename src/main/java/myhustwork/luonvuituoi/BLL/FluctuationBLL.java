package myhustwork.luonvuituoi.BLL;

import java.util.Date;
import java.util.Calendar;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
        
public class FluctuationBLL {//bien dong so du//
    
    public static int addFluctuation(FluctuationDTO fluc){
        int res = FluctuationDAO.addFluctuation(fluc);
        return res;
    }
    
    /**
     * Warning if there's a chance balance < 0
     * @return 
     */
    public static Boolean WarningBalance() { //canh bao
        double save_per_month = AccountDTO.getSave_per_month(); // account lấy từ database
        double balance = AccountDTO.getBalance();
        return balance - save_per_month < 0;
    }
    
    public static double[] PercentCategoriesSpending(Date date1, Date date2) {
        double sumSpending = 0;
        double[] sumCategoriesSpending = new double[12];
        double[] percentCategoriesSpending = new double[12];
        int j;
        for(int i = 0; i < 12; i++) {
            sumCategoriesSpending[i] = 0;
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();
        for(FluctuationDTO i: flucArr) {
            if(i.getDate().after(date1) && i.getDate().before(date2) ){
                if(!i.getCategory().isIncome()) {
                    sumSpending += i.getAmount();
                    j = i.getCategory().getCategoryId();
                    sumCategoriesSpending[j] += i.getAmount();
                }
            }
            for(j = 0; j < 12; j++) {
                percentCategoriesSpending[j] = sumCategoriesSpending[j]/sumSpending;
            }
        }
        return percentCategoriesSpending;
    }
    
    public static double[] PercentCategoriesIncome(Date date1, Date date2) {
        double sumIncome = 0;
        double[] sumCategoriesIncome = new double[12]; //gia su co 12 CategoryID
        double[] percentCategoriesIncome = new double[12];
        int j;
        for(int i = 0; i < 12; i++) {
            sumCategoriesIncome[i] = 0;
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();        
        for(FluctuationDTO i: flucArr) {
            if(i.getDate().after(date1) && i.getDate().before(date2) ){
                if(i.getCategory().isIncome()) {
                    sumIncome += i.getAmount();
                    j = i.getCategory().getCategoryId();
                    sumCategoriesIncome[j] += i.getAmount();
                }
            }
            for(j = 0; j < 12; j++) {
                percentCategoriesIncome[j] = sumCategoriesIncome[j]/sumIncome;
            }
        }
        return percentCategoriesIncome;
    }
    
    /**
     *
     * @param Year
     * @return
     */
    public static double[] SumPerMonthSpending(int Year) {
        double[] sumSpending = new double[13]; // tổng chi của 12 tháng
        for(int j = 1; j <= 12; j ++){
            sumSpending[j] = 0;
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();        
        for(FluctuationDTO i: flucArr) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(i.getDate()); // chuyển Date thành Calendar
            if(Year == cal.get(Calendar.YEAR) ) {
                int j = cal.get(Calendar.MONTH);
                if(!i.getCategory().isIncome())
                    sumSpending[j] += i.getAmount(); // tổng chi từng tháng
            }
        }
        return sumSpending;
    }

    public static double[] SumPerMonthIncome(int Year) {
        double[] sumIncome = new double[13]; // tổng thu của 12 tháng
        for(int j = 1; j <= 12; j ++){
            sumIncome[j] = 0;
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();        
        for(FluctuationDTO i: flucArr) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(i.getDate()); // chuyển Date thành Calendar
            if(Year == cal.get(Calendar.YEAR) ) {
                int j = cal.get(Calendar.MONTH);
                if(i.getCategory().isIncome()) sumIncome[j] += i.getAmount(); // tính tổng thu từng tháng
            }
        }
        return sumIncome;
    }    
    public static double AutoCal() {
        Calendar cal = Calendar.getInstance();
        double balance = AccountDTO.getBalance();
        if(cal.get(Calendar.DAY_OF_MONTH) == 1){ // sang thang moi
            FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();
            for(FluctuationDTO i: flucArr) {
                if(i.isFixed()) {
                    if(i.getCategory().isIncome()) balance += i.getAmount();
                    else balance -= i.getAmount();
                }
            }
        } 
        return balance;
    }
}

