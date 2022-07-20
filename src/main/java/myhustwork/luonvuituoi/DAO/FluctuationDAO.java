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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationDAO implements DAOInterface<FluctuationDTO>{    
    public FluctuationDAO() {
    }
    
    @Override
    public void add(FluctuationDTO fluc) throws SQLException {
        String query = "INSERT INTO main.fluctuation(fluctuation_amount, fluctuation_note, fluctuation_date, category_id, fluctuation_is_fixed, account_id, pre_amount) VALUES(?,?,?,?,?, ?, ?)";
        Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, fluc.getAmount());
        ps.setString(2, fluc.getNote());
        ps.setDate(3, java.sql.Date.valueOf(fluc.getDate()));
        ps.setInt(4, fluc.getCategory().getCategoryId());
        ps.setBoolean(5, fluc.isFixed());
        ps.setInt(6, fluc.getAccount().getId());
        ps.setLong(7, 0);
        ps.executeUpdate();
        conn.close();
    }
    
    @Override
    public void update(FluctuationDTO fluc) throws SQLException{
        String query = "UPDATE main.fluctuation SET fluctuation_amount = ?, fluctuation_note = ?, fluctuation_date = ?, category_id = ?, fluctuation_is_fixed = ?, account_id = ?, pre_amount = ? WHERE fluctuation_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, fluc.getAmount());
            ps.setString(2, fluc.getNote());
            ps.setDate(3, java.sql.Date.valueOf(fluc.getDate()));
            ps.setInt(4, fluc.getCategory().getCategoryId());
            ps.setBoolean(5, fluc.isFixed());
            ps.setInt(8, fluc.getID());
            ps.setInt(6, fluc.getAccount().getId());
            ps.setLong(7, get(fluc.getID()).getAmount());
            ps.executeUpdate();
            conn.close();
    }
    
    @Override
    public void delete(FluctuationDTO fluc) throws SQLException{
        String query = "DELETE FROM main.fluctuation WHERE fluctuation_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, fluc.getID());
            ps.executeUpdate();
            conn.close();
    }
    
    @Override
    public FluctuationDTO get(int id) throws SQLException{
        FluctuationDTO fluc = null;
        String query = "SELECT * FROM main.fluctuation LEFT JOIN main.category ON main.fluctuation.category_id = main.category.category_id WHERE fluctuation_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int flucId = rs.getInt("fluctuation_id");
                long flucAmount = rs.getLong("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                boolean flucFixed = rs.getBoolean("fluctuation_is_fixed");
                int flucAccountId = rs.getInt("account_id");
                AccountDAO accDAO = new AccountDAO();
                AccountDTO flucAccount = accDAO.get(flucAccountId);
                fluc = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount, flucAccount);
                fluc.setPreAmount(rs.getLong("pre_amount"));
            }
            conn.close();
        return fluc;
    }
    
    @Override
    public FluctuationDTO[] getAll() throws SQLException{
        FluctuationDTO[] dataset = null;
        FluctuationDTO data;
        List<FluctuationDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.fluctuation LEFT JOIN main.category ON main.fluctuation.category_id = main.category.category_id ORDER BY fluctuation_id DESC";
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int flucId = rs.getInt("fluctuation_id");
                long flucAmount = rs.getLong("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                boolean flucFixed = rs.getBoolean("fluctuation_is_fixed");
                int flucAccountId = rs.getInt("account_id");
                AccountDAO accDAO = new AccountDAO();
                AccountDTO flucAccount = accDAO.get(flucAccountId);
                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount, flucAccount);
                data.setPreAmount(rs.getLong("pre_amount"));
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new FluctuationDTO[arrlist.size()]);
        return dataset;
    }
    
    public FluctuationDTO[] getAllByCategoryAndAccount(String catName, String accName) throws SQLException{
        FluctuationDTO[] dataset = null;
        FluctuationDTO data;
        List<FluctuationDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.fluctuation LEFT JOIN main.category ON main.fluctuation.category_id = main.category.category_id LEFT JOIN main.account ON main.fluctuation.account_id = main.account.account_id WHERE category_name = ? AND account_name = ? ORDER BY fluctuation_id DESC";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, catName);
            ps.setString(2, accName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int flucId = rs.getInt("fluctuation_id");
                long flucAmount = rs.getLong("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                boolean flucFixed = rs.getBoolean("fluctuation_is_fixed");
                int flucAccountId = rs.getInt("account_id");
                AccountDAO accDAO = new AccountDAO();
                AccountDTO flucAccount = accDAO.get(flucAccountId);
                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount, flucAccount);
                data.setPreAmount(rs.getLong("pre_amount"));
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new FluctuationDTO[arrlist.size()]);
        return dataset;
    }
    
    public FluctuationDTO[] getAllByCategory(String catName) throws SQLException{
        FluctuationDTO[] dataset = null;
        FluctuationDTO data;
        List<FluctuationDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.fluctuation LEFT JOIN main.category ON main.fluctuation.category_id = main.category.category_id WHERE main.category.category_name = ? ORDER BY fluctuation_id DESC";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, catName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int flucId = rs.getInt("fluctuation_id");
                long flucAmount = rs.getLong("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                boolean flucFixed = rs.getBoolean("fluctuation_is_fixed");
                int flucAccountId = rs.getInt("account_id");
                AccountDAO accDAO = new AccountDAO();
                AccountDTO flucAccount = accDAO.get(flucAccountId);
                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount, flucAccount);
                data.setPreAmount(rs.getLong("pre_amount"));
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new FluctuationDTO[arrlist.size()]);
        return dataset;
    }
    
//    public FluctuationDTO[] getAllInSpecificMonth(int month) throws SQLException{
//        FluctuationDTO[] dataset = null;
//        FluctuationDTO data;
//        List<FluctuationDTO> arrlist = new ArrayList<>();
//        String query = "SELECT * FROM main.fluctuation LEFT JOIN main.category ON main.fluctuation.category_id = main.category.category_id WHERE month(main.fluctuation_date) = ? ORDER BY fluctuation_id DESC";
//            Connection conn = createConnection();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery(query);
//            while (rs.next()){
//                int flucId = rs.getInt("fluctuation_id");
//                long flucAmount = rs.getLong("fluctuation_amount");
//                String flucNote = rs.getString("fluctuation_note");
//                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
//                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
//                boolean flucFixed = rs.getBoolean("fluctuation_is_fixed");
//                int flucAccountId = rs.getInt("account_id");
//                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount, flucAccountId);
//                data.setPreAmount(rs.getLong("pre_amount"));
//                arrlist.add(data);
//            }
//        dataset = arrlist.toArray(new FluctuationDTO[arrlist.size()]);
//        return dataset;
//    }
}
