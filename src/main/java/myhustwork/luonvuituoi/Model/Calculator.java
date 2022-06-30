package myhustwork.luonvuituoi.Model;

import java.util.Date;
import java.util.Calendar;

import java.util.Date;


/**
 * 
 * @author vvlalalove193
 */
public class Calculator {
    public static Boolean WarningBalance() { //canh bao
        double save_per_month = account.getSave_Per_Month(); // account lấy từ database
        double balance = account.getBalance();
        return balance - save_per_month < 0;
    }
    
    public static void PercentCategories(Date date1, Date date2) {
        double sum = 0;
        double[] sumCategories = new double[12]; //gia su co 12 CategoryID
        double[] percentCategories = new double[12];
        int j;
        for(Fluctuation i: arr) {
            if(i.getDate().after(date1) && i.getDate().before(date2) ){
                sum += i.getAmount();
                j = i.getCategoryID();
                sumCategories[j] += i.getAmount();
            }
            for(j = 0; j < 12; j++) {
                percentCategories[j] = sumCategories[j]/sum;
            }
        }
    }
    
    public static void SumPerMonth(int Year) {
        double[] sumIncome = new double[13]; // tổng thu của 12 tháng
        double[] sumSpending = new double[13]; // tổng chi của 12 tháng
        for(int j = 1; j <= 12; j ++){
            sumIncome[j] = 0;
            sumSpending[j] = 0;
        }
        for(Fluctuation i: arr) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(i.getDate()); // chuyển Date thành Calendar
            if(Year == cal.get(Calendar.YEAR) ) {
                int j = cal.get(Calendar.MONTH);
                if(i.isIncome()) sumIncome[j] += i.getAmount(); // tính tổng thu từng tháng
                else sumSpending[j] += i.getAmount(); // tổng chi từng tháng
            }
        }
    }
    
    public static double AutoCal() {
        Calendar cal = Calendar.getInstance();
        double balance = account.getBalance();
        if(cal.get(Calendar.DAY_OF_MONTH) == 1){ // sang thang moi
            for(Fluctuation i: arr) {
                if(i.isFixed()) {
                    if(i.isIncome()) balance += i.getAmount();
                    else balance -= i.getAmount();
                }
            }
        } 
        return balance;
    }
    
    public void Suggestion(){
        double ThuThanghientai = 0,Chithanghientai = 0,Sodutrongthang = 0;
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        for(Fluctuation i: arr){ //duyet tat ca cac fluctuation
            if(i.getDate().get(Calendar.DAY_OF_MONTH) > cal.getActualMinimum(Calendar.DATE) && i.getDate().get(Calendar.DAY_OF_MONTH) < cal.getActualMaximum(Calendar.DATE))
            {
                if(i.Category.CategoryType == 1)
                {
                    ThuThanghientai += i.getAmount();
                }
                else
                {
                    Chithanghientai += i.getAmount();
                }
            }
        }
        Sodutrongthang = ThuThanghientai - Chithanghientai;
    }
