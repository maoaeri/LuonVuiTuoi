/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import myhustwork.luonvuituoi.GUI.MainGUI;
import myhustwork.luonvuituoi.GUI.StatisticsGUI;

/**
 *
 * @author vvlalalove193
 */
public class MainController {
    private MainGUI mainGUI;
    private FluctuationController fc;
    private StuffController sc;
    private AccountController ac;
    private StatisticsController stc;

    public MainController() {
        mainGUI = new MainGUI();
        mainGUI.setVisible(true);
        
        mainGUI.addFlucListener(new addFlucListener());
        mainGUI.addStuffListener(new addStuffListener());
        mainGUI.addAccountListener(new addAccountListener());
        mainGUI.StatListener(new StatListener());
        mainGUI.selectStuffListener(new selectStuffListener());
        mainGUI.selectFlucListener(new selectFlucListener());
        mainGUI.selectAccountListener(new selectAccountListener());
    }
    
    class addFlucListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            fc = new FluctuationController();
        }
    }
    
    class addStuffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            sc = new StuffController();
        }
    }
    
    class addAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ac = new AccountController();
        }
    }
    
    class StatListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            stc = new StatisticsController();
        }
    }
    
    class selectStuffListener implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(1);
            if (mainGUI.getStuffId() != 0){
               sc = new StuffController(mainGUI.getStuffId());
               mainGUI.setStuffId(0);
            }
            mainGUI.setStuffId(0);
//            sc = new StuffController(mainGUI.getStuffId());     
        }
    }
    
    class selectFlucListener implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(1);
            if (mainGUI.getFlucId() != 0){
               fc = new FluctuationController(mainGUI.getFlucId());
               mainGUI.setFlucId(0);
            }
            mainGUI.setFlucId(0);
//            sc = new FlucController(mainGUI.getFlucId());     
        }
    }
    
    class selectAccountListener implements ListSelectionListener{
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(1);
            if (mainGUI.getAccId() != 0){
               ac = new AccountController(mainGUI.getAccId());
               mainGUI.setAccId(0);
            }
            mainGUI.setAccId(0);
//            sc = new FlucController(mainGUI.getFlucId());     
        }
    }
    
}
