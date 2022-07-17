/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myhustwork.luonvuituoi.GUI.MainGUI;
import myhustwork.luonvuituoi.GUI.WelcomeGUI;

/**
 *
 * @author vvlalalove193
 */
public class WelcomeController {
    private WelcomeGUI welcomeGUI;
    private MainController mc;
    
    public WelcomeController() {
        welcomeGUI = new WelcomeGUI();
        
        welcomeGUI.setVisible(true);
        welcomeGUI.StartListener(new btnStartListener());
    }
    
    class btnStartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            welcomeGUI.setVisible(false);
            mc = new MainController();
        }
    }
    
}
