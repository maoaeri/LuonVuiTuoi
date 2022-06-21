/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Model;

// import java.util.Date

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
        for(int i = o; i < 12; i++) {
            percentCategories[i] = sumCategories[i]/sum;
        }
    }
    public static void SumPerMonth(int Year) {
        double sum;
        if(Fluctuation.Date.getYear() == Year) {
            
        }
    }
    
}
