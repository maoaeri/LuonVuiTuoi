/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myhustwork.luonvuituoi.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import myhustwork.luonvuituoi.Controller.FluctuationController;
import myhustwork.luonvuituoi.DAO.AccountDAO;
import myhustwork.luonvuituoi.DAO.CategoryDAO;
import myhustwork.luonvuituoi.DAO.FluctuationDAO;
import myhustwork.luonvuituoi.DAO.StuffDAO;
import myhustwork.luonvuituoi.DTO.AccountDTO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;
import myhustwork.luonvuituoi.DTO.StuffDTO;
import myhustwork.luonvuituoi.Util.Converter;
import myhustwork.luonvuituoi.Util.GUIRelated;

/**
 *
 * @author vvlalalove193
 */
public class FluctuationGUI extends javax.swing.JFrame implements InforInterface<FluctuationDTO>{
    boolean fixedButtonpressed;
    private FluctuationDAO flucDAO;
    private CategoryDAO catDAO;
    private StuffDAO stuffDAO;
    private AccountDAO accDAO;
    private int accId;
    /**
     * Creates new form AddFluctuationForm
     */
    public FluctuationGUI() {
        accId = -1;
        flucDAO = new FluctuationDAO();
        catDAO = new CategoryDAO();
        stuffDAO = new StuffDAO();
        accDAO = new AccountDAO();
        this.setTitle("LuonVuiTuoi");
        initComponents();
    }
    
    @Override
    public void display(FluctuationDTO fluc){
        txtAmount.setText(fluc.getAmount() + "");
        txtDate.setText(Converter.fromLocalDatetoString(fluc.getDate()));
        txtNote.setText(fluc.getNote());
        lblCategory.setText(fluc.getCategory().getCategoryName());
        radFixed.setSelected(fluc.isFixed());
        radNotFixed.setSelected(!fluc.isFixed());
    }
    
    @Override
    public void refreshComponents(){
        txtAmount.setText("");
        txtDate.setText("");
        txtNote.setText("");
        lblCategory.setText("");
        radFixed.setSelected(false);
        radNotFixed.setSelected(false);
    }
    
