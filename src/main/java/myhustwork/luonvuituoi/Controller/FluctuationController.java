/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.GUI.FluctuationGUI;
import myhustwork.luonvuituoi.BLL.FluctuationBLL;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationController{
    private FluctuationGUI flucGUI;
    private FluctuationBLL flucBLL;
    private FluctuationDAO flucDAO;
    private int flucId;
    
    public FluctuationController() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                flucGUI = new FluctuationGUI();
        flucBLL = new FluctuationBLL();
        
        flucGUI.setVisible(true);
            }
        });
        
    }
    
    public FluctuationController(int flucId) {
        flucGUI = new FluctuationGUI();
        flucBLL = new FluctuationBLL();
        this.flucId = flucId;
        
        FluctuationDTO fluc = new FluctuationDTO();
        try {
            fluc = flucBLL.get(flucId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        flucGUI.setFlucId(this.flucId);
        flucGUI.display(fluc);
        
        flucGUI.setVisible(true);
    }
}
