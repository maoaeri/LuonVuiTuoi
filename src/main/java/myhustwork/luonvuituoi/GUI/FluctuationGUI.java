/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myhustwork.luonvuituoi.GUI;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import myhustwork.luonvuituoi.BLL.*;
import myhustwork.luonvuituoi.DAO.*;
import myhustwork.luonvuituoi.DTO.*;
import myhustwork.luonvuituoi.Util.Converter;

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
    private CategoryBLL catBLL;
    private AccountBLL accBLL;
    private FluctuationBLL flucBLL;
    private int accId;
    private int flucId;
    /**
     * Creates new form AddFluctuationForm
     */
    public FluctuationGUI() {
        accId = -1;
        flucId = -1;
        flucDAO = new FluctuationDAO();
        catDAO = new CategoryDAO();
        stuffDAO = new StuffDAO();
        accDAO = new AccountDAO();
        catBLL = new CategoryBLL();
        accBLL = new AccountBLL();
        flucBLL = new FluctuationBLL();
        this.setTitle("LuonVuiTuoi");
        initComponents();
        List<FluctuationDTO> dataset = null;
        
        try {
            dataset = flucBLL.getAllFlucDataset();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        FluctuationTableModel model = new FluctuationTableModel(dataset);
        //create the table
        tblFluc.setModel(model);
        tblFluc.repaint();
    }

    public int getFlucId() {
        return flucId;
    }

    public void setFlucId(int flucId) {
        this.flucId = flucId;
    }
    
    @Override
    public void display(FluctuationDTO fluc){
        txtAmount.setText(fluc.getAmount() + "");
        txtDate.setDate(Date.from(fluc.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        txtNote.setText(fluc.getNote());
        lblCategory.setText(fluc.getCategory().getCategoryName());
        radFixed.setSelected(fluc.isFixed());
        radNotFixed.setSelected(!fluc.isFixed());
        lblAccountName.setText(fluc.getAccount().getName());

    }
    
    @Override
    public void refreshComponents(){
        txtAmount.setText("");
        txtDate = new JDateChooser();
        txtNote.setText("");
        lblCategory.setText("");
        radFixed.setSelected(false);
        radNotFixed.setSelected(false);
        lblAccountName.setText("");
                accId = -1;
        flucId = -1;
        lstAccount.setModel(getAllAccounts());
    }
    
    @Override
    public FluctuationDTO getInfor() throws ParseException, SQLException {
        FluctuationDTO fluc = new FluctuationDTO();
        if (accId == -1){
            fluc.setAccount(new AccountDTO(0));
            
        } else {
            fluc.setAccount(lstAccount.getSelectedValue());
            this.accId = -1;
        }
        fluc.setID(this.flucId);
        fluc.setAmount(Converter.formatAmount(txtAmount.getText()));
        if (!treCategory.isSelectionEmpty()){
           DefaultMutableTreeNode selectedNode2 = (DefaultMutableTreeNode) treCategory.getLastSelectedPathComponent();
            String rootType = selectedNode2.getPath()[1].toString();
            int categoryType = 0;
            System.out.println(rootType);
            switch (rootType) {
                case "Thu" ->  {
                    categoryType = 1;
                    break;
                }
                case "Chi" ->  {
                    categoryType = 0;
                    break;
                }
            }
            String categoryName = selectedNode2.getUserObject().toString();
            CategoryDTO cat = new CategoryDTO(categoryType, categoryName);
            fluc.setCategory(cat); 
        }
        fluc.setDate(Converter.fromDatetoLocalDate(txtDate.getDate()));
        fluc.setNote(txtNote.getText());
        fluc.setFixed(this.fixedButtonpressed);
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFluc = new javax.swing.JTable();
        String[] catNameList = null;
        try {
            catNameList = catBLL.getAllNames();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        jcbCat = new javax.swing.JComboBox<>();
        String[] accNameList = null;
        try {
            accNameList = accBLL.getAllNames();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        jcbAccount = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        lblAccountName = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 175, 175));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

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
        lblForm.setText("Biến động số dư");

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

        tblFluc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListSelectionModel tblFlucSelectionModel = tblFluc.getSelectionModel();
        tblFlucSelectionModel.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                tblFlucValueChanged(event);
            }
        });
        jScrollPane4.setViewportView(tblFluc);

        jcbCat.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        jcbCat.setForeground(new java.awt.Color(255, 51, 51));
        jcbCat.setModel(new javax.swing.DefaultComboBoxModel<>(catNameList));
        //jcbCat.setRenderer(new CategoryItemRenderer());

        jcbAccount.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        jcbAccount.setForeground(new java.awt.Color(255, 51, 51));
        jcbAccount.setModel(new javax.swing.DefaultComboBoxModel<>(accNameList));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAll.setBackground(new java.awt.Color(255, 51, 51));
        btnAll.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnAll.setForeground(new java.awt.Color(255, 255, 255));
        btnAll.setText("Tất cả");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        lblAccountName.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        lblAccountName.setForeground(new java.awt.Color(255, 51, 51));

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(255, 51, 51));
        txtDate.setDateFormatString("dd/MM/yyyy");
        txtDate.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N

        btnRefresh.setBackground(new java.awt.Color(255, 51, 51));
        btnRefresh.setFont(new java.awt.Font("r0c0i Linotte", 0, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(btnAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(450, 450, 450))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblForm))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCategory1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblNote1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(radNotFixed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(radFixed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lblAccountName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(436, 436, 436))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblForm)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAccountName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAmount))
                                    .addGap(18, 18, 18)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCategory1))
                                            .addGap(4, 4, 4)
                                            .addComponent(radFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(radNotFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGap(168, 168, 168)
                                            .addComponent(lblNote1))))))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAll)
                            .addComponent(btnRefresh))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
                FluctuationDTO fluc = this.getInfor();
                flucBLL.deleteFromGUI(fluc);
                
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        
        refreshComponents();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            FluctuationDTO fluc = this.getInfor();
            flucBLL.updateFromGUI(fluc);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
            } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        refreshComponents();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
                FluctuationDTO fluc = this.getInfor();
                flucBLL.addFromGUI(fluc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            }
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
    }//GEN-LAST:event_lstAccountValueChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String catName = null;
        String accName = null;
        try {
            catName = jcbCat.getSelectedItem().toString();
            accName = jcbAccount.getSelectedItem().toString();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn điều kiện tìm kiếm.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        List<FluctuationDTO> dataset = null;
        
        try {
            dataset = flucBLL.getFlucDatasetByCategoryAndAccount(catName, accName);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        FluctuationTableModel model = new FluctuationTableModel(dataset);
        //create the table
        tblFluc.setModel(model);
        tblFluc.repaint();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        // TODO add your handling code here:
        List<FluctuationDTO> dataset = null;
        
        try {
            dataset = flucBLL.getAllFlucDataset();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        FluctuationTableModel model = new FluctuationTableModel(dataset);
        //create the table
        tblFluc.setModel(model);
        tblFluc.repaint();
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refreshComponents();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblFlucValueChanged(javax.swing.event.ListSelectionEvent evt){
        flucId = Integer.parseInt(tblFluc.getValueAt(tblFluc.getSelectedRow(), 0).toString());
        FluctuationDTO fluc = null;
        try {
           fluc = flucBLL.get(flucId);
            display(fluc);
            tblFluc.clearSelection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occured", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        tblFluc.clearSelection();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> jcbAccount;
    private javax.swing.JComboBox<String> jcbCat;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAccountName;
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
    private javax.swing.JTable tblFluc;
    private javax.swing.JTree treCategory;
    private javax.swing.JFormattedTextField txtAmount;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables

}

class FluctuationTableModel extends AbstractTableModel{
    
    private final List<FluctuationDTO> datasetList;
     
    private final String[] columnNames = new String[] {
            "Id", "Số tiền", "Ngày tháng", "Tên hạng mục", "Ghi chú"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class ,Long.class, LocalDate.class, String.class, String.class
    };
 
    public FluctuationTableModel(List<FluctuationDTO> datasetList)
    {
        this.datasetList = datasetList;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return datasetList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        FluctuationDTO row = datasetList.get(rowIndex);
        if (0 == columnIndex){
            return row.getID();
        }
        else if(1 == columnIndex) {
            return row.getAmount();
        }
        else if(2 == columnIndex) {
            return row.getDate();
        }
        else if(3 == columnIndex) {
            return row.getCategory().getCategoryName();
        }
        else if (4 == columnIndex) {
            return row.getNote();
        }
        return null;
    }
}

class CategoryItemRenderer extends BasicComboBoxRenderer {
  public Component getListCellRendererComponent(JList<? extends CategoryDTO> list, CategoryDTO cat, int index,
            boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, cat, index, isSelected,
        cellHasFocus);

    if (index == -1) {
      setText(cat.getCategoryName());
    } else {
      setText(cat.getCategoryName());    }
    return this;
  }
}