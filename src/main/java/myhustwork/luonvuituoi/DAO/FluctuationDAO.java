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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static myhustwork.luonvuituoi.DAO.CategoryDAO.getCategoryDetails;
import static myhustwork.luonvuituoi.DAO.CategoryDAO.getCategoryId;
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
//        b.getCategoryId(a);
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
    
    public static FluctuationDTO[] getAllFluctuations(){
        FluctuationDTO[] dataset = null;
        FluctuationDTO data;
        List<FluctuationDTO> arrlist = new ArrayList<>();
        String query = "SELECT * from main.fluctuation";
        try {
            Connection conn = createConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                int flucId = rs.getInt("fluctuation_id");
                double flucAmount = rs.getDouble("fluctuation_amount");
                String flucNote = rs.getString("fluctuation_note");
                Date flucDate = rs.getDate("fluctuation_date");
                CategoryDTO flucCat = getCategoryDetails(rs.getInt("category_id"));
                boolean flucFixed = rs.getBoolean("fluc_is_fixed");
                data = new FluctuationDTO(flucId, flucNote, flucDate, flucCat, flucFixed, flucAmount);
                arrlist.add(data);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FluctuationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataset = arrlist.toArray(dataset);
        return dataset;
    }
}
