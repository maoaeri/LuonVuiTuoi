/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class AccountDAO implements DAOInterface<AccountDTO> {
    
    public AccountDAO(){
    }
    
    public static void main(String[] args){
        AccountDTO acc = null;
        AccountDAO ad = new AccountDAO();
        acc = ad.get(1);
        System.out.print(acc);
        if (acc == null){
            System.out.print("hihi");
        }
    }

    @Override
    public int add(AccountDTO acc) throws SQLException {
        int res = 0;
        String query = "INSERT INTO main.account(account_name, account_age, account_job, account_balance, account_save_per_month) VALUES(?,?,?,?,?)";
        Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, acc.getName());
        ps.setInt(2, acc.getAge());
        ps.setString(3, acc.getJob());
        ps.setLong(4, acc.getBalance());
        ps.setLong(5, acc.getSave_per_month());
        res = ps.executeUpdate();
        conn.close();
        return res;
    }

    @Override
    public int update(AccountDTO acc) throws SQLException {
        int res = 0;
        String query = "UPDATE main.account SET account_name = ?, account_age = ?, account_balance = ?, account_save_per_month = ? WHERE account_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, acc.getName());
            ps.setInt(2, acc.getAge());
            ps.setString(3, acc.getJob());
            ps.setLong(4, acc.getBalance());
            ps.setLong(5, acc.getSave_per_month());
            ps.setInt(6, acc.getId());
            res = ps.executeUpdate();
            conn.close();
        return res;
    }

    @Override
    public int delete(AccountDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AccountDTO get(int id){

            String query = "SELECT * from main.account where account_id = ?";
            AccountDTO acc = null;
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()){
                acc = new AccountDTO();
                acc.setName(rs.getString("account_name"));
                acc.setAge(rs.getByte("account_age"));
                acc.setJob(rs.getString("account_job"));
                acc.setBalance(rs.getLong("account_balance"));
                acc.setSave_per_month(rs.getLong("account_save_per_month"));
            }
            conn.close();
  
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc; 
    }

    @Override
    public AccountDTO[] getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
