/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.View.AddStuffInfoFrm;
import myhustwork.luonvuituoi.View.Welcome;

/**
 *
 * @author vvlalalove193
 */
public class StuffController {
    private StuffDTO stuff;
    private AddStuffInfoFrm asf;
    private Welcome wl;
    
    public StuffController() {
        asf = new AddStuffInfoFrm();
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
