
package myhustwork.luonvuituoi.Model;
import java.util.Date;
import java.util.Calendar;

/**
 * 
 * @author vvlalalove193
 */
public class Calculator {
    public static Boolean WarningBalance(double balance) { //canh bao
        return balance < 0;
    }
    public static void PercentCategories(Date date1, Date date2) {
        double sum = 0;
        double[] sumCategories = new double[12]; //gia su co 12 CategoryID
        double[] percentCategories = new double[12];
        int m;
        for(Fluctuation i: arr){
            if (i.getDate().after(date1) && i.getDate().before(date2) ){
            sum += i.getAmount();
            m = i.getCategoryID();
            sumCategories[m] += i.getAmount();
        }
        for(m = 0; m < 12; m++) {
            percentCategories[m] = sumCategories[m]/sum;
        }
    }
    public static void SumPerMonth(int Year) {
        double sum = 0;
        for(Fluctuation )
        if(Fluctuation.Date.getYear() == Year) {
            
        }
    }
    public void Suggestion(){
        double ThuThanghientai = 0,Chithanghientai = 0,Sodutrongthang = 0;
        
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        
        for(Fluctuation i: arr){ //duyet tat ca cac fluctuation
            if(i.getDate().get(Calendar.DAY_OF_MONTH) > cal.getActualMinimum(Calendar.DATE) && i.getDate().get(Calendar.DAY_OF_MONTH) < cal.getActualMaximum(Calendar.DATE))
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
        for(RemainingStuff a: arr){// duyet cac mon do can mua
            if(a.getAmount()<Sodutrongthang)
        }
    }
        
                
      
 

