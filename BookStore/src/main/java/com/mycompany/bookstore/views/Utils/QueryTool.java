/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bookstore.views.Utils;

import javax.swing.JOptionPane;
import com.mycompany.bookstore.controller.BookController;
import com.mycompany.bookstore.dataBase.ConnectionSQL;
import com.mycompany.bookstore.model.Book;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.bookstore.views.LibraryFrame;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class QueryTool extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form QueryTool
     */
    public QueryTool() {
        initComponents();
        this.model.addColumn("ID");
        this.model.addColumn("TITLE");
        this.model.addColumn("AUTHOR");
        this.model.addColumn("PRICE");
        this.model.addColumn("YEAR");
        this.model.addColumn("RENTEND");

        updateList();

        this.referenceTable.setModel(model);

        referenceInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(referenceInput.getText());
                String input = referenceInput.getText();

                if (!input.isEmpty()) {
                    updateReferenceList(input);
                }
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
    }

    public void updateList() {
        model.setRowCount(0);
        ArrayList<Book> booksTable = BookController.findBooks();
        for (Book b : booksTable) {
            this.model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), b.getYear(), b.isIsRetend()});
        }

    }

    public void updateReferenceList(String str) {
        model.setRowCount(0);
        ArrayList<Book> referenceList = BookController.getByReference(str);
        for (Book b : referenceList) {
            this.model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), b.getYear(), b.isIsRetend()});
        }

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
        referenceInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        referenceTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        queryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        referenceInput.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                referenceInputAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        referenceInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                referenceInputFocusGained(evt);
            }
        });
        referenceInput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                referenceInputPropertyChange(evt);
            }
        });

        referenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        referenceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                referenceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(referenceTable);

        jButton1.setText("Importar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        queryButton.setText("Pesquisar");
        queryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(referenceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(queryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(878, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referenceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void referenceInputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_referenceInputPropertyChange

    }//GEN-LAST:event_referenceInputPropertyChange

    private void referenceInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceInputFocusGained

    }//GEN-LAST:event_referenceInputFocusGained

    private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryButtonActionPerformed
        String input = referenceInput.getText();

        if (!input.isEmpty()) {
            updateReferenceList(input);
        }
    }//GEN-LAST:event_queryButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void referenceInputAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_referenceInputAncestorAdded

    }//GEN-LAST:event_referenceInputAncestorAdded

    private void referenceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceTableMouseClicked
         int index = referenceTable.getSelectedRow();
        if (index != index - 1) {
            String IdbookSelected = "" + model.getValueAt(index, 0);
            String nameBookSelected = "" + model.getValueAt(index, 1);
            String authorBookSelected = "" + model.getValueAt(index, 2);
            String priceBookSelected = "" + model.getValueAt(index, 3);
            String yearBookSelected = "" + model.getValueAt(index, 4);
            
            System.out.println(IdbookSelected);
            
            LibraryFrame newDisplay = new LibraryFrame(IdbookSelected, nameBookSelected, authorBookSelected, priceBookSelected, yearBookSelected);
            JOptionPane.showConfirmDialog(this, "ok");
            
            
            newDisplay.setVisible(true);
        }
    }//GEN-LAST:event_referenceTableMouseClicked

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
            java.util.logging.Logger.getLogger(QueryTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton queryButton;
    private javax.swing.JTextField referenceInput;
    private javax.swing.JTable referenceTable;
    // End of variables declaration//GEN-END:variables
}
