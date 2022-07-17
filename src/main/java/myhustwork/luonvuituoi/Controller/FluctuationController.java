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
    
    public FluctuationController() {
        flucGUI = new FluctuationGUI();
        flucDAO = new FluctuationDAO();
        flucBLL = new FluctuationBLL();
        
        flucGUI.setVisible(true);
        flucGUI.addListener(new btnAddListener());
        flucGUI.updateListener(new btnUpdateListener());
        flucGUI.deleteListener(new btnDeleteListener());
    }
    
    public FluctuationController(int flucId) {
        flucGUI = new FluctuationGUI();
        flucDAO = new FluctuationDAO();
        flucBLL = new FluctuationBLL();
        
        FluctuationDTO fluc = new FluctuationDTO();
        try {
            fluc = flucDAO.get(flucId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        flucGUI.display(fluc);
        
        flucGUI.setVisible(true);
        flucGUI.addListener(new btnAddListener());
        flucGUI.updateListener(new btnUpdateListener());
        flucGUI.deleteListener(new btnDeleteListener());
    }
    
    class btnAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = 0;
            try {
                FluctuationDTO fluc = flucGUI.getInfor();
                res = flucDAO.add(fluc);
                flucBLL.CalculateBalance(fluc, "add");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
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
                FluctuationDTO fluc = flucGUI.getInfor();
                res = flucDAO.update(fluc);
                flucBLL.CalculateBalance(fluc, "update");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
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
                FluctuationDTO fluc = flucGUI.getInfor();
                res = flucDAO.delete(fluc);
                flucBLL.CalculateBalance(fluc, "delete");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(flucGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
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
