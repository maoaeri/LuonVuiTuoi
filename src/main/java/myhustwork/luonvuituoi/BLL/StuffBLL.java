package myhustwork.luonvuituoi.BLL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

import java.util.Date;
import java.util.*;
import myhustwork.luonvuituoi.BLL.FluctuationBLL;
import myhustwork.luonvuituoi.DAO.AccountDAO;
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
    private StuffDAO stuffDAO;
    private FluctuationDAO flucDAO;
    private FluctuationBLL flucBLL;
    private AccountDAO accDAO;
    
    public StuffBLL() {
        stuffDAO = new StuffDAO();
        accDAO = new AccountDAO();
        flucDAO = new FluctuationDAO();
        flucBLL = new FluctuationBLL();
    }

    public StuffDTO[] getAllStuffs() throws SQLException {
        return stuffDAO.getAll();
    }

    public void Suggestion(LocalDate date1, LocalDate date2) throws SQLException {
        double ThuThanghientai = 0, Chithanghientai = 0, Sodutrongthang = 0;

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        FluctuationDTO[] flucArr = flucDAO.getAll();
        for (FluctuationDTO i : flucArr) { //duyet tat ca cac fluctuation
            if (i.getDate().isAfter(date1) && i.getDate().isBefore(date2)) {
                if (i.getCategory().getCategoryType() == CategoryDTO.THU) {
                    ThuThanghientai += i.getAmount();
                } else {
                    Chithanghientai += i.getAmount();
                }
            }
        }
        Sodutrongthang = ThuThanghientai - Chithanghientai;
        flucBLL.PercentCategories(date1, date2);
    }

    public void Swap(StuffDTO s1, StuffDTO s2) { //Dao vi tri 
        StuffDTO tmp = new StuffDTO(s1.getID(),s1.getCategory(), s1.getNote(), s1.getAmount());
        s1.setAmount(s2.getAmount());
        s1.setCategory(s2.getCategory());
        s1.setNote(s2.getNote());
        s2.setAmount(tmp.getAmount());
        s2.setCategory(tmp.getCategory());
        s2.setNote(tmp.getNote());
    }

    public StuffDTO[] StuffSuggestion(StuffDTO[] stuff) {
        AccountDTO acc = accDAO.get(1);
        int n = stuff.length;
//        StuffDTO[] stuff = new StuffDTO[n]; // n: so stuff can mua
        //Lay ra tu database
        Arrays.sort(stuff);
        for (StuffDTO i : stuff) {
            /*
            20:Suc khoe
            21:Cong viec hoc tap
            22:Giai tri
            25:Tra no
             */
            if (i.getCategory().getCategoryId() == 25 && i.getAmount() < acc.getBalance() && stuff[0].getCategory().getCategoryId() != 25) {
                //Tra no 
                Swap(i, stuff[0]);
                if (stuff[2].getCategory().getCategoryId() == 22 || stuff[2].getCategory().getCategoryId() == 21) {
                    Arrays.sort(stuff, 3, n - 1);
                } else if (stuff[1].getCategory().getCategoryId() == 20) {
                    Arrays.sort(stuff, 2, n - 1);
                } else {
                    Arrays.sort(stuff, 1, n - 1);
                }
            }
            if (i.getCategory().getCategoryId() == 20 && i.getAmount() < acc.getBalance()) {
                //Suc khoe 
                Swap(i, stuff[1]);
                Arrays.sort(stuff, 2, n - 1);
            }
            if (i.getCategory().getCategoryId() == 22 & i.getAmount() < acc.getBalance()) {
                // Giai tri
                if (stuff[0].getCategory().getCategoryId() == 25 && stuff[1].getCategory().getCategoryId() == 20) {
                    Swap(i, stuff[2]);
                    Arrays.sort(stuff, 3, n - 1);
                } else if (stuff[0].getCategory().getCategoryId() != 25 && stuff[1].getCategory().getCategoryId() == 20) {
                    Swap(i, stuff[0]);
                    Arrays.sort(stuff, 2, n - 1);
                } else {
                    Swap(i, stuff[1]);
                    Arrays.sort(stuff, 2, n - 1);
                }
            }
            if (i.getCategory().getCategoryId() == 21 && i.getAmount() < 4 * stuff[2].getAmount()) {
                //Cong viec hoc tap
                Swap(i, stuff[2]);
            }
        }
        for (StuffDTO i : stuff) {
            if (i.getCategory().getCategoryId() == 24) {
                Swap(i, stuff[n - 1]);
            }
        }
    return stuff;
    }

    public int[] SuggestionNextMonth(LocalDate date1, LocalDate date2) throws SQLException {
        double[] percentCategories = new double[26];
        percentCategories = flucBLL.PercentCategories(date1, date2);
        int[] mark = {0, 0, 0, 0};
        if (percentCategories[10] > 0.6) {
            mark[0] = 1; // = 1 là tiêu quá
        }
        if (percentCategories[21] > 0.15) {
            mark[1] = 1;
        }
        if (percentCategories[19] + percentCategories[22] + percentCategories[23] > 0.15) {
            mark[2] = 1;
        }
        if (1 - percentCategories[10] - percentCategories[21] - percentCategories[19] - percentCategories[22] - percentCategories[23] > 0.1) {
            mark[3] = 1;
        }
        return mark;
        //in ra màn hình: bạn đã tiêu quá (những cái mark[] = 1) , bạn hãy tiêu thêm vào (những cái mark[] = 0)
    }
}