    @Override
    public FluctuationDTO getInfor() throws ParseException, SQLException {
        FluctuationDTO fluc = new FluctuationDTO();
        if (accId != -1){
            fluc.setAccountId(accId);
        }
        fluc.setAmount(Converter.formatAmount(txtAmount.getText()));
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
        }
        DefaultMutableTreeNode selectedNode2 = (DefaultMutableTreeNode) treCategory.getLastSelectedPathComponent() ;
        String categoryName = selectedNode2.getUserObject().toString();
        CategoryDTO cat = new CategoryDTO(categoryType, categoryName);
        cat.setCategoryId(catDAO.getCategoryId(cat));
        fluc.setCategory(cat);
        fluc.setDate(Converter.toDate(txtDate.getText()));
        fluc.setNote(txtNote.getText());
        fluc.setFixed(this.fixedButtonpressed);
//        System.out.println(parseInt(txtAmount.getText()));
        fluc.setAccountId(this.accId);
        System.out.println(this.accId);
        System.err.println(fluc.getAccountId());
        return fluc;
    }
    
    public ListModel<AccountDTO> getAllAccounts(){
        DefaultListModel listmodel = new DefaultListModel<AccountDTO>();
        AccountDTO[] list = null;
        try {
            list = accDAO.getAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for (AccountDTO i: list) {
            listmodel.addElement(i);
        }
        return listmodel;
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
        txtDate = new javax.swing.JFormattedTextField();
        radFixed = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        treCategory = new javax.swing.JTree();
        btnAdd = new javax.swing.JButton();
        lblCategory = new javax.swing.JLabel();
        txtAmount = new javax.swing.JFormattedTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblForm = new javax.swing.JLabel();
        radNotFixed = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        lblAmount = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblCategory1 = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAccount = new javax.swing.JList<>();
        lblNote1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 175, 175));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

        txtDate.setForeground(new java.awt.Color(255, 51, 51));
        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDate.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N

        radFixed.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        radFixed.setForeground(new java.awt.Color(255, 51, 51));
        radFixed.setText("Cố định");
        radFixed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radFixedStateChanged(evt);
            }
        });

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
        jScrollPane1.setViewportView(treCategory);

        btnAdd.setBackground(new java.awt.Color(255, 51, 51));
        btnAdd.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblCategory.setBackground(new java.awt.Color(255, 255, 255));
        lblCategory.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 51, 51));
        lblCategory.setText("Hạng mục");
        lblCategory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCategory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblCategoryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblCategoryFocusLost(evt);
            }
        });

        txtAmount.setForeground(new java.awt.Color(255, 51, 51));
        txtAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txtAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        txtAmount.setPreferredSize(new java.awt.Dimension(438, 34));
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 51, 51));
        btnUpdate.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        lblForm.setFont(new java.awt.Font("r0c0i Linotte", 0, 36)); // NOI18N
        lblForm.setForeground(new java.awt.Color(255, 51, 51));
        lblForm.setText("Giao dịch");

        radNotFixed.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        radNotFixed.setForeground(new java.awt.Color(255, 51, 51));
        radNotFixed.setText("Không cố định");
        radNotFixed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radNotFixedStateChanged(evt);
            }
        });
        radNotFixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNotFixedActionPerformed(evt);
            }
        });

        txtNote.setColumns(20);
        txtNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        txtNote.setForeground(new java.awt.Color(255, 51, 51));
        txtNote.setRows(5);
        jScrollPane2.setViewportView(txtNote);

        lblAmount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 51, 51));
        lblAmount.setLabelFor(txtAmount);
        lblAmount.setText("Số tiền");

        lblDate.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 51, 51));
        lblDate.setLabelFor(txtAmount);
        lblDate.setText("Ngày tháng");

        lblCategory1.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblCategory1.setForeground(new java.awt.Color(255, 51, 51));
        lblCategory1.setLabelFor(txtAmount);
        lblCategory1.setText("Hạng mục");

        lblNote.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblNote.setForeground(new java.awt.Color(255, 51, 51));
        lblNote.setLabelFor(txtAmount);
        lblNote.setText("Tài khoản:");

        lstAccount.setModel(getAllAccounts());
        lstAccount.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAccount.setCellRenderer(new AccountListRenderer());
        lstAccount.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAccountValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstAccount);

        lblNote1.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblNote1.setForeground(new java.awt.Color(255, 51, 51));
        lblNote1.setLabelFor(txtAmount);
        lblNote1.setText("Ghi chú");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCategory1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblNote1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(radFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radNotFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(155, 155, 155))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(lblForm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblForm)
                .addGap(31, 31, 31)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmount))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory1))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radNotFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNote1))
                        .addGap(32, 32, 32)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnAddActionPerformed

    private void treCategoryValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treCategoryValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treCategory.getLastSelectedPathComponent();
        lblCategory.setText(selectedNode.getUserObject().toString());
    }//GEN-LAST:event_treCategoryValueChanged

    private void radFixedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radFixedStateChanged
        // TODO add your handling code here:
        AbstractButton aButton = (AbstractButton)evt.getSource();
        ButtonModel aModel = aButton.getModel();
        this.fixedButtonpressed = aModel.isPressed();
    }//GEN-LAST:event_radFixedStateChanged

    private void radNotFixedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radNotFixedStateChanged
        // TODO add your handling code here:
        AbstractButton aButton = (AbstractButton)evt.getSource();
        ButtonModel aModel = aButton.getModel();
        this.fixedButtonpressed = !aModel.isPressed();
    }//GEN-LAST:event_radNotFixedStateChanged

    private void radNotFixedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNotFixedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNotFixedActionPerformed

    private void lblCategoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblCategoryFocusGained
        // TODO add your handling code here:
        lblCategory.setText("");
    }//GEN-LAST:event_lblCategoryFocusGained

    private void lblCategoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblCategoryFocusLost
        // TODO add your handling code here:
        if (lblCategory.getText().equals("")){
            lblCategory.setText("Hạng mục");
        }
    }//GEN-LAST:event_lblCategoryFocusLost

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void lstAccountValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAccountValueChanged
        // TODO add your handling code here:
        accId = lstAccount.getSelectedValue().getId();
        System.out.println(accId);
    }//GEN-LAST:event_lstAccountValueChanged

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
            java.util.logging.Logger.getLogger(FluctuationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FluctuationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FluctuationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FluctuationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FluctuationGUI().setVisible(true);
            }
        });
    }
    
    public void Run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FluctuationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategory1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblForm;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblNote1;
    private javax.swing.JList<AccountDTO> lstAccount;
    private javax.swing.JRadioButton radFixed;
    private javax.swing.JRadioButton radNotFixed;
    private javax.swing.JTree treCategory;
    private javax.swing.JFormattedTextField txtAmount;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables

}


