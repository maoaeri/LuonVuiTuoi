/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import myhustwork.luonvuituoi.BLL.AccountBLL;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.GUI.AccountGUI;

/**
 *
 * @author vvlalalove193
 */
public class AccountController {
    private AccountGUI accGUI;
    private AccountBLL accBLL;
    
    public AccountController() {
        accGUI = new AccountGUI();
        accBLL = new AccountBLL();
        
        accGUI.setVisible(true);
    }
    
    public AccountController(int accId) {
        accGUI = new AccountGUI();
        accBLL = new AccountBLL();
        
        AccountDTO acc = new AccountDTO();
        try {
            acc = accBLL.get(accId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(accGUI, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
        accGUI.setAccId(accId);
        accGUI.display(acc);
       
       accGUI.setVisible(true);
    }
}
