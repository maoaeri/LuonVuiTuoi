/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.GUI.StuffGUI;
import myhustwork.luonvuituoi.GUI.WelcomeGUI;

/**
 *
 * @author vvlalalove193
 */
public class StuffController {
    private StuffDTO stuff;
    private StuffGUI asf;
    private WelcomeGUI wl;
    
    public StuffController() {
        asf = new StuffGUI();
        asf.setVisible(true);
        asf.addSubmitListener(new AddStuffListener());
    }
    
    class AddStuffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                StuffDTO stuff = asf.getStuffInfor();
                StuffDAO.addStuff(stuff);
//                asf.showMessage("Thêm thành công!");
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
        
    }    
}
