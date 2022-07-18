/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

//import myhustwork.luonvuituoi.BLL.Stuff;

/**
 *
 * @author vvlalalove193
 */
public class StuffDTO extends MoneyDTO implements Comparable<StuffDTO>{
    private int ID;
    private String note;

    public StuffDTO() {
        super();
    }

    public StuffDTO(int ID, CategoryDTO category, String note, long amount) {
        super(amount, category);
        this.ID = ID;
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public int compareTo(StuffDTO stuff){
        if (super.getAmount() == stuff.getAmount())
            return 0;
        else if(super.getAmount() > stuff.getAmount())
            return 1;
        else 
            return -1;
    }    
}
