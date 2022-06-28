/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Model;

/**
 *
 * @author vvlalalove193
 */
public class Account {
    private String name;
    private byte age;
    private String job;
    private long balance;
    private long save_per_month; 

    public Account(String name, byte age, String job, long balance) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.balance = balance;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public byte getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(byte age) {
        this.age = age;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the balance
     */
    public long getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }
    

    public long getSave_per_month() {
        return save_per_month;
    }

    public void setSave_per_month(long save_per_month) {
        this.save_per_month = save_per_month;
    }
}

//final class Save_per_type{
//    
//}