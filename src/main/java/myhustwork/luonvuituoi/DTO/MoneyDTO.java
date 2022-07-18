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
    private CategoryDTO category;

    public MoneyDTO() {
    }

    public MoneyDTO(long amount, CategoryDTO category) {
        this.amount = amount;
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
    
}
