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
import java.text.ParseException;
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
import javax.swing.tree.DefaultMutableTreeNode;
import myhustwork.luonvuituoi.DAO.CategoryDAO;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.Util.Converter;
import myhustwork.luonvuituoi.Util.GUIRelated;

/**
 *
 * @author vvlalalove193
 */
public class StuffGUI extends javax.swing.JFrame implements InforInterface<StuffDTO>{
    private CategoryDAO catDAO;
    private StuffDAO stuffDAO;
    private int stuffID;
//    private StuffDTO stuff;
    /**
     * Creates new form AddStuffInfoFrm
     */
    public StuffGUI() {
        catDAO = new CategoryDAO();
        stuffDAO = new StuffDAO();
        stuffID = -1;
        this.setTitle("LuonVuiTuoi");
        initComponents();
    }
    
    @Override
    public void display(StuffDTO stuff){
        txtAmount.setText(Long.toString(stuff.getAmount()));
        txtNote.setText(stuff.getNote());
        lblCategory2.setText(stuff.getCategory().getCategoryName());
    }
    
    @Override
    public StuffDTO getInfor() throws ParseException, SQLException {
        StuffDTO stuff = new StuffDTO();
        if (stuffID != -1){
            stuff.setID(stuffID);
        }
        stuff.setAmount(Converter.formatAmount(txtAmount.getText()));
        DefaultMutableTreeNode selectedNode1 = (DefaultMutableTreeNode) treCategory.getModel().getRoot() ;
        String rootType = selectedNode1.getUserObject().toString();
        int categoryType = 0;
        switch (rootType) {
            case "Thu" ->  {
                categoryType = 1;
            }
            case "Chi" ->  {
                categoryType = 0;
            }
            default -> {
                categoryType = 0;
            }
        }
        DefaultMutableTreeNode selectedNode2 = (DefaultMutableTreeNode) treCategory.getLastSelectedPathComponent() ;
        String categoryName = selectedNode2.getUserObject().toString();
        CategoryDTO cat = new CategoryDTO(categoryType, categoryName);
        cat.setCategoryId(catDAO.getCategoryId(cat));
        stuff.setCategory(cat);
        stuff.setNote(txtNote.getText());
        return stuff;
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
    
    @Override
    public void refreshComponents(){
        txtAmount.setText("");
        txtNote.setText("");
        lblCategory2.setText("");
        lstStuff.setModel(getAllStuffs());
    }
    
    @Override
    public void addListener(ActionListener log){
        btnAdd.addActionListener(log);
    }
    
    @Override
    public void updateListener(ActionListener log){
        btnUpdate.addActionListener(log);
    }
    
    @Override
    public void deleteListener(ActionListener log){
        btnDelete.addActionListener(log);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstStuff = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        treCategory = new javax.swing.JTree();
        txtAmount = new javax.swing.JFormattedTextField();
        lblAmount = new javax.swing.JLabel();
        lblCategory2 = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        lblNote = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblFrm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(960, 540));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 175, 175));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

        lstStuff.setModel(getAllStuffs());
        lstStuff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstStuff.setCellRenderer(new StuffListRenderer());
        lstStuff.setSelectionBackground(new java.awt.Color(255, 255, 255));
        lstStuff.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstStuffValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstStuff);

        treCategory.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        treCategory.setForeground(new java.awt.Color(255, 51, 51));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Hạng mục");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Thu");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Lương");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Thưởng");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Được cho, tặng");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tiền lãi");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Đi vay");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Thu nợ");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Khác");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Chi");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sinh hoạt");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Ăn uống");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Đồ dùng cá nhân");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Vận chuyển");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Nhà cửa");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Phát triển bản thân");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Hiếu hỉ, quà cáp");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Trang phục");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Sức khỏe");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Công việc/ học tập");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Giải trí");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Du lịch");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Khác");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Vay nợ");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Cho vay");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Trả nợ");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treCategory.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treCategory.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treCategoryValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(treCategory);

        txtAmount.setForeground(new java.awt.Color(255, 51, 51));
        txtAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txtAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        lblAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 51, 51));
        lblAmount.setLabelFor(txtAmount);
        lblAmount.setText("Giá tiền:");

        lblCategory2.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblCategory2.setForeground(new java.awt.Color(255, 51, 51));
        lblCategory2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCategory.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 51, 51));
        lblCategory.setText("Hạng mục:");

        txtNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        txtNote.setForeground(new java.awt.Color(255, 51, 51));
        txtNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoteActionPerformed(evt);
            }
        });

        lblNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblNote.setForeground(new java.awt.Color(255, 51, 51));
        lblNote.setText("Ghi chú:");

        btnUpdate.setBackground(new java.awt.Color(255, 51, 51));
        btnUpdate.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 51, 51));
        btnAdd.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblFrm.setFont(new java.awt.Font("r0c0i Linotte", 0, 36)); // NOI18N
        lblFrm.setForeground(new java.awt.Color(255, 51, 51));
        lblFrm.setText("Đồ dùng cần mua");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory))
                        .addGap(51, 51, 51)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNote)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(lblFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblFrm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void treCategoryValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treCategoryValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treCategory.getLastSelectedPathComponent();
        lblCategory2.setText(selectedNode.getUserObject().toString());
    }//GEN-LAST:event_treCategoryValueChanged

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lstStuffValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstStuffValueChanged
        // TODO add your handling code here:
        display(lstStuff.getSelectedValue());
        this.stuffID = lstStuff.getSelectedValue().getID();
    }//GEN-LAST:event_lstStuffValueChanged

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
            java.util.logging.Logger.getLogger(StuffGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuffGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuffGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuffGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuffGUI().setVisible(true);
            }
        });
    }
    
