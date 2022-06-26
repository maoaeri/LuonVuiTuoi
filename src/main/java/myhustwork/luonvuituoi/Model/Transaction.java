
package myhustwork.luonvuituoi.Model;


public class Transaction {  
	public static void main(String[] args) {
	    Categories c = new Categories("Trang phuc");
		c.displayCategories();
		BankAcc b = new BankAcc("Agribank");
		b.displayBankAcc();
		Date d = new Date(7, 6, 2022);
		d.displayDate();
		Fluctuation f = new Fluctuation(100000, "Tien mua sam quan ao");
		f.displayFluctuation();
	}
    }


class Fluctuation {//bien dong so du//
    private double amount;
    private String note;
    
    public Fluctuation(double amount, String note){
        this.amount = amount;
        this.note = note;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }
    public void displayFluctuation(){
        System.out.println("So tien da nhap:" + amount);
        System.out.println("Ghi chu:" + note);
    }
}

class Date {//ngay thang nam//
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void displayDate(){
       String day = this.day + "";
       String month = this.month + "";
       String year = this.year + "";
       if (day.length() == 1) day = "0" + day;
       if (month.length() == 1) month = "0" + month;
       System.out.println("Thoi gian:" + day + "/" + month + "/" + year);
    }
}

class Categories { //hang muc//
    private String type;
    private int result;
    public Categories(String type){
        this.type = type;
    }
    public void displayCategories(){
		System.out.println("Hang muc: " + type);
    }
}

class BankAcc { //hang muc//
    private String bank;
    public BankAcc(String bank){
        this.bank = bank;
    }
    public void displayBankAcc(){
		System.out.println("Tai khoan: " + bank);
    }
}
