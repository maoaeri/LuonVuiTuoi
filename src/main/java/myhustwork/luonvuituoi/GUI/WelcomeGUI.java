/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myhustwork.luonvuituoi.GUI;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import myhustwork.luonvuituoi.Util.GUIRelated;

/**
 *
 * @author vvlalalove193
 */
public class WelcomeGUI extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public WelcomeGUI() {
        initComponents();
        GUIRelated.scaleImage("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png", logo1);
        GUIRelated.scaleImage("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png", logo2);
        GUIRelated.scaleImage("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png", logo3);
    }
    

    
    public void StartListener(ActionListener log){
        btnStart.addActionListener(log);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnStart = new javax.swing.JButton();
        logo1 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        logo3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.gray);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 175, 175));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStart.setText("Get Started");
        btnStart.setBorder(null);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 196, 30));

        logo1.setIcon(new javax.swing.ImageIcon("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png")); // NOI18N
        logo1.setPreferredSize(new java.awt.Dimension(297, 35));
        kGradientPanel1.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 159, -1, -1));

        logo2.setIcon(new javax.swing.ImageIcon("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png")); // NOI18N
        logo2.setPreferredSize(new java.awt.Dimension(297, 35));
        kGradientPanel1.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 212, -1, -1));

        logo3.setIcon(new javax.swing.ImageIcon("D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\retouch_2022062810064090.png")); // NOI18N
        logo3.setPreferredSize(new java.awt.Dimension(297, 35));
        kGradientPanel1.add(logo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 265, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel logo3;
    // End of variables declaration//GEN-END:variables
}
