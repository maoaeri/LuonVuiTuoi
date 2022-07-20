/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

/**
 *
 * @author vvlalalove193
 */
public class AccountDTO {
    private int Id;
    private String name;
    private long balance;
    private long save_per_month; 

    public AccountDTO() {
    }

    public AccountDTO(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
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

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setSave_per_month(long save_per_month) {
        this.save_per_month = save_per_month;
    }

}
