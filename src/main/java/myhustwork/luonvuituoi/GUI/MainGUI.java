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
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import myhustwork.luonvuituoi.BLL.AccountBLL;
import myhustwork.luonvuituoi.BLL.CategoryBLL;
import myhustwork.luonvuituoi.BLL.FluctuationBLL;
import myhustwork.luonvuituoi.BLL.StuffBLL;
import myhustwork.luonvuituoi.DTO.AccountDTO;
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
    private FluctuationBLL flucBLL;
    private StuffBLL stuffBLL;
    private AccountBLL accBLL;
    private CategoryBLL catBLL;
    private int accId;
    private int flucId;
    private int stuffId;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        flucBLL = new FluctuationBLL();
        stuffBLL = new StuffBLL();
        accBLL = new AccountBLL();
        catBLL = new CategoryBLL();
        accId = 1;
        this.setTitle("LuonVuiTuoi");
        initComponents();
    }

    public int getAccId() {
        return accId;
    }

    public int getFlucId() {
        return flucId;
    }

    public int getStuffId() {
        return stuffId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setFlucId(int flucId) {
        this.flucId = flucId;
    }

    public void setStuffId(int stuffId) {
        this.stuffId = stuffId;
    }
    
    public ListModel<StuffDTO> getAllStuffs(){
        DefaultListModel listmodel = new DefaultListModel<StuffDTO>();
        StuffDTO[] list = null;
        try {
            list = stuffBLL.StuffSuggestion(stuffBLL.getAll());
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
            list = flucBLL.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (FluctuationDTO i: list) {
            listmodel.addElement(i);
        }
        return listmodel;
    }
    
    public ListModel<AccountDTO> getAllAccounts(){
        DefaultListModel listmodel = new DefaultListModel<AccountDTO>();
        AccountDTO[] list = null;
        try {
            list = accBLL.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (AccountDTO i: list) {
            listmodel.addElement(i);
        }
        return listmodel;
    }
    
    public void addFlucListener(ActionListener log){
        btnFluc.addActionListener(log);
    }
    
    public void addStuffListener(ActionListener log){
        btnStuff.addActionListener(log);
    }
    
    public void addAccountListener(ActionListener log){
        btnAccount.addActionListener(log);
    }
    
    public void StatListener(ActionListener log){
        btnStat.addActionListener(log);
    }

    public void selectFlucListener(ListSelectionListener log){
        lstFluc.addListSelectionListener(log);
    }
    
    public void selectStuffListener(ListSelectionListener log){
        lstStuff.addListSelectionListener(log);
    }
    
    public void selectAccountListener(ListSelectionListener log){
        lstAccount.addListSelectionListener(log);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientLayout = new keeptoo.KGradientPanel();
        tbPnl = new javax.swing.JTabbedPane();
        pnlStuff = new javax.swing.JPanel();
        scrPnlStuff = new javax.swing.JScrollPane();
        lstStuff = new javax.swing.JList<>();
        pnlFluc = new javax.swing.JPanel();
        scrPnlFluc = new javax.swing.JScrollPane();
        lstFluc = new javax.swing.JList<>();
        pnlAccount = new javax.swing.JPanel();
        scrPnlAccount = new javax.swing.JScrollPane();
        lstAccount = new javax.swing.JList<>();
        btnFluc = new javax.swing.JButton();
        btnStuff = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnStat = new javax.swing.JButton();
        btnSuggest = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnAboutUs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(960, 540));

        gradientLayout.setkEndColor(new java.awt.Color(255, 175, 175));
        gradientLayout.setkGradientFocus(100);
        gradientLayout.setkStartColor(new java.awt.Color(255, 255, 255));
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

        tbPnl.setToolTipText("");
        tbPnl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbPnlStateChanged(evt);
            }
        });

        lstStuff.setModel(getAllStuffs());
        lstStuff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstStuff.setCellRenderer(new StuffListRenderer());
        lstStuff.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstStuffValueChanged(evt);
            }
        });
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

        tbPnl.addTab("Đồ dùng cần ưu tiênmua", pnlStuff);

        lstFluc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstFluc.setModel(getAllFlucs());
        lstFluc.setSelectionBackground(new java.awt.Color(153, 153, 255));
        lstFluc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        tbPnl.addTab("Biến động số dư gần đây", pnlFluc);

        lstAccount.setModel(getAllAccounts());
        lstAccount.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAccount.setCellRenderer(new AccountListRenderer());
        lstAccount.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAccountValueChanged(evt);
            }
        });
        scrPnlAccount.setViewportView(lstAccount);

        javax.swing.GroupLayout pnlAccountLayout = new javax.swing.GroupLayout(pnlAccount);
        pnlAccount.setLayout(pnlAccountLayout);
        pnlAccountLayout.setHorizontalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        pnlAccountLayout.setVerticalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        tbPnl.addTab("Tài khoản", pnlAccount);

        btnFluc.setBackground(new java.awt.Color(255, 51, 51));
        btnFluc.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnFluc.setForeground(new java.awt.Color(255, 255, 255));
        btnFluc.setText("Biến động số dư");
        btnFluc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlucActionPerformed(evt);
            }
        });

        btnStuff.setBackground(new java.awt.Color(255, 51, 51));
        btnStuff.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnStuff.setForeground(new java.awt.Color(255, 255, 255));
        btnStuff.setText("Đồ cần mua");
        btnStuff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStuffActionPerformed(evt);
            }
        });

        btnAccount.setBackground(new java.awt.Color(255, 51, 51));
        btnAccount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setText("Tài khoản");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        btnStat.setBackground(new java.awt.Color(255, 51, 51));
        btnStat.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnStat.setForeground(new java.awt.Color(255, 255, 255));
        btnStat.setText("Thống kê");
        btnStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatActionPerformed(evt);
            }
        });

        btnSuggest.setBackground(new java.awt.Color(255, 51, 51));
        btnSuggest.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnSuggest.setForeground(new java.awt.Color(255, 255, 255));
        btnSuggest.setText("Đề xuất chi tiêu");
        btnSuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuggestActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(255, 51, 51));
        btnRefresh.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAboutUs.setBackground(new java.awt.Color(255, 51, 51));
        btnAboutUs.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnAboutUs.setForeground(new java.awt.Color(255, 255, 255));
        btnAboutUs.setText("Về chúng tôi");
        btnAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientLayoutLayout = new javax.swing.GroupLayout(gradientLayout);
        gradientLayout.setLayout(gradientLayoutLayout);
        gradientLayoutLayout.setHorizontalGroup(
            gradientLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientLayoutLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tbPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(gradientLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFluc, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btnStuff, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btnStat, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btnSuggest, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAboutUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        gradientLayoutLayout.setVerticalGroup(
            gradientLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientLayoutLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnFluc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnStuff, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnStat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(gradientLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientLayoutLayout.createSequentialGroup()
                        .addComponent(btnSuggest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstAccountValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAccountValueChanged
        // TODO add your handling code here:
        setAccId(lstAccount.getSelectedValue().getId());
    }//GEN-LAST:event_lstAccountValueChanged

    private void btnFlucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlucActionPerformed
        // TODO add your handling code here:
//        refreshComponents();
    }//GEN-LAST:event_btnFlucActionPerformed

    private void btnStuffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStuffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStuffActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccountActionPerformed

    private void lstStuffValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstStuffValueChanged
        // TODO add your handling code here:
        this.setStuffId(lstStuff.getSelectedValue().getID());
    }//GEN-LAST:event_lstStuffValueChanged

    private void btnStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStatActionPerformed

    private void btnSuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuggestActionPerformed
        // TODO add your handling code here:
        LocalDate dateNow = LocalDate.now();
        LocalDate firstDayOfMonth = DateRelated.getFirstDayOfMonth(dateNow);
        LocalDate lastDayOfMonth = DateRelated.getLastDayOfMonth(dateNow);
        int[] mark = null;
        try {
            mark = flucBLL.SuggestionNextMonth(firstDayOfMonth, lastDayOfMonth);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String []suggestCat = {"Nhu cầu cần thiết", "Giáo dục", "Hưởng thụ", "Tự do tài chính"};
        String message = "Bạn đã tiêu quá nhiều vào: ";
        for(int i = 0; i <4; i++){
            if (mark[i] == 1){
                message += suggestCat[i] + ",";
            } else {
                message += "";
            }
        }
        message += ".\nHãy tiêu thêm vào: ";
        for(int i = 0; i <4; i++){
            if (mark[i] == 0){
                message += suggestCat[i] + ",";
            } else {
                message += "";
            }
        }
        JOptionPane.showMessageDialog(this, message, "Đề xuất", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSuggestActionPerformed

    private void tbPnlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbPnlStateChanged
        // TODO add your handling code here:
//        lstStuff.setModel(getAllStuffs());
//        lstFluc.setModel(getAllFlucs());
//        lstAccount.setModel(getAllAccounts());
    }//GEN-LAST:event_tbPnlStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        lstStuff.setModel(getAllStuffs());
        lstFluc.setModel(getAllFlucs());
        lstAccount.setModel(getAllAccounts());
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutUsActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Chiếc project được làm bởi nhóm 23", "Về chúng tôi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAboutUsActionPerformed

    public DefaultPieDataset[] getDataset(){
        DefaultPieDataset[] dataset = new DefaultPieDataset[2];
        dataset[0] = new DefaultPieDataset();
        dataset[1] = new DefaultPieDataset();
        
        CategoryDTO[] listCategory = null;
        try {
            listCategory = catBLL.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //get percentages
        LocalDate localdate = LocalDate.now();
        LocalDate firstDayOfMonth = DateRelated.getFirstDayOfMonth(localdate);
        LocalDate lastDayOfMonth = DateRelated.getLastDayOfMonth(localdate);
        
        List<DatasetDTO> arrList = new ArrayList<DatasetDTO>();
        try {
            arrList = flucBLL.getStatDatasetByDate(firstDayOfMonth, lastDayOfMonth);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        for (int i = 0; i < arrList.size(); i++){
            try {
                switch (catBLL.get(arrList.get(i).getId()).getCategoryType()) {
                    case CategoryDTO.CHI:
                        dataset[0].setValue(arrList.get(i).getName(), arrList.get(i).getValue());
                        break;
                    case CategoryDTO.THU:
                        dataset[1].setValue(arrList.get(i).getName(), arrList.get(i).getValue());
                        break;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                
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
    private javax.swing.JButton btnAboutUs;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnFluc;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnStat;
    private javax.swing.JButton btnStuff;
    private javax.swing.JButton btnSuggest;
    private keeptoo.KGradientPanel gradientLayout;
    private org.jfree.chart.ChartFactory chartMain;
    private javax.swing.JList<AccountDTO> lstAccount;
    private javax.swing.JList<FluctuationDTO> lstFluc;
    private javax.swing.JList<StuffDTO> lstStuff;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlFluc;
    private javax.swing.JPanel pnlStuff;
    private javax.swing.JScrollPane scrPnlAccount;
    private javax.swing.JScrollPane scrPnlFluc;
    private javax.swing.JScrollPane scrPnlStuff;
    private javax.swing.JTabbedPane tbPnl;
    // End of variables declaration//GEN-END:variables
}

class FluctuationListRenderer extends JPanel implements ListCellRenderer<FluctuationDTO> {
    private JLabel lblIcon = new JLabel();
//    private JLabel lblCategoryName = new JLabel();
    private JLabel lblAmount = new JLabel();
    private JLabel lblNote = new JLabel();
    Border lineBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
 
    public FluctuationListRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
//        panelText.add(lblCategoryName);
        panelText.add(lblAmount);
        panelText.add(lblNote);
        add(lblIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
 
    @Override
    public Component getListCellRendererComponent(JList<? extends FluctuationDTO> list, FluctuationDTO fluc, int index,
            boolean isSelected, boolean cellHasFocus) {
        lblIcon.setSize(new Dimension(50,50));
        
        String imgUrl = "D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\CategoryIcon\\" + String.valueOf(fluc.getCategory().getCategoryId() + ".png");
        
        ImageIcon img = new ImageIcon(imgUrl);
        lblIcon.setIcon(img);
        GUIRelated.scaleImage(imgUrl, lblIcon);
        
        
//        lblCategoryName.setText(stuff.getCategory().getCategoryName());
//        lblCategoryName.setFont(new java.awt.Font("r0c0i Linotte", 0, 18));
//        lblCategoryName.setForeground(new java.awt.Color(255, 51,51));
        lblAmount.setText(Double.toString(fluc.getAmount()));
        lblAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18));
        lblAmount.setForeground(new java.awt.Color(255, 51, 51));
        lblNote.setText(fluc.getNote());
        lblNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 18));
        lblNote.setForeground(new java.awt.Color(255, 51,51));
        
        if (isSelected) {
            this.setForeground(list.getSelectionForeground());
            this.setBackground(list.getSelectionBackground());
            this.setBorder(new LineBorder(Color.BLUE));
        } else {
            this.setForeground(list.getForeground());
            this.setBackground(list.getBackground());
        }

        this.setBorder(cellHasFocus ? lineBorder : emptyBorder);
        return this;
    }
} 
