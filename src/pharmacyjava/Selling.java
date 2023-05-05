/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyjava;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Егор
 */
public class Selling extends javax.swing.JFrame {

    /**
     * Creates new form Selling
     */
    public Selling() throws SQLException {
        initComponents();
        SelectMed();
        ShowDate();
    }

    public void ShowDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        DateLbl.setText(s.format(d));
    }

    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;
    int i = 0, price, MedId;

    @SuppressWarnings("unchecked")

    public void SelectMed() throws SQLException {
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("SELECT * FROM USER1.MEDICINETB");
        MedicinesTable.setModel(DbUtils.resultSetToTableModel(Rs1));
    }

    public boolean testQTY() {
        boolean Bqty = true;
        DefaultTableModel model = (DefaultTableModel) MedicinesTable.getModel();
        int myindex = MedicinesTable.getSelectedRow();
        int newQty;
        int OldQTY = Integer.valueOf(model.getValueAt(myindex, 3).toString());
        return Bqty = (Integer.valueOf(QTY.getText()) < OldQTY);

    }

    public void update() {
        DefaultTableModel model = (DefaultTableModel) MedicinesTable.getModel();
        int myindex = MedicinesTable.getSelectedRow();
        int newQty;
        int OldQTY = Integer.valueOf(model.getValueAt(myindex, 3).toString());
        if (testQTY()) {
            newQty = OldQTY - Integer.valueOf(QTY.getText());
            if (newQty < 0) {
                newQty = 0;
            }
        } else {
            newQty = Integer.valueOf(model.getValueAt(myindex, 3).toString());
            JOptionPane.showMessageDialog(this, "Incorrect quantity");
        }

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
            String UpdateQuery = "UPDATE USER1.MEDICINETB set MEDQTY="
                    + newQty + "where MEDID = " + MedId;
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            SelectMed();
            JOptionPane.showMessageDialog(this, "Medicine updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        QTY = new javax.swing.JTextField();
        BILLID = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        PrintBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicinesTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        CloseLbl = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        SellerLbl = new javax.swing.JLabel();
        DateLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Medtext = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTxt = new javax.swing.JTextArea();
        MedicinesLbl = new javax.swing.JLabel();
        AgentsLbl = new javax.swing.JLabel();
        COMPANY = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(837, 527));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(837, 527));

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(837, 527));
        jPanel1.setPreferredSize(new java.awt.Dimension(837, 527));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(51, 153, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 205, 0));
        jLabel4.setText("BILLING");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("BILLID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("QTY");

        QTY.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        BILLID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(51, 204, 0));
        AddBtn.setText("ADD TO BILL");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        PrintBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PrintBtn.setForeground(new java.awt.Color(51, 204, 0));
        PrintBtn.setText("PRINT");
        PrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBtnMouseClicked(evt);
            }
        });

        MedicinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Address", "Phone", "Experience"
            }
        ));
        MedicinesTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        MedicinesTable.setRowHeight(25);
        MedicinesTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        MedicinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicinesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MedicinesTable);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 204, 0));
        jLabel12.setText("MEDICINES LIST");

        CloseLbl.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        CloseLbl.setForeground(new java.awt.Color(51, 204, 0));
        CloseLbl.setText("X");
        CloseLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLblMouseClicked(evt);
            }
        });

        ClearBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(51, 204, 0));
        ClearBtn.setText("CLEAR");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        SellerLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SellerLbl.setForeground(new java.awt.Color(255, 0, 51));
        SellerLbl.setText("Seller");

        DateLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DateLbl.setForeground(new java.awt.Color(255, 0, 51));
        DateLbl.setText("Date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("MEDICINE");

        Medtext.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 204, 0));
        jLabel14.setText("BILL");

        BillTxt.setColumns(20);
        BillTxt.setRows(5);
        BillTxt.setToolTipText("");
        jScrollPane2.setViewportView(BillTxt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CloseLbl))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Medtext, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BILLID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(169, 169, 169))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(AddBtn)
                                .addGap(127, 127, 127)
                                .addComponent(PrintBtn)
                                .addGap(129, 129, 129)
                                .addComponent(ClearBtn)
                                .addGap(44, 44, 44)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SellerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CloseLbl))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SellerLbl)
                    .addComponent(DateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BILLID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Medtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(ClearBtn)
                    .addComponent(PrintBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        MedicinesLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MedicinesLbl.setForeground(new java.awt.Color(255, 255, 255));
        MedicinesLbl.setText("MEDICINES");
        MedicinesLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicinesLblMouseClicked(evt);
            }
        });

        AgentsLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AgentsLbl.setForeground(new java.awt.Color(255, 255, 255));
        AgentsLbl.setText("AGENTS");
        AgentsLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgentsLblMouseClicked(evt);
            }
        });

        COMPANY.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        COMPANY.setForeground(new java.awt.Color(255, 255, 255));
        COMPANY.setText("COMPANY");
        COMPANY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                COMPANYMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MedicinesLbl)
                    .addComponent(AgentsLbl)
                    .addComponent(COMPANY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(MedicinesLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgentsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(COMPANY)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MedicinesLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicinesLblMouseClicked
        try {
            new Medicine().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MedicinesLblMouseClicked

    private void AgentsLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgentsLblMouseClicked
        try {
            new Agents().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AgentsLblMouseClicked

    private void COMPANYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COMPANYMouseClicked
        try {
            new Company().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_COMPANYMouseClicked

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        BILLID.setText("");
        QTY.setText("");
        Medtext.setText("");
        BillTxt.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void MedicinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicinesTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) MedicinesTable.getModel();
        int myindex = MedicinesTable.getSelectedRow();
        MedId = Integer.valueOf(model.getValueAt(myindex, 0).toString());
        Medtext.setText(model.getValueAt(myindex, 1).toString());
        price = Integer.valueOf(model.getValueAt(myindex, 2).toString());

    }//GEN-LAST:event_MedicinesTableMouseClicked

    private void PrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMouseClicked
        try {
            BillTxt.print();
        } catch (java.awt.print.PrinterAbortException e) {
            System.err.format("No printer found", e.getMessage());
        } catch (PrinterException ex) {
            Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintBtnMouseClicked


    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked

        if (Medtext.getText().isEmpty() || QTY.getText().isEmpty() || !testQTY()) {

            JOptionPane.showMessageDialog(this, "Missing infirmation");
        } else {
            i++;
            update();
            if (i == 1) {
                BillTxt.setText("    ****************************************************PharmaCenter***********************************************    \n"
                        + "\t\t         ID\tMEDICINE\tQTY\tPRICE\tTOTAL\n"
                        + "\t\t         " + i + "\t" + Medtext.getText()
                        + "\t" + QTY.getText() + "\t" + price + "\t" + Integer.valueOf(QTY.getText()) * price + "\n");
            } else {
                BillTxt.setText(BillTxt.getText()
                        + "\t\t         " + i + "\t" + Medtext.getText()
                        + "\t" + QTY.getText() + "\t" + price + "\t" + Integer.valueOf(QTY.getText()) * price + "\n");
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void CloseLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLblMouseClicked
                System.exit(0);
    }//GEN-LAST:event_CloseLblMouseClicked

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Selling().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Selling.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel AgentsLbl;
    private javax.swing.JTextField BILLID;
    private javax.swing.JTextArea BillTxt;
    private javax.swing.JLabel COMPANY;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel CloseLbl;
    private javax.swing.JLabel DateLbl;
    private javax.swing.JLabel MedicinesLbl;
    private javax.swing.JTable MedicinesTable;
    private javax.swing.JTextField Medtext;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JTextField QTY;
    private javax.swing.JLabel SellerLbl;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
