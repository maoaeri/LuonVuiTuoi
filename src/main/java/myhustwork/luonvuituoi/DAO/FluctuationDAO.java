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
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationDAO {

    public FluctuationDAO() {
    }
    
    public static void main(String[] args) throws SQLException{
        CategoryDTO a = new CategoryDTO();
        a.setCategoryName("Trang phuc");
        a.setCategoryType(CategoryDTO.CHI);
        
        FluctuationDAO b = new FluctuationDAO();
        b.getCategoryId(a);
    }
    
    public static int getCategoryId(CategoryDTO cat) throws SQLException{
        String query = "SELECT category_id from main.category where category_name = ?";
        int categoryId = 0;
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setString(1, cat.getCategoryName());
            rs = ps.executeQuery();
            
            while (rs.next()){
                categoryId = rs.getInt("category_id");
                System.out.println(categoryId);
            }
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  categoryId;
    }
    
    public static void addFluctuation(FluctuationDTO fluc){
        
        String query = "INSERT INTO main.fluctuation(fluctuation_amount, fluctuation_note, fluctuation_date, category_id, fluctuation_is_fixed) VALUES(?,?,?,?,?)";
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, fluc.getAmount());
            ps.setString(2, fluc.getNote());
            ps.setDate(3, new java.sql.Date(fluc.getDate().getTime()));
            ps.setInt(4, getCategoryId(fluc.getCategory()));
            ps.setBoolean(5, fluc.isFixed());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
