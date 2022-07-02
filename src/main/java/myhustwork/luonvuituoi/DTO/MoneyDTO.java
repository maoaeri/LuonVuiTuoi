/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 *
 * @author vvlalalove193
 */
public class MoneyDTO {
    private double amount;

    public MoneyDTO() {
    }

    public MoneyDTO(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    /**
     * 
     * @param strFormat in String
     * @return Amount in double
     * @throws java.text.ParseException
     */
    public static double formatAmount(String strFormat) throws ParseException{
        double d = DecimalFormat.getNumberInstance().parse(strFormat).doubleValue();
        return d;
    }
}
