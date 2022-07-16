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
public class AccountDTO {
    private int Id;
    private String name;
    private byte age;
    private String job;
    private long balance;
    private long save_per_month; 

    public AccountDTO() {
    }
    
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public long getBalance() {
        return balance;
    }

    public long getSave_per_month() {
        return save_per_month;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setSave_per_month(long save_per_month) {
        this.save_per_month = save_per_month;
    }

}
