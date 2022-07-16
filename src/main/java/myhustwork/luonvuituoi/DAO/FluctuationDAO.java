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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void main(String[] args) throws SQLException{
        CategoryDTO a = new CategoryDTO();
        a.setCategoryName("Trang phuc");
        a.setCategoryType(CategoryDTO.CHI);
        
        FluctuationDAO b = new FluctuationDAO();
//        b.getCategoryId(a);
    }
        
    @Override
    public int add(FluctuationDTO fluc) throws SQLException {
        int res = 0;
        String query = "INSERT INTO main.fluctuation(fluctuation_amount, fluctuation_note, fluctuation_date, category_id, fluctuation_is_fixed) VALUES(?,?,?,?,?)";
        Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, fluc.getAmount());
        ps.setString(2, fluc.getNote());
        ps.setDate(3, java.sql.Date.valueOf(fluc.getDate()));
        ps.setInt(4, fluc.getCategory().getCategoryId());
        ps.setBoolean(5, fluc.isFixed());
        res = ps.executeUpdate();
        conn.close();
        return res;
    }
    
    @Override
    public int update(FluctuationDTO fluc) throws SQLException{
        int res = 0;
        String query = "UPDATE main.fluctuation SET fluctuation_amount = ?, fluctuation_note = ?, fluctuation_date = ?, category_id = ?, fluctuation_is_fixed = ? WHERE fluctuation_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, fluc.getAmount());
            ps.setString(2, fluc.getNote());
            ps.setDate(3, java.sql.Date.valueOf(fluc.getDate()));
            ps.setInt(4, fluc.getCategory().getCategoryId());
            ps.setBoolean(5, fluc.isFixed());
            ps.setInt(6, fluc.getID());
            res = ps.executeUpdate();
            conn.close();
        return res;
    }
    
    @Override
    public int delete(FluctuationDTO fluc) throws SQLException{
        int res = 0;
        String query = "DELETE FROM main.fluctuation WHERE fluctuation_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, fluc.getID());
            res = ps.executeUpdate();
            conn.close();
        return res;
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
                fluc = new FluctuationDTO();
                int flucId = rs.getInt("fluctuation_id");
                long flucAmount = rs.getLong("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                LocalDate flucDate = rs.getDate("fluctuation_date").toLocalDate();
                CategoryDTO flucCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                boolean flucFixed = rs.getBoolean("fluc_is_fixed");
                fluc = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount);
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
                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount);
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new FluctuationDTO[arrlist.size()]);
        return dataset;
    }
}
