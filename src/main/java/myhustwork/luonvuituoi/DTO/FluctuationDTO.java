/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationDTO extends MoneyDTO {
    private int ID; //auto-generated
    private String note;
    private LocalDate date;
    private CategoryDTO category;
    private boolean fixed; //co dinh hay khong

    public FluctuationDTO() {
    }

    public FluctuationDTO(int ID, String note, LocalDate date, CategoryDTO category, boolean fixed, long amount) {
        super(amount);
        this.ID = ID;
        this.note = note;
        this.date = date;
        this.category = category;
        this.fixed = fixed;
    }

    public int getID() {
        return ID;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getDate() {
        return date;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
    
    
}
