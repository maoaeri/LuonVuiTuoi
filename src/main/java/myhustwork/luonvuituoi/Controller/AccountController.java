/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import myhustwork.luonvuituoi.DAO.AccountDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.GUI.AccountGUI;

/**
 *
 * @author vvlalalove193
 */
public class AccountController {
    private AccountGUI accGUI;
    private AccountDAO accDAO;
    
    public AccountController() {
        accGUI = new AccountGUI();
        accDAO = new AccountDAO();
        
        accGUI.setVisible(true);
    }
    
    public AccountController(int accId) {
        accGUI = new AccountGUI();
        accDAO = new AccountDAO();
        
        AccountDTO acc = new AccountDTO();
        try {
            acc = accDAO.get(accId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(accGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       accGUI.display(acc);
        
        accGUI.setVisible(true);
    }
}
