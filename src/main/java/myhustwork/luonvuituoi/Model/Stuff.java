
package myhustwork.luonvuituoi.Model;

/**
 *
 * @author DELL
 */
public class Stuff implements Comparable<Stuff>{
    private double price;
    private int categoryID;
    private String note;

    public Stuff(double price, int categoryID, String note) {
        this.price = price;
        this.categoryID = categoryID;
        this.note = note;
    }
    
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    public int compareTo(Stuff stuff){
        if (price == stuff.price)
            return 0;
        else if(price > stuff.price)
            return 1;
        else 
            return -1;
    }
}
