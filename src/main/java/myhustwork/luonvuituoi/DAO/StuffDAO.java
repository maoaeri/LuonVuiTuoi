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
import myhustwork.luonvuituoi.DTO.StuffDTO;
import static myhustwork.luonvuituoi.Util.DBConnection.createConnection;

/**
 *
 * @author vvlalalove193
 */
public class StuffDAO {
    
    public static void addStuff(StuffDTO stuff){
        String query = "INSERT INTO main.stuff(stuff_amount, category_id, stuff_note) VALUES(?,?,?)";
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, stuff.getAmount());
            ps.setInt(2, stuff.getCategory().getCategoryId());
            ps.setString(3, stuff.getNote());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int updateStuff(StuffDTO stuff){
        int res = 0;
        String query = "UPDATE main.stuff SET stuff_amount = ?, stuff_note = ?, category_id = ? WHERE stuff_id = ?";
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, stuff.getAmount());
            ps.setString(2, stuff.getNote());
            ps.setInt(3, stuff.getCategory().getCategoryId());
            ps.setInt(4, stuff.getID());
            res = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static int deleteStuff(StuffDTO stuff){
        int res = 0;
        String query = "DELETE FROM main.stuff WHERE stuff_id = ?";
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, stuff.getID());
            res = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static StuffDTO getStuff(int id){
        StuffDTO stuff = new StuffDTO();
        String query = "SELECT * FROM main.stuff LEFT JOIN main.category ON main.stuff.category_id = main.category.category_id WHERE stuff_id = ?";
        try {
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            stuff.setID(rs.getInt("stuff_id"));
            stuff.setAmount(rs.getDouble("stuff_amount"));
            stuff.setCategory(new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name")));
            stuff.setNote("stuff_note");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuff;
    }
    
    public static StuffDTO[] getAllStuffs(){
        StuffDTO[] dataset = null;
        StuffDTO data;
        List<StuffDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.stuff LEFT JOIN main.category ON main.stuff.category_id = main.category.category_id";
        try {
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int stuffId = rs.getInt("Stuff_id");
                double stuffAmount = rs.getDouble("Stuff_amount");
                String stuffNote = rs.getString("Stuff_note");
                CategoryDTO stuffCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                data = new StuffDTO(stuffId, stuffCat, stuffNote, stuffAmount);
                arrlist.add(data);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataset = arrlist.toArray(new StuffDTO[arrlist.size()]);
        return dataset;
    }
}
