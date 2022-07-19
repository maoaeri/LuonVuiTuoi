/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import myhustwork.luonvuituoi.DAO.AccountDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;

/**
 *
 * @author vvlalalove193
 */
public class AccountBLL implements BLLInterface<AccountDTO>{
    private AccountDAO accDAO;

    public AccountBLL() {
        accDAO = new AccountDAO();
    }
    
    @Override
    public AccountDTO get(int id) throws SQLException{
        return accDAO.get(id);
    }
    
    @Override
    public AccountDTO[] getAll() throws SQLException{
        return accDAO.getAll();
    }
    
    @Override
    public void addFromGUI(AccountDTO acc) throws SQLException{
        accDAO.add(acc);
    }
    
    @Override
    public void updateFromGUI(AccountDTO acc) throws SQLException{
        accDAO.update(acc);
    }
    
    @Override
    public void deleteFromGUI(AccountDTO acc) throws SQLException{
        accDAO.delete(acc);
    }
    
    public String[] getAllNames() throws SQLException{
        String[] names = null;
        AccountDTO[] accList = accDAO.getAll();
        List<String> arrList = new ArrayList<>();
        arrList.add("Tất cả");
        for (int i = 1; i<= accList.length; i++){
            arrList.add(accList[i-1].getName());
        }
        names = arrList.toArray(new String[arrList.size()]);
        return names;
    }
}
