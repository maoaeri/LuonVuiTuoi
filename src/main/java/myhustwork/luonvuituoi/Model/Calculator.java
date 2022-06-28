/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Model;
import java.util.Date;
import java.util.Calendar;

/**
 * 
 * @author vvlalalove193
 */
public class Calculator {
    public static Boolean WarningBalance(double balance) { //canh bao
        return balance < 0;
    }
    public static void PercentCategories(Date date1, Date date2) {
        double sum;
        double[] sumCategories = new double[12]; //gia su co 12 CategoryID
        double[] percentCategories = new double[12];
        int i;
        if(Fluctuation.Date.after(date1) && Fluctuation.Date.before(date2) ){
            sum += Fluctuation.getAmount;
            i = Fluctuation.getCategoryID;
            sumCategories[i] += Fluctuation.getAmount;
        }
        for(int i = 0; i < 12; i++) {
            percentCategories[i] = sumCategories[i]/sum;
        }
    }
    public static void SumPerMonth(int Year) {
        double sum;
        if(Fluctuation.Date.getYear() == Year) {
            
        }
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
