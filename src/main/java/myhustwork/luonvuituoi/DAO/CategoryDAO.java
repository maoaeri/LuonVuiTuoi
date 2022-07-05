/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class CategoryDAO {
    
    public static int getCategoryId(CategoryDTO cat) throws SQLException{
        String query = "SELECT category_id from main.category where category_name = ? and category_type = ?";
        int categoryId = 0;
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setString(1, cat.getCategoryName());
            ps.setInt(2, cat.getCategoryType());
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
    
    public static CategoryDTO getCategoryDetails(int categoryId) throws SQLException{
        String query = "SELECT * from main.category where category_id = ?";
        CategoryDTO cat_details = new CategoryDTO();
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            
            while (rs.next()){
                cat_details.setCategoryName(rs.getString("category_name"));
                cat_details.setCategoryType(rs.getInt("category_type"));
            }
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  cat_details;
    }    

}
