/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Urbase;

import DB.db_connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

/**
 *
 * @author Amin
 */
public class Invst extends javax.swing.JFrame {

    /**
     * Creates new form Invst
     */
    ResultSet rs;
    db_connection db;
     DefaultTableModel model;
     DefaultTableModel model1;
     String id;

    public Invst() throws SQLException {

        db = new db_connection();
        initComponents();
        
        table();
       ////////////////////////////////////////////////
    //   JXDatePicker datePicker = new JXDatePicker();
//dt.setFormats("dd-MM-yyyy HH:mm:ss");

/*
  set in any way value inside datePicker
*/
       // dt.getEditor();
       // System.out.println("dt.getEditor() "+dt.getName());
       // JFormattedTextField editor = dt.getEditor();
//Date dateInDatePicker = (Date) editor.getValue();

      // System.out.println("Date) editor.getValue() "+dateInDatePicker);
       ////////////////////////////////////////////////////////
       
    }
   
    
    
    
    // JOptionPane.showMessageDialog(this, "SVP entrer les informations complete");
 public void table() throws SQLException {
       // String t[] = {"id","code_produit","reference","deseignation","rangement","fournisseur","remise","prix","stock"};
   
       rs = db.exécutionQuery("select cod_invst,nom_invst, activite,id_invst from investisseur");
    
   
  
 model=new DefaultTableModel();
    model1=new DefaultTableModel();
 model.addColumn("code");
model.addColumn("nom");
    model.addColumn("activites");

model1.addColumn("id");
       // x = new String[rs.];
   while(rs.next()){
model.addRow(new Object[]{rs.getString("cod_invst"),rs.getString("nom_invst"),rs.getString("activite")});
model1.addRow(new Object[]{rs.getString("id_invst")});
}
 //   x = new String[rs.;
       tbl_prod.setModel(model);
       //TableFilterHeader filterHeader = new TableFilterHeader(tbl_prod, AutoChoices.ENABLED);

     //  model.getValueAt(1,3);
  //System.out.println("ggg    ::   "+ model.getValueAt(1,model.g));
       //tbl_prod
        //  TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl_prod.getModel());
            //   tbl_prod.setRowSorter(sorter);

              // List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
             //  sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
              //  sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
              // sorter.setSortKeys(sortKeys);
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtref = new javax.swing.JTextField();
        txtdes2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbl_prod.setAutoCreateRowSorter(true);
        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_prod.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tbl_prodMouseDragged(evt);
            }
        });
        tbl_prod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_prodFocusGained(evt);
            }
        });
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        tbl_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_prodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_prodKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Code_investisseur :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 10, 100, 27);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Nom_investisseur : ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 50, 100, 27);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("Activité :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 100, 100, 27);
        jPanel2.add(txtid);
        txtid.setBounds(120, 10, 140, 30);
        jPanel2.add(txtref);
        txtref.setBounds(120, 50, 140, 30);

        txtdes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdes2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtdes2);
        txtdes2.setBounds(120, 100, 140, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/ajouter.png"))); // NOI18N
        jButton2.setText("ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/modifier.png"))); // NOI18N
        jButton3.setText("modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/supprimer.png"))); // NOI18N
        jButton4.setText("supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/actualiser .png"))); // NOI18N
        jButton5.setText("actualiser");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("INVESTISSEURS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        //rs=db.exécutionQuery("select id from investisseur" );
        txtid.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0)));
        txtref.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 1)));
        txtdes2.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2)));
        id= String.valueOf(model1.getValueAt(tbl_prod.getSelectedRow(), 0));
        

// TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void tbl_prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_prodKeyReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodKeyReleased

    private void tbl_prodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_prodFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodFocusGained

    private void tbl_prodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_prodKeyPressed
       // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodKeyPressed

    private void tbl_prodMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseDragged
         // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodMouseDragged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      txtid.setText("");
        txtref.setText("");
      //  txid.setText("");
        txtdes2.setText("");
       
    }//GEN-LAST:event_jButton5ActionPerformed

        void    actualiser(){
                txtid.setText("");
            
        txtref.setText("");
        txtdes2.setText("");
        //txtran.setText("");
           // TODO add your handling code here:
            }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 rs = db.exécutionUpdate("delete from  investisseur where id_invst='"+id+"'");
    

        try {
            table();//afficher et actualiser le tableau
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
            actualiser();          
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// txid.setText(String.valueOf(model1.getValueAt(tbl_prod.getSelectedRow(), 0)));
 
    
        rs = db.exécutionUpdate("update  investisseur set cod_invst='" +txtid.getText()+"',nom_invst= '"+txtref.getText()+"'where id_invst='"+id+"'");
    

        try {
            table();//afficher et actualiser le tableau
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
            actualiser();     //vider les champs    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        rs = db.exécutionUpdate("INSERT INTO investisseur (cod_invst,nom_invst,activite)VALUES ('"+txtid.getText()+"','"+txtref.getText()+"','"+txtdes2.getText()+"')");
        try {
            table();
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
            actualiser();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void txtdes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdes2ActionPerformed

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
            java.util.logging.Logger.getLogger(Invst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Invst().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField txtdes2;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtref;
    // End of variables declaration//GEN-END:variables
}
