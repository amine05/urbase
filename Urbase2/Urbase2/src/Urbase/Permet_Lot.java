/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Urbase;

import DB.db_connection;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Amine
 */
public class Permet_Lot extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    int kl =1;
    ResultSet rs;
    db_connection db;
  //  DefaultTableModel model=new DefaultTableModel();
   //  DefaultTableModel model1=new DefaultTableModel();
     DefaultTableModel model;
     DefaultTableModel model1;
    public static  String id;
     int ajout =0;
      String filename="";
       String filename1="";
      
      DefaultTableModel model22 ;

    public Permet_Lot() throws SQLException {
        initComponents();
        kl=1;
        noEnablee();
        txtref1.setFormats("dd-MM-yyyy");
        txtref2.setFormats("dd-MM-yyyy");
        comboZone.setVisible(false);
        textZone.setEnabled(false);
         db = new db_connection();
      
     
        table();
     model22 =new DefaultTableModel();
model22.addColumn("id_zi");  
    

    }
    void actualiser(){
    
  textZone.setText("");
          txZone.setText("");
          txtref1.setDate(null);
                  txtref2.setDate(null);
                  txtid3.setText("");
                          txtid4.setText("");
                          
          
    }

void Enablee(){
        textZone.setEnabled(false);
          txZone.setEnabled(true);
          txtref1.setEnabled(true);
                  txtref2.setEnabled(true);
                  txtid3.setEnabled(true);
                          txtid4.setEnabled(true);
                          jButton10.setEnabled(true);
                               //   jButton11.setEnabled(true);
          
    }
