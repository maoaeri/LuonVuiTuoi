package myhustwork.luonvuituoi.Model;

import java.util.Date;
import java.util.Calendar;
import myhustwork.luonvuituoi.Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
        
public class Fluctuation extends Money {//bien dong so du//
    private int ID; //auto-generated
    private String note;
    private Date date;
    private int categoryID;
    private boolean fixed; //co dinh hay khong
    
    public static void main(String[] args){
        
    }
    
    public Fluctuation(double amount, String note, Date date, int categoryID, boolean fixed) {
        super(amount);
        this.note = note;
        this.date = date;
        this.categoryID = categoryID;
        this.fixed = fixed;
    }

    public int getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public boolean isFixed() {
        return fixed;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }
    public void displayFluctuation(){
        System.out.println("So tien da nhap:" + getAmount());
        System.out.println("Ghi chu:" + note);
    }
    
}

//class Date {//ngay thang nam//
//    private int day;
//    private int month;
//    private int year;
//    public Date(int day, int month, int year){
//        this.day = day;
//        this.month = month;
//        this.year = year;
//    }
//    public void displayDate(){
//       String day = this.day + "";
//       String month = this.month + "";
//       String year = this.year + "";
//       if (day.length() == 1) day = "0" + day;
//       if (month.length() == 1) month = "0" + month;
//       System.out.println("Thoi gian:" + day + "/" + month + "/" + year);
//    }
//}

//class Categories { //hang muc//
//    private String type;
//    private int result;
//    public Categories(String type){
//        this.type = type;
//    }
//    public void displayCategories(){
//		System.out.println("Hang muc: " + type);
//    }
//}

//class BankAcc { //hang muc//
//    private String bank;
//    public BankAcc(String bank){
//        this.bank = bank;
//    }
//    public void displayBankAcc(){
//		System.out.println("Tai khoan: " + bank);
//    }
//}
