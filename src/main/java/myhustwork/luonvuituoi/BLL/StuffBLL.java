
package myhustwork.luonvuituoi.BLL;
import java.util.Date;
import java.util.Calendar;

import java.util.Date;
import java.util.*;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.DTO.StuffDTO;


/**
 * 
 * @author vvlalalove193
 */
public class StuffBLL {
    
    public StuffDTO[] getAllStuffs(){
        return StuffDAO.getAllStuffs();
    }
    
    public void Suggestion(Date date1,Date date2){
        double ThuThanghientai = 0,Chithanghientai = 0,Sodutrongthang = 0;
        
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        FluctuationDTO[] flucArr = FluctuationDAO.getAllFluctuations();        
        for(FluctuationDTO i: flucArr){ //duyet tat ca cac fluctuation
            if (i.getDate().after(date1) && i.getDate().before(date2) ) {
                if(i.getCategory().getCategoryType() == CategoryDTO.THU) {
                    ThuThanghientai += i.getAmount();
                } else {
                    Chithanghientai += i.getAmount();
                }
            }
        }   
        Sodutrongthang = ThuThanghientai - Chithanghientai;
        FluctuationBLL.PercentCategories(date1,date2);
    }
    
    public void Swap(StuffDTO s1,StuffDTO s2){ //Dao vi tri 
        StuffDTO tmp = new StuffDTO(s1.getCategory(), s1.getNote(), s1.getAmount());
        s1.setAmount(s2.getAmount()); s1.setCategory(s2.getCategory()); s1.setNote(s2.getNote());
        s2.setAmount(tmp.getAmount()); s2.setCategory(tmp.getCategory()); s2.setNote(tmp.getNote());
    }
    
    public void StuffSuggestion(StuffDTO[] stuff){
        int n = stuff.length;
//        StuffDTO[] stuff = new StuffDTO[n]; // n: so stuff can mua
        //Lay ra tu database
        Arrays.sort(stuff);
        for(StuffDTO i: stuff){
            /*
            20:Suc khoe
            21:Cong viec hoc tap
            22:Giai tri
            25:Tra no
            */
            if(i.getCategory().getCategoryId()== 25 && i.getAmount()< AccountDTO.getBalance() && stuff[0].getCategory().getCategoryId()!=25){ 
            //Tra no 
                Swap(i,stuff[0]);
                if(stuff[2].getCategory().getCategoryId()==22 || stuff[2].getCategory().getCategoryId()==21){
                    Arrays.sort(stuff,3,n-1);
                }
                else if(stuff[1].getCategory().getCategoryId()==20){
                    Arrays.sort(stuff,2,n-1);
                }
                else{
                    Arrays.sort(stuff,1,n-1);
                }
            }
            if(i.getCategory().getCategoryId()== 20 && i.getAmount()< AccountDTO.getBalance()){
            //Suc khoe 
                    Swap(i,stuff[1]);
                    Arrays.sort(stuff,2,n-1);   
            }
            if(i.getCategory().getCategoryId()== 22 & i.getAmount()< AccountDTO.getBalance()){
            // Giai tri
               if(stuff[0].getCategory().getCategoryId()==25 && stuff[1].getCategory().getCategoryId()==20){
                   Swap(i,stuff[2]);
                   Arrays.sort(stuff,3,n-1);
               }
               else if(stuff[0].getCategory().getCategoryId()!=25 && stuff[1].getCategory().getCategoryId()==20){
                   Swap(i,stuff[0]);
                   Arrays.sort(stuff,2,n-1); 
               }
               else {
                   Swap(i,stuff[1]);
                   Arrays.sort(stuff,2,n-1);
               }
            }
            if(i.getCategory().getCategoryId()==21 && i.getAmount()< 4*stuff[2].getAmount()){
                //Cong viec hoc tap
                Swap(i,stuff[2]);
            }   
        }
        for(StuffDTO i: stuff){
            if(i.getCategory().getCategoryId()==24) Swap(i,stuff[n-1]);
        }
    }
}
