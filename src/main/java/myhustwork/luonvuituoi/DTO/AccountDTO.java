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
    private static String name;
    private static byte age;
    private static String job;
    private static long balance;
    private static long save_per_month; 

    public AccountDTO() {
    }

    public static String getName() {
        return name;
    }

    public static byte getAge() {
        return age;
    }

    public static String getJob() {
        return job;
    }

    public static long getBalance() {
        return balance;
    }

    public static long getSave_per_month() {
        return save_per_month;
    }

    public static void setName(String name) {
        AccountDTO.name = name;
    }

    public static void setAge(byte age) {
        AccountDTO.age = age;
    }

    public static void setJob(String job) {
        AccountDTO.job = job;
    }

    public static void setBalance(long balance) {
        AccountDTO.balance = balance;
    }

    public static void setSave_per_month(long save_per_month) {
        AccountDTO.save_per_month = save_per_month;
    }

}
