package myhustwork.luonvuituoi.BLL;

import java.util.Date;
import java.util.Calendar;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.DTO.MoneyDTO;

public class FluctuationBLL extends MoneyDTO {//bien dong so du//

    /**
     * Warning if there's a chance balance < 0
     *
     * @return
     */
    public static Boolean WarningBalance() { //canh bao
        double save_per_month = AccountDTO.getSave_per_month(); // account lấy từ database
        double balance = AccountDTO.getBalance();
        return balance - save_per_month < 0;
    }

    public static double[] PercentCategories(Date date1, Date date2) {
        double[] sumCategories = new double[26]; // có 25 hạng mục 
        double[] percentCategories = new double[26];
        for (int j = 1; j <= 25; j++) {
            sumCategories[j] = 0;
            percentCategories[j] = -1; // -1 là không tồn tại
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();
        for (FluctuationDTO i : flucArr) {
            if (i.getDate().after(date1) && i.getDate().before(date2)) {
                switch (i.getCategory().getCategoryId()) {
                    case 3, 4, 5, 6, 7, 8, 9, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 -> {
                        int j = i.getCategory().getCategoryId();
                        sumCategories[j] += i.getAmount();
                        break;
                    }
                }
                for (int j = 3; j <= 9; j++) {
                    sumCategories[1] += sumCategories[j];
                }
                sumCategories[10] = sumCategories[14] + sumCategories[15] + sumCategories[16] + sumCategories[17] + sumCategories[18];
                sumCategories[11] = sumCategories[19] + sumCategories[20] + sumCategories[21] + sumCategories[22] + sumCategories[23];
                sumCategories[13] = sumCategories[24] + sumCategories[25];
                sumCategories[2] = sumCategories[10] + sumCategories[11] + sumCategories[12] + sumCategories[13];

                for (int j = 3; j <= 9; j++) {
                    percentCategories[j] = sumCategories[j] / sumCategories[1];
                }
                for (int j = 10; j <= 25; j++) {
                    percentCategories[j] = sumCategories[j] / sumCategories[2];
                }
            }
        }
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
    public static void SumPerMonth(int Year) {
        double[] sumIncome = new double[13]; // tổng thu của 12 tháng
        double[] sumSpending = new double[13]; // tổng chi của 12 tháng
        for (int j = 1; j <= 12; j++) {
            sumIncome[j] = 0;
            sumSpending[j] = 0;
        }
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();
        for (FluctuationDTO i : flucArr) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(i.getDate()); // chuyển Date thành Calendar
            if (Year == cal.get(Calendar.YEAR)) {
                int j = cal.get(Calendar.MONTH);
                if (i.getCategory().isIncome()) {
                    sumIncome[j] += i.getAmount(); // tính tổng thu từng tháng
                } else {
                    sumSpending[j] += i.getAmount(); // tổng chi từng tháng
                }
            }
        }
    }

    public static double AutoCal() {
        Calendar cal = Calendar.getInstance();
        double balance = AccountDTO.getBalance();
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) { // sang thang moi
            FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();
            for (FluctuationDTO i : flucArr) {
                if (i.isFixed()) {
                    if (i.getCategory().isIncome()) {
                        balance += i.getAmount();
                    } else {
                        balance -= i.getAmount();
                    }
                }
            }
        }
        return balance;
    }

}
