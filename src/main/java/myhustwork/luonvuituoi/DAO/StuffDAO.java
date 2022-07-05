/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static myhustwork.luonvuituoi.DAO.CategoryDAO.getCategoryId;
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
            ps.setInt(2, CategoryDAO.getCategoryId(stuff.getCategory()));
            ps.setString(3, stuff.getNote());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
