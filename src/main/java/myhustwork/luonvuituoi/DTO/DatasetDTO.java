/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

/**
 *
 * @author vvlalalove193
 */
public class DatasetDTO {
    private int Id;
    private String name;
    private double value;
    private long amount;
    private String type;

    public DatasetDTO(int Id, String name, double value, long amount, String type) {
        this.Id = Id;
        this.name = name;
        this.value = value;
        this.amount = amount;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
