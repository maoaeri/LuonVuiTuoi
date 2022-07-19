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
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class CategoryDAO implements DAOInterface<CategoryDTO>{
    
    public int getCategoryId(CategoryDTO cat) throws SQLException{
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
    
    @Override
    public CategoryDTO get(int categoryId) throws SQLException{
        String query = "SELECT * from main.category where category_id = ?";
        CategoryDTO cat_details = null;
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs;
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            
            while (rs.next()){
                cat_details = new CategoryDTO();
                cat_details.setCategoryName(rs.getString("category_name"));
                cat_details.setCategoryType(rs.getInt("category_type"));
            }
            conn.close();
        return  cat_details;
    }    

    @Override
    public void add(CategoryDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CategoryDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(CategoryDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CategoryDTO[] getAll() throws SQLException {
        CategoryDTO[] dataset = null;
        CategoryDTO data;
        List<CategoryDTO> arrlist = new ArrayList<>();
        arrlist.add(new CategoryDTO());
        String query = "SELECT * FROM main.category";
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int catId = rs.getInt("category_id");
                String catName = rs.getString("category_name");
                int catType = rs.getInt("category_type");
                int catParentId = rs.getInt("category_parent_id");
                data = new CategoryDTO(catType, catId, catName, catParentId);
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new CategoryDTO[arrlist.size()]);
        return dataset;
    }

}