//    public void Run() {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new StuffGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory2;
    private javax.swing.JLabel lblFrm;
    private javax.swing.JLabel lblNote;
    private javax.swing.JList<StuffDTO> lstStuff;
    private javax.swing.JTree treCategory;
    private javax.swing.JFormattedTextField txtAmount;
    private javax.swing.JTextField txtNote;
    // End of variables declaration//GEN-END:variables
}

class StuffListRenderer extends JPanel implements ListCellRenderer<StuffDTO> {
    private JLabel lblIcon = new JLabel();
    private JLabel lblCategoryName = new JLabel();
    private JLabel lblAmount = new JLabel();
    private JLabel lblNote = new JLabel();
    Border lineBorder = BorderFactory.createLineBorder(Color.RED, 1);
    Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
 
    public StuffListRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lblCategoryName);
        panelText.add(lblAmount);
        panelText.add(lblNote);
        add(lblIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
 
    @Override
    public Component getListCellRendererComponent(JList<? extends StuffDTO> list, StuffDTO stuff, int index,
            boolean isSelected, boolean cellHasFocus) {
//        lblIcon.setPreferredSize(new Dimension(100, 100));
        lblIcon.setSize(new Dimension(50,50));
        String imgUrl = "D:\\Pj\\LuonVuiTuoi\\src\\main\\java\\myhustwork\\luonvuituoi\\images\\CategoryIcon\\" + String.valueOf(stuff.getCategory().getCategoryId()) + ".png";
        
        ImageIcon img = new ImageIcon(imgUrl);
        lblIcon.setIcon(img);
        GUIRelated.scaleImage(imgUrl, lblIcon);
        
        lblCategoryName.setText(stuff.getCategory().getCategoryName());
        lblCategoryName.setFont(new java.awt.Font("r0c0i Linotte", 0, 16));
//        lblCategoryName.setForeground(new java.awt.Color(255, 51,51));
        lblAmount.setText(Long.toString(stuff.getAmount()));
        lblAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 16));
        lblAmount.setForeground(new java.awt.Color(255, 51, 51));
        
        lblNote.setText(stuff.getNote());
        lblNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 16));
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
