/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }

    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;

    @SuppressWarnings("unchecked")

    public void SelectMed() throws SQLException {
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("SELECT * FROM USER1.MEDICINETB");
        MedicinesTable.setModel(DbUtils.resultSetToTableModel(Rs1));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        QTY = new javax.swing.JTextField();
        CompId = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicinesTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        Seller = new javax.swing.JLabel();
        Seller1 = new javax.swing.JLabel();
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
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("QTY");

        QTY.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        CompId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(51, 204, 0));
        AddBtn.setText("ADD");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });

        UpdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(51, 204, 0));
        UpdateBtn.setText("UPDATE");
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });

        DelBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DelBtn.setForeground(new java.awt.Color(51, 204, 0));
        DelBtn.setText("DELETE");
        DelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBtnMouseClicked(evt);
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 204, 0));
        jLabel13.setText("X");

        ClearBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(51, 204, 0));
        ClearBtn.setText("CLEAR");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        Seller.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Seller.setForeground(new java.awt.Color(255, 0, 51));
        Seller.setText("Seller");

        Seller1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Seller1.setForeground(new java.awt.Color(255, 0, 51));
        Seller1.setText("Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Seller, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Seller1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(AddBtn)
                                        .addGap(42, 42, 42)
                                        .addComponent(UpdateBtn)
                                        .addGap(72, 72, 72)
                                        .addComponent(DelBtn)
                                        .addGap(46, 46, 46)
                                        .addComponent(ClearBtn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CompId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(169, 169, 169))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seller)
                    .addComponent(Seller1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CompId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn)
                            .addComponent(UpdateBtn)
                            .addComponent(DelBtn)
                            .addComponent(ClearBtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        CompId.setText("");
        QTY.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void MedicinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicinesTableMouseClicked
//                DefaultTableModel model = (DefaultTableModel) MedicinesTable.getModel();
//                int myindex = MedicinesTable.getSelectedRow();
//                CompId.setText(model.getValueAt(myindex, 0).toString());
//                CompName.setText(model.getValueAt(myindex, 1).toString());
//                CompAd.setText(model.getValueAt(myindex, 2).toString());
//                CompPhone.setText(model.getValueAt(myindex, 3).toString());
//                CompExp.setText(model.getValueAt(myindex, 4).toString());
    }//GEN-LAST:event_MedicinesTableMouseClicked

    private void DelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBtnMouseClicked
        //        if (CompId.getText().isEmpty()) {
            //            JOptionPane.showMessageDialog(this, "Enter the Company to be Deleted");
            //        } else {
            //            try {
                //                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
                //                String Id = CompId.getText();
                //                String Query = "Delete from USER1.COMPANYTB where COMPID=" + Id;
                //                Statement Add = Con.createStatement();
                //                Add.executeUpdate(Query);
                //                SelectMed();
                //                JOptionPane.showMessageDialog(this, "Company deleted Successfully");
                //            } catch (SQLException e) {
                //                e.printStackTrace();
                //            }
            //        }
    }//GEN-LAST:event_DelBtnMouseClicked

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        //        if (CompId.getText().isEmpty() || CompName.getText().isEmpty() || CompAd.getText().isEmpty() || CompPhone.getText().isEmpty() || CompExp.getText().isEmpty()) {
            //            JOptionPane.showMessageDialog(this, "Missing Information");
            //
            //        } else {
            //            try {
                //                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
                //                String UpdateQuery = "UPDATE USER1.COMPANYTB set COMPNAME='"
                //                        + CompName.getText() + "'" + ", COMPAD='" + CompAd.getText() + "'"
                //                        + ",COMPEXP=" + CompExp.getText() + "" + ",COMPPHONE='" + CompPhone.getText() + "'"
                //                        + "where COMPID = " + CompId.getText();
                //                Statement Add = Con.createStatement();
                //                Add.executeUpdate(UpdateQuery);
                //                SelectMed();
                //                JOptionPane.showMessageDialog(this, "Company updated Successfully");
                //
                //            } catch (SQLException e) {
                //                e.printStackTrace();
                //            }
            //        }
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        //        try {
            //            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Pharmadb", "User1", "user1");
            //            PreparedStatement add = Con.prepareStatement("insert into COMPANYTB values(?,?,?,?,?)");
            //            add.setInt(1, Integer.valueOf(CompId.getText()));
            //            add.setString(2, CompName.getText());
            //            add.setString(3, CompAd.getText());
            //            add.setString(4, CompPhone.getText());
            //            add.setInt(5, Integer.valueOf(CompExp.getText()));
            //            int row = add.executeUpdate();
            //            JOptionPane.showMessageDialog(this, "Company Successfully Added");
            //            Con.close();
            //            SelectMed();
            //
            //        } catch (SQLException e) {
            //            e.printStackTrace();
            //        }
    }//GEN-LAST:event_AddBtnMouseClicked

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
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel AgentsLbl;
    private javax.swing.JLabel COMPANY;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextField CompId;
    private javax.swing.JButton DelBtn;
    private javax.swing.JLabel MedicinesLbl;
    private javax.swing.JTable MedicinesTable;
    private javax.swing.JTextField QTY;
    private javax.swing.JLabel Seller;
    private javax.swing.JLabel Seller1;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
