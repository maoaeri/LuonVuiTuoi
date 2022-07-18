/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.GUI.StuffGUI;

/**
 *
 * @author vvlalalove193
 */
public class StuffController {
    private StuffGUI stuffGUI;
    private StuffDAO stuffDAO;
    int stuffId;
    
    public StuffController() {
        stuffGUI = new StuffGUI();
        stuffDAO = new StuffDAO();
        
        stuffGUI.setVisible(true);
    }
    
    public StuffController(int stuffId) {
        stuffGUI = new StuffGUI();
        stuffDAO = new StuffDAO();
        
        StuffDTO stuff = new StuffDTO();
        try {
            stuff = stuffDAO.get(stuffId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        stuffGUI.display(stuff);
        stuffGUI.setVisible(true);
    }
}
