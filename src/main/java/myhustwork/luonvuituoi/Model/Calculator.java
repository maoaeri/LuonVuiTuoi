/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Model;

/**
 * 
 * @author vvlalalove193
 */
public class Calculator {
    System.out.println("Hello");
    public static Boolean WarningBalance(double balance) { //canh bao
        return balance < 0;
    }
    public static void PercentCategories(int Month) {
        double sum;
        double[] sumCategories = new double[12];
        double[] percentCategories = new double[12];
        int i;
        if(Transaction.Date.getMonth == Month){
            sum += Transaction.Fluctuation.getAmount;
            i = Transaction.Categories.getResult;
            sumCategories[i] += Transaction.Fluctuation.getAmount;
        }
        for(int i = 0; i < 12; i++) {
            percentCategories[i] = sumCategories[i]/sum;
        }
    }
}
