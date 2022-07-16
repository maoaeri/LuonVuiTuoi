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
    private long amount;

    public MoneyDTO() {
    }

    public MoneyDTO(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    
}
