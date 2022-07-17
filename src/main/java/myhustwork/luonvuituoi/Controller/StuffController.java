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
        stuffGUI.addListener(new btnAddListener());
        stuffGUI.updateListener(new btnUpdateListener());
        stuffGUI.deleteListener(new btnDeleteListener());
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
        stuffGUI.addListener(new btnAddListener());
        stuffGUI.updateListener(new btnUpdateListener());
        stuffGUI.deleteListener(new btnDeleteListener());
    }
    
    class btnAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = 0;
            try {
                StuffDTO stuff = stuffGUI.getInfor();
                res = stuffDAO.add(stuff);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (res == 0){
                System.out.print(res);
                return;
            }
        }
    }
    
    class btnUpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = 0;
            try {
                StuffDTO stuff = stuffGUI.getInfor();
                res = stuffDAO.update(stuff);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (res == 0){
                System.out.print(res);
            }
        }
    }
    
    class btnDeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = 0;
            try {
                StuffDTO stuff = stuffGUI.getInfor();
                res = stuffDAO.delete(stuff);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(stuffGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (res == 0){
                System.out.print(res);
            }
        }
    }
}
