/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.View.AddFluctuationFrm;
import myhustwork.luonvuituoi.View.Welcome;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationController {
    private FluctuationDTO fluctuation;
    private AddFluctuationFrm aff;
    private Welcome wl;
    

    public FluctuationController() {
        wl = new Welcome();
        wl.setVisible(true);
        
        aff = new AddFluctuationFrm();
        aff.setVisible(true);
        aff.addSubmitListener(new AddFluctuationListener());
    }
    
    class AddFluctuationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FluctuationDTO fluc = aff.getFluctuationInfor();
                FluctuationDAO.addFluctuation(fluc);
//                aff.showMessage("Thêm thành công!");
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
        
    }
    
    
    
    
}
