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

/**
 *
 * @author vvlalalove193
 */
public class FluctuationController{
    private FluctuationGUI flucGUI;
    private FluctuationDAO flucDAO;
    
    public FluctuationController() {
        flucGUI = new FluctuationGUI();
        flucDAO = new FluctuationDAO();
        
        flucGUI.setVisible(true);
        flucGUI.addFluctuationListener(new btnAddListener());
        flucGUI.addFluctuationListener(new btnUpdateListener());
        flucGUI.addFluctuationListener(new btnDeleteListener());
    }
    
    class btnAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = 0;
            try {
                FluctuationDTO fluc = flucGUI.getFluctuationInfor();
                res = flucDAO.add(fluc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
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
                FluctuationDTO fluc = flucGUI.getFluctuationInfor();
                res = flucDAO.update(fluc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
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
                FluctuationDTO fluc = flucGUI.getFluctuationInfor();
                res = flucDAO.delete(fluc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (res == 0){
                System.out.print(res);
            }
        }
    }
}
//    
//    @Override
//    public int add(FluctuationDTO fluc) {
//        int res = 0;
//        try {
//            fluc = flucGUI.getFluctuationInfor();
//            res = flucDAO.add(fluc);
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return res;    
//    }
//
//    @Override
//    public int update(FluctuationDTO fluc) {
//        int res = 0;
//        try {
//            fluc = flucGUI.getFluctuationInfor();
//            res = flucDAO.update(fluc);
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return res;  
//    }
//
//    @Override
//    public int delete(FluctuationDTO fluc) {
//        int res = 0;
//        try {
//            fluc = flucGUI.getFluctuationInfor();
//            res = flucDAO.delete(fluc);
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return res;  
//    }
//
//    @Override
//    public FluctuationDTO get(int id) {
//        FluctuationDTO fluc = null;
//        try {
//            fluc = flucDAO.get(id);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return fluc;
//    }
//
//    @Override
//    public FluctuationDTO[] getAll() {
//        FluctuationDTO[] flucList = null;
//        try {
//            flucList = flucDAO.getAll();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return flucList;
//    }
//}
