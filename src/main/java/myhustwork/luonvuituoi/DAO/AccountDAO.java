/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class AccountDAO implements DAOInterface<AccountDTO> {
    
    public AccountDAO(){
    }
    
    @Override
    public void add(AccountDTO acc) throws SQLException {
        String query = "INSERT INTO main.account(account_name, account_balance, account_save_per_month) VALUES(?,?,?)";
        Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, acc.getName());
        ps.setLong(2, acc.getBalance());
        ps.setLong(3, acc.getSave_per_month());
        ps.executeUpdate();
        conn.close();
    }

    @Override
    public void update(AccountDTO acc) throws SQLException {
        String query = "UPDATE main.account SET account_name = ?, account_balance = ?, account_save_per_month = ? WHERE account_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, acc.getName());
            ps.setLong(2, acc.getBalance());
            ps.setLong(3, acc.getSave_per_month());
            ps.setInt(4, acc.getId());
            ps.executeUpdate();
            conn.close();
    }

    @Override
    public void delete(AccountDTO acc) throws SQLException {
        String query = "DELETE FROM main.account WHERE account_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, acc.getId());
            ps.executeUpdate();
            conn.close();
    }

    @Override
    public AccountDTO get(int id) throws SQLException{

            String query = "SELECT * from main.account where account_id = ?";
            AccountDTO acc = null;
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()){
                acc = new AccountDTO();
                acc.setId(id);
                acc.setName(rs.getString("account_name"));
                acc.setBalance(rs.getLong("account_balance"));
                acc.setSave_per_month(rs.getLong("account_save_per_month"));
            }
            conn.close();
        return acc; 
    }

    @Override
    public AccountDTO[] getAll() throws SQLException {
        AccountDTO[] dataset = null;
        AccountDTO acc;
        List<AccountDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.account";
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                acc = new AccountDTO();
                acc.setId(rs.getInt("account_id"));
                acc.setName(rs.getString("account_name"));
                acc.setBalance(rs.getLong("account_balance"));
                acc.setSave_per_month(rs.getLong("account_save_per_month"));
                arrlist.add(acc);
            }
        dataset = arrlist.toArray(new AccountDTO[arrlist.size()]);
        return dataset;
    }    
}
    
