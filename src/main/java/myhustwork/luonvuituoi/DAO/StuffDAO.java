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
public class StuffDAO implements DAOInterface<StuffDTO>{

    public StuffDAO() {
    }
    
    @Override
    public int add(StuffDTO stuff) throws SQLException{
        int res = 0;
        String query = "INSERT INTO main.stuff(stuff_amount, category_id, stuff_note) VALUES(?,?,?)";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, stuff.getAmount());
            ps.setInt(2, stuff.getCategory().getCategoryId());
            ps.setString(3, stuff.getNote());
            res = ps.executeUpdate();
            conn.close();
        return res;
    }
    
    @Override
    public int update(StuffDTO stuff) throws SQLException{
        int res = 0;
        String query = "UPDATE main.stuff SET stuff_amount = ?, stuff_note = ?, category_id = ? WHERE stuff_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, stuff.getAmount());
            ps.setString(2, stuff.getNote());
            ps.setInt(3, stuff.getCategory().getCategoryId());
            ps.setInt(4, stuff.getID());
            res = ps.executeUpdate();
            conn.close();
        return res;
    }
    
    @Override
    public int delete(StuffDTO stuff) throws SQLException{
        int res = 0;
        String query = "DELETE FROM main.stuff WHERE stuff_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, stuff.getID());
            res = ps.executeUpdate();
            conn.close();
        return res;
    }
    
    public StuffDTO get(int id) throws SQLException{
        StuffDTO stuff = null;
        String query = "SELECT * FROM main.stuff LEFT JOIN main.category ON main.stuff.category_id = main.category.category_id WHERE stuff_id = ?";
            Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stuff = new StuffDTO();
                stuff.setID(rs.getInt("stuff_id"));
                stuff.setAmount(rs.getLong("stuff_amount"));
                stuff.setCategory(new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name")));
                stuff.setNote("stuff_note");
            }
            conn.close();
        return stuff;
    }
    
    public StuffDTO[] getAll() throws SQLException{
        StuffDTO[] dataset = null;
        StuffDTO data;
        List<StuffDTO> arrlist = new ArrayList<>();
        String query = "SELECT * FROM main.stuff LEFT JOIN main.category ON main.stuff.category_id = main.category.category_id";
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int stuffId = rs.getInt("Stuff_id");
                long stuffAmount = rs.getLong("Stuff_amount");
                String stuffNote = rs.getString("Stuff_note");
                CategoryDTO stuffCat = new CategoryDTO(rs.getInt("category_type"), rs.getInt("category_id"), rs.getString("category_name"));
                data = new StuffDTO(stuffId, stuffCat, stuffNote, stuffAmount);
                arrlist.add(data);
            }
        dataset = arrlist.toArray(new StuffDTO[arrlist.size()]);
        return dataset;
    }
}
