/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import myhustwork.luonvuituoi.BLL.StuffBLL;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.GUI.StuffGUI;

/**
 *
 * @author vvlalalove193
 */
public class StuffController {
    private StuffGUI stuffGUI;
    private StuffBLL stuffBLL;
    private int stuffId;
    
    public StuffController() {
        stuffGUI = new StuffGUI();
        stuffBLL = new StuffBLL();
        
        stuffGUI.setVisible(true);
    }
    
    public StuffController(int stuffId) {
        stuffGUI = new StuffGUI();
        stuffBLL = new StuffBLL();
        
        StuffDTO stuff = new StuffDTO();
        try {
            stuff = stuffBLL.get(stuffId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        stuffGUI.setStuffID(stuffId);
        stuffGUI.display(stuff);
        stuffGUI.setVisible(true);
    }
}