void noEnablee(){
        textZone.setEnabled(false);
          txZone.setEnabled(false);
          txtref1.setEnabled(false);
                  txtref2.setEnabled(false);
                  txtid3.setEnabled(false);
                          txtid4.setEnabled(false);
                          // jButton10.setEnabled(false);
                                  //jButton11.setEnabled(false);
          
    }
    public void table() throws SQLException {
        // String t[] = {"id","code_produit","reference","deseignation","rangement","fournisseur","remise","prix","stock"};
        // rs = db.exécutionQuery("select zone_ind.id_zi,code_zi, lib_zi, sup_zi , date_Creation , nbr_lot,nbr_lotC,nbr_lotS,Sup_Cess,Sup_VS ,OBSERVATION ,n_pl from zone_ind,permis_loture where ((zone_ind.id_zi=permis_loture.id_zi)or(1=1))");
        String id1 = Zone_Indst.id;
     
    
    rs = db.exécutionQuery("select lib_zi,id_pl,n_pl,date_arret, date_publication, n_publication, volume, plan_dossier1,plan_dossier2,plan_dossier3,plan_dossier4,permis_loture.id_zi from permis_loture left join  zone_ind on  permis_loture.id_zi=zone_ind.id_zi where permis_loture.id_zi='"+id1+ "'");
         String name;
         
   model=new DefaultTableModel();
    model1=new DefaultTableModel();
 model.addColumn("lib_zi");
 model.addColumn("volume");
model.addColumn("n_publication");
model.addColumn("date publication");
model.addColumn("n_Arret");
model.addColumn("date Arret");

model.addColumn("id");
   model.addColumn("id_zi");  
    model.addColumn("plan_dossier1");  
    
    
    //1.
   // model1.addColumn("plan_dossier2");  
   while(rs.next()){ 
model.addRow(new Object[]{rs.getString("lib_zi"),rs.getString("volume"),rs.getString("n_publication"),rs.getDate("date_publication"),rs.getString("n_pl")
        ,rs.getDate("date_arret"),rs.getString("id_pl"),rs.getString("id_zi"),rs.getString("plan_dossier1") });
//model1.addRow(new Object[]{rs.getString("id_pl"),rs.getString("id_zi"),rs.getString("plan_dossier1"),rs.getString("plan_dossier2")});

}
   //String  xx; 
      
    //  xx= String.valueOf(model1.getValueAt(0,0));
       tbl_prod.setModel(model);
       
        tbl_prod.getColumnModel().getColumn(6).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(6).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(6).setWidth(0);
   
   tbl_prod.getColumnModel().getColumn(7).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(7).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(7).setWidth(0);
   
   tbl_prod.getColumnModel().getColumn(8).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(8).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(8).setWidth(0);
   
   
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl_prod.getModel());
               tbl_prod.setRowSorter(sorter);
 
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtref2 = new org.jdesktop.swingx.JXDatePicker();
        txtref1 = new org.jdesktop.swingx.JXDatePicker();
        txtid3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtid4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textZone = new javax.swing.JTextField();
        comboZone = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txZone = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("nom Zone :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 20, 100, 27);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("date Arrêté de PL :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(390, 100, 100, 27);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("date pub de PL :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(390, 60, 100, 27);
        jPanel2.add(txtref2);
        txtref2.setBounds(500, 60, 190, 30);
        jPanel2.add(txtref1);
        txtref1.setBounds(500, 100, 190, 30);
        jPanel2.add(txtid3);
        txtid3.setBounds(130, 60, 100, 30);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("num pub de PL");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 60, 100, 27);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("volume :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(390, 20, 100, 27);
        jPanel2.add(txtid4);
        txtid4.setBounds(500, 20, 100, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("num Arrêté de PL");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 100, 100, 30);
        jPanel2.add(textZone);
        textZone.setBounds(130, 20, 100, 30);

        jPanel2.add(comboZone);
        comboZone.setBounds(130, 20, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/Documents-icon.png"))); // NOI18N
        jButton1.setText("plan dossier1 :");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 160, 150, 40);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/fff.png"))); // NOI18N
        jButton10.setText("afficher");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(190, 160, 120, 40);
        jPanel2.add(txZone);
        txZone.setBounds(130, 100, 100, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton6.setText("ajouter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton7.setText("modifier");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton8.setText("supprimer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton9.setText("actualiser");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
         noEnablee();
        ajout=0;
       
        // filename1=(String.valueOf(model1.getValueAt(tbl_prod.getSelectedRow(),3)));
        textZone.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(),0)));
        txtid4.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(),1)));
         txtid3.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(),2)));
          txtref2.setDate((Date) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 3));
          
        txZone.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 4)));
        Date date ;
       
   //   rr.setFormats("dd-MM-yyyy HH:mm:ss");
      
     // DD.setDate((date)tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2));
      txtref1.setDate((Date) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 5));
     
       
        
       
        
         
        id= String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 6));
         filename=(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(),8)));
        // txtid.setEnabled(false);            // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodMouseClicked
 
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if(ajout==0){
    textZone.setVisible(false);
    comboZone.setVisible(true);
    String name_Zone;
    actualiser();
     ResultSet rs1 ;
        rs1 = db.exécutionQuery("SELECT lib_zi,zone_ind.id_zi FROM zone_ind left join permis_loture on permis_loture.id_zi=zone_ind.id_zi where permis_loture.id_zi is null ");
   
 
        try {
             comboZone.removeAllItems();
        while (rs1.next()) {
            name_Zone = rs1.getString("lib_zi");
            comboZone.addItem(name_Zone);
          model22.addRow(new Object[]{rs1.getString("id_zi")});
        }
       
          
    } catch (SQLException ex) {
        Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
        Enablee();
ajout=1;

}else{
   
        try {
            
       String  xx =(String) comboZone.getSelectedItem();
   String id_z;
    
   id_z= String.valueOf(model22.getValueAt(comboZone.getSelectedIndex(), 0));
             
            if((txtref1.getDate()!=null)&&(txtref2.getDate()!=null)){
            
            
        
            Date date=txtref1.getDate();
Date date2=txtref2.getDate();
    String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
    String newstring2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
    
            rs = db.exécutionUpdate("INSERT INTO permis_loture (date_arret,date_publication,n_pl,n_publication,volume, id_zi,plan_dossier1)VALUES ('"+ newstring+"','"+newstring2+"','"+txZone.getText()+"','"+txtid3.getText()+"','"+txtid4.getText()+"','"+id_z+"','"+filename+"')");
           actualiser();
            table();}
            
            else if(txtref1.getDate()!=null){
             Date date=txtref1.getDate();
              String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
              rs = db.exécutionUpdate("INSERT INTO permis_loture (date_arret,date_publication,n_pl,n_publication,volume, id_zi,plan_dossier1)VALUES ('"+ newstring+"',"+null+",'"+txZone.getText()+"','"+txtid3.getText()+"','"+txtid4.getText()+"','"+id_z+"','"+filename+"')");
           actualiser();
            table();
            }else if(txtref2.getDate()!=null){
            Date date2=txtref2.getDate();
              String newstring2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
              rs = db.exécutionUpdate("INSERT INTO permis_loture (date_arret,date_publication,n_pl,n_publication,volume, id_zi,plan_dossier1)VALUES ("+ null+",'"+newstring2+"','"+txZone.getText()+"','"+txtid3.getText()+"','"+txtid4.getText()+"','"+id_z+"','"+filename+"')");
           actualiser();
            table();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
        }
        ajout=0;
         comboZone.setVisible(false);
        textZone.setVisible(true);
        noEnablee();
   
}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
if (ajout ==0){ textZone.setEnabled(false);
ajout =1;
Enablee();
//actualiser();
}
else{
        try {
            ajout =0;
            noEnablee();
            
          
            // txid.setText(String.valueOf(model1.getValueAt(tbl_prod.getSelectedRow(), 0)));
            if((txtref1.getDate()!=null)&&(txtref1.getDate()!=null)){
      Date date=txtref1.getDate();
Date date2=txtref2.getDate();
    String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
    String newstring2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);       
            rs = db.exécutionUpdate("update  permis_loture set date_arret='" +newstring+"',date_publication= '"+newstring2+"',n_pl= '"+txZone.getText()+"',n_publication= '"+txtid3.getText()+"',volume= '"+txtid4.getText()+"',plan_dossier1= '"+filename+"' where id_pl='"+id+"'");
            table();}
            else if (txtref1.getDate()!=null){
        Date date=txtref1.getDate();

    String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
             rs = db.exécutionUpdate("update  permis_loture set date_arret='" +newstring+"',date_publication= "+null+",n_pl= '"+txZone.getText()+"',n_publication= '"+txtid3.getText()+"',volume= '"+txtid4.getText()+"',plan_dossier1= '"+filename+"' where id_pl='"+id+"'");
            table();
        }
            else if(txtref2.getDate()!=null){
            
Date date2=txtref2.getDate();
    
    String newstring2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);       
            rs = db.exécutionUpdate("update  permis_loture set date_arret="+null+" ,date_publication= '"+newstring2+"',n_pl= '"+txZone.getText()+"',n_publication= '"+txtid3.getText()+"',volume= '"+txtid4.getText()+"',plan_dossier1= '"+filename+"'where id_pl='"+id+"'");
            table();
            }
            
            
            
            
            
            
            
            }
        
        catch (SQLException ex) {
            Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);                                                                                                                  
        }
  actualiser();
}
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            rs = db.exécutionUpdate("delete from  permis_loture where id_pl='"+id+"'");
            
            
            table();} catch (SQLException ex) {
            Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        txZone.setText("");
        txtref2.setDate(null);
        //  txid.setText("");
        txtref1.setDate(null);
        

    }//GEN-LAST:event_jButton9ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
         Zone_Indst.kk=1;
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f= chooser.getSelectedFile();
             filename = f.getAbsolutePath();
          String path =filename;
           filename= filename.replace("\\", "\\\\");
           
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        if((filename.equals(""))||(filename.equals("null"))){
 JOptionPane.showMessageDialog(this, "aucun fichier a afficher");    
    
    }else{
//        Runtime rr= Runtime.getRuntime();
       
        try {
           // Process p = rr.exec("C:\\Program Files (x86)\\Notepad++\\Notepad++.exe "+filename);
           // Process p = rr.exec("C:\\Program Files (x86)\\Nitro\\Pro 9\\NitroPDF.exe "+filename);
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename);
//  Runtime.getRuntime().exec("notpade","C:\\Program Files (x86)\\Notepad++\\readme.txt");        // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Permet_Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permet_Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permet_Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permet_Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Permet_Lot().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboZone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField textZone;
    private javax.swing.JTextField txZone;
    private javax.swing.JTextField txtid3;
    private javax.swing.JTextField txtid4;
    private org.jdesktop.swingx.JXDatePicker txtref1;
    private org.jdesktop.swingx.JXDatePicker txtref2;
    // End of variables declaration//GEN-END:variables
}
