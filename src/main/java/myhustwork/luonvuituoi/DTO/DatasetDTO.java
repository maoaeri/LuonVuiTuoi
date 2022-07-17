/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

import com.google.protobuf.Value;

/**
 *
 * @author vvlalalove193
 */
public class DatasetDTO {
    private int Id;
    private String name;
    private double value;
    private long amount;

    public DatasetDTO(int Id, String name, double value, long amount) {
        this.Id = Id;
        this.name = name;
        this.value = value;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getId() {
        return Id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
