/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myhustwork.luonvuituoi.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import myhustwork.luonvuituoi.BLL.FluctuationBLL;
import myhustwork.luonvuituoi.DAO.CategoryDAO;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.DatasetDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.Util.DateRelated;
import myhustwork.luonvuituoi.Util.GUIRelated;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author vvlalalove193
 */
public class MainGUI extends javax.swing.JFrame {
    CategoryDAO catDAO;
    FluctuationBLL flucBLL;
    FluctuationDAO flucDAO;
    StuffDAO stuffDAO;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        catDAO = new CategoryDAO();
        flucBLL = new FluctuationBLL();
        flucDAO = new FluctuationDAO();
        stuffDAO = new StuffDAO();
        initComponents();
    }
    
    public ListModel<StuffDTO> getAllStuffs(){
        DefaultListModel listmodel = new DefaultListModel<StuffDTO>();
        StuffDTO[] list = null;
        try {
            list = stuffDAO.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (StuffDTO i: list) {
            listmodel.addElement(i);
        }
        return listmodel;
    }
    
    public ListModel<FluctuationDTO> getAllFlucs(){
        DefaultListModel listmodel = new DefaultListModel<FluctuationDTO>();
        FluctuationDTO[] list = null;
        try {
            list = flucDAO.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (FluctuationDTO i: list) {
            listmodel.addElement(i);
        }
        return listmodel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        panel0 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tbPnl = new javax.swing.JTabbedPane();
        pnlFluc = new javax.swing.JPanel();
        scrPnlFluc = new javax.swing.JScrollPane();
        lstFluc = new javax.swing.JList<>();
        pnlStuff = new javax.swing.JPanel();
        scrPnlStuff = new javax.swing.JScrollPane();
        lstStuff = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(960, 540));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 175, 175));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        DefaultPieDataset[] dataset = getDataset();
        JFreeChart chart1 = ChartFactory.createPieChart("Tinh hinh thu", dataset[1], true, true, true);
        ChartPanel panel1 = new ChartPanel(chart1);
        chart1.setBackgroundPaint(new Color(0, 0, 0, 0));
        panel1.setBackground(new Color(0, 0, 0, 0));
        panel1.setPreferredSize(new java.awt.Dimension(308, 270));
        panel1.setSize(308, 270);

        JFreeChart chart0 = ChartFactory.createPieChart("Tinh hinh chi", dataset[0], true, true, true);
        ChartPanel panel0 = new ChartPanel(chart0);
        chart0.setBackgroundPaint(new Color(0, 0, 0, 0));
        panel0.setBackground(new Color(0, 0, 0, 0));
        panel0.setPreferredSize(new java.awt.Dimension(308, 270));
        panel0.setSize(308, 270);

        javax.swing.GroupLayout panel0Layout = new javax.swing.GroupLayout(panel0);
        panel0.setLayout(panel0Layout);
        panel0Layout.setHorizontalGroup(
            panel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        panel0Layout.setVerticalGroup(
            panel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lstFluc.setModel(getAllFlucs());
        lstStuff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFluc.setCellRenderer(new FluctuationListRenderer());
        scrPnlFluc.setViewportView(lstFluc);

        javax.swing.GroupLayout pnlFlucLayout = new javax.swing.GroupLayout(pnlFluc);
        pnlFluc.setLayout(pnlFlucLayout);
        pnlFlucLayout.setHorizontalGroup(
            pnlFlucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlFluc, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        pnlFlucLayout.setVerticalGroup(
            pnlFlucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlFluc, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        tbPnl.addTab("Giao dịch", pnlFluc);

        lstStuff.setModel(getAllStuffs());
        lstStuff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstStuff.setCellRenderer(new StuffListRenderer());
        scrPnlStuff.setViewportView(lstStuff);

        javax.swing.GroupLayout pnlStuffLayout = new javax.swing.GroupLayout(pnlStuff);
        pnlStuff.setLayout(pnlStuffLayout);
        pnlStuffLayout.setHorizontalGroup(
            pnlStuffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlStuff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        pnlStuffLayout.setVerticalGroup(
            pnlStuffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlStuff, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        tbPnl.addTab("Đồ dùng cần mua", pnlStuff);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(panel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbPnl))
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tbPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public DefaultPieDataset[] getDataset(){
        DefaultPieDataset[] dataset = new DefaultPieDataset[2];
        dataset[0] = new DefaultPieDataset();
        dataset[1] = new DefaultPieDataset();
        
        //get categories
        CategoryDTO[] listCategory = null;
        try {
            listCategory = catDAO.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //
        List<DatasetDTO> arrList = new ArrayList<DatasetDTO>();
        
        //get percentages
        LocalDate localdate = LocalDate.now();
        LocalDate firstDayOfMonth = DateRelated.getFirstDayOfMonth(localdate);
        LocalDate lastDayOfMonth = DateRelated.getLastDayOfMonth(localdate);
        double[] percentages = null;
        try {
            percentages = flucBLL.PercentCategories(firstDayOfMonth, lastDayOfMonth);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        for (int i = listCategory.length - 1; i >= 0; i--){
            if (percentages[i] > 0 ){
                System.err.println("hihi");
                int n = i;
                while (n >1){
                    if (percentages[listCategory[n].getCategoryParentId()] == percentages[n]){
                        n = listCategory[n].getCategoryParentId();
                    } else {
                        DatasetDTO data = new DatasetDTO(listCategory[n].getCategoryName(), percentages[n]);
                        arrList.add(data);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < arrList.size(); i++){
            switch (listCategory[i].getCategoryType()) {
                case CategoryDTO.CHI:
                    dataset[0].setValue(arrList.get(i).getName(), arrList.get(i).getValue());
                    break;
                case CategoryDTO.THU:
                    dataset[1].setValue(arrList.get(i).getName(), arrList.get(i).getValue());
                    break;
            }
            
        }

        return dataset;
    }
    
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private org.jfree.chart.ChartFactory chartMain;
    private javax.swing.JList<FluctuationDTO> lstFluc;
    private javax.swing.JList<StuffDTO> lstStuff;
    private javax.swing.JPanel panel0;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel pnlFluc;
    private javax.swing.JPanel pnlStuff;
    private javax.swing.JScrollPane scrPnlFluc;
    private javax.swing.JScrollPane scrPnlStuff;
    private javax.swing.JTabbedPane tbPnl;
    // End of variables declaration//GEN-END:variables
}


