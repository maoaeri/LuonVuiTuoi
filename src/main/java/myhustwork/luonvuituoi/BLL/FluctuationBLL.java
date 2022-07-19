package myhustwork.luonvuituoi.BLL;

import myhustwork.luonvuituoi.DAO.*;
import myhustwork.luonvuituoi.DTO.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FluctuationBLL implements BLLInterface<FluctuationDTO>{//bien dong so du//
    private final FluctuationDAO flucDAO;
    private final AccountDAO accDAO;
    private final CategoryDAO catDAO;

    public FluctuationBLL() {
        flucDAO = new FluctuationDAO();
        accDAO = new AccountDAO();
        catDAO = new CategoryDAO();
    }

    public static void main(String[] args) {
        FluctuationBLL flucBLL = new FluctuationBLL();
        double[] a = null;
        try {
            a = flucBLL.PercentCategories(LocalDate.of(2022,6,30), LocalDate.of(2022,8,1));
        } catch (SQLException ex) {
            Logger.getLogger(FluctuationBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (double i : a) {
            System.err.println(i);
        }
    }
    
    @Override
    public FluctuationDTO get(int id) throws SQLException {
        return flucDAO.get(id);
    }
    
    public FluctuationDTO[] getAll() throws SQLException{
        return flucDAO.getAll();
    }
    
    //get fluc from GUI, add category id and insert to database
    @Override
    public void addFromGUI(FluctuationDTO fluc) throws SQLException{
        int catId = catDAO.getCategoryId(fluc.getCategory());
        fluc.getCategory().setCategoryId(catId);
        flucDAO.add(fluc);
        AccountDTO acc = accDAO.get(fluc.getAccount().getId());
        if (fluc.getCategory().isIncome()) {
            acc.setBalance(acc.getBalance() + fluc.getAmount());
        } else {
            acc.setBalance(acc.getBalance() - fluc.getAmount());
        }
        accDAO.update(acc);
    }

    @Override
    public void updateFromGUI(FluctuationDTO fluc) throws SQLException{
        FluctuationDTO fluc1 = flucDAO.get(fluc.getID());//get from database to compare
        if (fluc.getCategory() == null){
            fluc.setCategory(fluc1.getCategory());
        } 
        if (fluc.getAccount().getId() == 0){
            fluc.setAccount(fluc1.getAccount());
        }
//        int catId = catDAO.getCategoryId(fluc1.getCategory());
//        fluc.getCategory().setCategoryId(catId);
        flucDAO.update(fluc);
        AccountDTO acc = accDAO.get(fluc.getAccount().getId());
        if (fluc.getCategory().isIncome()) {
            acc.setBalance(acc.getBalance() - fluc.getPreAmount() + fluc.getAmount());
        } else {
            acc.setBalance(acc.getBalance() + fluc.getPreAmount() - fluc.getAmount());
        }
        accDAO.update(acc);
    }
    
    @Override
    public void deleteFromGUI(FluctuationDTO fluc) throws SQLException {
        FluctuationDTO fluc1 = flucDAO.get(fluc.getID());    
        int catId = catDAO.getCategoryId(fluc1.getCategory());
        fluc1.getCategory().setCategoryId(catId);
        
        AccountDTO acc = accDAO.get(fluc1.getAccount().getId());
        if (fluc1.getCategory().isIncome()) {
            acc.setBalance(acc.getBalance() - fluc1.getAmount());
        } else {
            acc.setBalance(acc.getBalance() + fluc1.getAmount());
        }
        accDAO.update(acc);
        flucDAO.delete(fluc1);
    }
    
    public FluctuationDTO[] getAllByCategoryAndAccount(String catName, String accName) throws SQLException{
        FluctuationDTO[] flucList = null;
        if (accName.equals("Tất cả")){
            flucList = flucDAO.getAllByCategory(catName);
        } else {
            flucList = flucDAO.getAllByCategoryAndAccount(catName, accName);
        }
        return flucList;
    }
    /**
     * Warning if there's a chance balance < 0
     *
     * @return
     */
    public Boolean WarningBalance() throws SQLException { //canh bao
        AccountDTO acc = accDAO.get(1);
        double save_per_month = acc.getSave_per_month(); // account lấy từ database
        double balance = acc.getBalance();
        return balance - save_per_month < 0;
    }

    public double[][] SumCategories(LocalDate date1, LocalDate date2) throws SQLException{
        double[] sumInitCategories = new double[26];
        double[] sumAfterCategories = new double[26];
        
        for (int j = 1; j <= 25; j++) {
            sumInitCategories[j] = 0;
            sumAfterCategories[j] = 0;// -1 là không tồn tại
        }
        FluctuationDTO[] flucArr = flucDAO.getAll();
        for (FluctuationDTO i : flucArr) {
            if (i.getDate().isAfter(date1) && i.getDate().isBefore(date2)) {
                switch (i.getCategory().getCategoryId()) {
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 -> {
                        int j = i.getCategory().getCategoryId();
                        sumInitCategories[j] += i.getAmount();
                        break;
                    }
                }
            }
        }
        for (int j = 1; j <= 25; j++) {
            sumAfterCategories[j] = sumInitCategories[j];
        }
        for (int j = 3; j <= 9; j++) {
            sumAfterCategories[1] += sumInitCategories[j];
        }
        sumAfterCategories[10] = sumInitCategories[10] + sumInitCategories[14] + sumInitCategories[15] + sumInitCategories[16] + sumInitCategories[17] + sumInitCategories[18];
        sumAfterCategories[11] = sumInitCategories[11] + sumInitCategories[19] + sumInitCategories[20] + sumInitCategories[21] + sumInitCategories[22] + sumInitCategories[23];
        sumAfterCategories[13] = sumInitCategories[13] + sumInitCategories[24] + sumInitCategories[25];
        sumAfterCategories[2] = sumInitCategories[2] + sumAfterCategories[10] + sumAfterCategories[11] + sumAfterCategories[12] + sumAfterCategories[13];
        for (int j = 1; j<=25;j++){
                                System.err.println(j + "   " +  sumAfterCategories[j]);

        }
        double[][] sum = {sumInitCategories, sumAfterCategories};
        return sum;

    }

    public double[] PercentCategories(LocalDate date1, LocalDate date2) throws SQLException {
        double[] sumCategories = SumCategories(date1, date2)[1]; // có 25 hạng mục 
        double[] percentCategories = new double[26];
        for (int j = 1; j <= 25; j++) {
            percentCategories[j] = -1;// -1 là không tồn tại
        }
       
        for (int j = 3; j <= 9; j++) {
            percentCategories[j] = (sumCategories[j] / sumCategories[1]) * 100;

        }
        for (int j = 10; j <= 25; j++) {
            percentCategories[j] = (sumCategories[j] / sumCategories[2]) * 100;
        }
        
        return percentCategories;
    }

    public List<DatasetDTO> getStatDatasetByDate(LocalDate date1, LocalDate date2) throws SQLException {
        List<DatasetDTO> arrList = new ArrayList<DatasetDTO>();

        CategoryDTO[] listCategory = null;
        try {
            listCategory = catDAO.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        double[] percentages = null;
        double[] sum = null;
            percentages = PercentCategories(date1, date2);
            sum = SumCategories(date1, date2)[1];

        for (int i = listCategory.length - 1; i >= 0; i--) {
            if (percentages[i] > 0) {
                int n = i;
                while (n > 1) {
                    if (percentages[listCategory[n].getCategoryParentId()] == percentages[n]) {
                        n = listCategory[n].getCategoryParentId();
                    } else {
                        percentages[listCategory[n].getCategoryParentId()] -= percentages[n];
                        sum[listCategory[n].getCategoryParentId()] -= sum[n];
                        String type = "";
                        switch (listCategory[n].getCategoryType()) {
                            case 1:
                                type = "Thu";
                                break;
                            case 0:
                                type = "Chi";
                                break;
                        }
                        DatasetDTO data = new DatasetDTO(n, listCategory[n].getCategoryName(), percentages[n], (long)sum[n], type);
                        arrList.add(data);
                        break;
                    }
                }
            }
        }
        return arrList;
    }
    
    public List<FluctuationDTO> getFlucDatasetByCategoryAndAccount(String catName, String accName) throws SQLException {
        List<FluctuationDTO> arrList = new ArrayList<FluctuationDTO>();

        FluctuationDTO[] listFluc = getAllByCategoryAndAccount(catName, accName);
        
        for (int i = 0; i < listFluc.length; i++){
            arrList.add(listFluc[i]);
        }

        return arrList;
    }
    
    public List<FluctuationDTO> getAllFlucDataset() throws SQLException {
        List<FluctuationDTO> arrList = new ArrayList<FluctuationDTO>();

        FluctuationDTO[] listFluc = flucDAO.getAll();
        
        for (int i = 0; i < listFluc.length; i++){
            arrList.add(listFluc[i]);
        }

        return arrList;
    }

    /**
     * sum per month
     */
    public void SumPerMonth(int Year) throws SQLException {
        double[] sumIncome = new double[13]; // tổng thu của 12 tháng
        double[] sumSpending = new double[13]; // tổng chi của 12 tháng
        for (int j = 1; j <= 12; j++) {
            sumIncome[j] = 0;
            sumSpending[j] = 0;
        }
        FluctuationDTO[] flucArr = flucDAO.getAll();
        for (FluctuationDTO i : flucArr) {
            if (Year == i.getDate().getYear()) {
                int j = i.getDate().getMonthValue();
                if (i.getCategory().isIncome()) sumIncome[j] += i.getAmount(); // tính tổng thu từng tháng
                else sumSpending[j] += i.getAmount(); // tổng chi từng tháng
            }
        }
    }

    public double AutoCal() throws SQLException {
        AccountDTO acc = accDAO.get(1);
        Calendar cal = Calendar.getInstance();
        double balance = acc.getBalance();
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) { // sang thang moi
            FluctuationDTO[] flucArr = flucDAO.getAll();
            for (FluctuationDTO i : flucArr) {
                if (i.isFixed()) {
                    if (i.getCategory().isIncome()) balance += i.getAmount();
                    else balance -= i.getAmount();
                }
            }
        }
        return balance;
    }

    public int[] SuggestionNextMonth(LocalDate date1, LocalDate date2) throws SQLException {
        double[] percentCategories = null;
        percentCategories = PercentCategories(date1, date2);
        int[] mark = {0, 0, 0, 0};
        if (percentCategories[10] > 0.6){
            mark[0] = 1;
        } // = 1 là tiêu quá
        if (percentCategories[21] > 0.15){
            mark[1] = 1;
        }
        if (percentCategories[19] + percentCategories[22] + percentCategories[23] > 0.15){
            mark[2] = 1;
        }
        if (1 - percentCategories[10] - percentCategories[21] - percentCategories[19] - percentCategories[22] - percentCategories[23] > 0.1){
            mark[3] = 1;
        }
        return mark;
    }
}

