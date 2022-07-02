
package myhustwork.luonvuituoi.Model;
import java.util.Date;
import java.util.Calendar;

import java.util.Date;
import java.util.*;


/**
 * 
 * @author vvlalalove193
 */
public class Calculator {
    public static Boolean WarningBalance(double balance) { //canh bao
        return balance < 0;
    }
    public static void PercentCategories(Date date1, Date date2) {
        double sumIncome = 0;
        double sumSpending = 0;
        double[] sumCategoriesIncome = new double[12]; //gia su co 12 CategoryID
        double[] sumCategoriesSpending = new double[12];
        double[] percentCategoriesIncome = new double[12];
        double[] percentCategoriesSpending = new double[12];
        int j;
        for(int i = 0; i < 12; i++) {
            sumCategoriesIncome[i] = 0;
            sumCategoriesSpending[i] = 0;
        }
        for(Fluctuation i: arr) {
            if(i.getDate().after(date1) && i.getDate().before(date2) ){
                if(i.isIncome()) {
                    sumIncome += i.getAmount();
                    j = i.getCategoryID();
                    sumCategoriesIncome[j] += i.getAmount();
                }
                else {
                    sumSpending += i.getAmount();
                    j = i.getCategoryID();
                    sumCategoriesSpending[j] += i.getAmount();
                }
            }
            for(j = 0; j < 12; j++) {
                percentCategoriesIncome[j] = sumCategoriesIncome[j]/sumIncome;
                percentCategoriesSpending[j] = sumCategoriesSpending[j]/sumSpending;
            }
        }
    }
    
    public static void SumPerMonth(int Year) {
        double sum = 0;
        for(Fluctuation )
        if(Fluctuation.Date.getYear() == Year) {
            
        }
    }
    
    public static double AutoCal() {
        Calendar cal = Calendar.getInstance();
        double balance = account.getBalance();
        if(cal.get(Calendar.DAY_OF_MONTH) == 1){ // sang thang moi
            for(Fluctuation i: arr) {
                if(i.isFixed()) {
                    if(i.isIncome()) balance += i.getAmount();
                    else balance -= i.getAmount();
                }
            }
        } 
        return balance;
    }
    
    public void Suggestion(){
        double ThuThanghientai = 0,Chithanghientai = 0,Sodutrongthang = 0;
        
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        
        for(Fluctuation i: arr){ //duyet tat ca cac fluctuation
            if (i.getDate().after(date1) && i.getDate().before(date2) ){
            {
                if(i.Category.CategoryType == 1)
                {
                    ThuThanghientai += i.getAmount();
                }
                else
                {
                    Chithanghientai += i.getAmount();
                }
            }
        }
        Sodutrongthang = ThuThanghientai - Chithanghientai;
        PercentCategories(date1,date2);
        }
    }
    public void Swap(Stuff s1,Stuff s2){ //Dao vi tri 
        Stuff tmp = new Stuff(s1.getPrice(), s1.getCategoryID(), s1.getNote());
        s1.setPrice(s2.getPrice()); s1.setCategoryID(s2.getCategoryID()); s1.setNote(s2.getNote());
        s2.setPrice(tmp.getPrice()); s2.setCategoryID(tmp.getCategoryID()); s2.setNote(tmp.getNote());
    }
    public void StuffSuggestion(){
        int n;
        Stuff[] stuff = new Stuff[n]; // n: so stuff can mua
        //Lay ra tu database
        Arrays.sort(stuff);
        for(Stuff i: stuff){
            /*
            20:Suc khoe
            21:Cong viec hoc tap
            22:Giai tri
            25:Tra no
            */
            if(i.getCategoryID()== 25 && i.getPrice()< account.getBalance() && stuff[0].getCategoryID()!=25){ 
            //Tra no 
                Swap(i,stuff[0]);
                if(stuff[2].getCategoryID()==22 || stuff[2].getCategoryID()==21){
                    Arrays.sort(stuff,3,n-1);
                }
                else if(stuff[1].getCategoryID()==20){
                    Arrays.sort(stuff,2,n-1);
                }
                else{
                    Arrays.sort(stuff,1,n-1);
                }
            }
            if(i.getCategoryID()== 20 && i.getPrice()< account.getBalance()){
            //Suc khoe 
                    Swap(i,stuff[1]);
                    Arrays.sort(stuff,2,n-1);   
            }
            if(i.getCategoryID()== 22 & i.getPrice()< account.getBalance()){
            // Giai tri
               if(stuff[0].getCategoryID()==25 && stuff[1].getCategoryID()==20){
                   Swap(i,stuff[2]);
                   Arrays.sort(stuff,3,n-1);
               }
               else if(stuff[0].getCategoryID()!=25 && stuff[1].getCategoryID()==20){
                   Swap(i,stuff[0]);
                   Arrays.sort(stuff,2,n-1); 
               }
               else {
                   Swap(i,stuff[1]);
                   Arrays.sort(stuff,2,n-1);
               }
            }
            if(i.getCategoryID()==21 && i.getPrice()< 4*stuff[2].getPrice()){
                //Cong viec hoc tap
                Swap(i,stuff[2]);
            }   
        }
        for(Stuff i: stuff){
            if(i.getCategoryID()==24) Swap(i,stuff[n-1]);
        }
    }
}
