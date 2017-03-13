/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Urbase;

import DB.db_connection;
import static Urbase.Zone_Indst.kk;
import com.mxrck.autocompleter.TextAutoCompleter;
import static java.lang.String.format;
import static java.lang.String.format;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static mondrian.olap.fun.vba.Vba.date;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import static org.apache.tools.ant.util.DateUtils.format;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author admin
 */

public class Lot extends javax.swing.JFrame {
 ResultSet rs,rs1,rs2;
 int ajout =0;
    db_connection db;
    DefaultTableModel model;
     DefaultTableModel model1,model44,model55;
    public static String id;
     static public int kk =1;
     static public String name;
    String EE,id_invst,id_zi;
    int creer=0;
    /**
     * Creates new form Lot
     */
    public Lot() throws SQLException {
        initComponents();
        db = new db_connection();
      //  date_C.setFormats("dd-MM-yyyy");
        date_A.setFormats("dd-MM-yyyy");
         noEnable();
          model44 =new DefaultTableModel();
          model55 =new DefaultTableModel();
model44.addColumn("id_zi"); 
model55.addColumn("id_invst"); 

    //comboZone.setVisible(false);
    
    comboINVST.setVisible(false);
     INVST.setEnabled(false);
    // ZONE.setEnabled(false);
    String a,b;
     rs1 = db.exécutionQuery("SELECT lib_zi ,id_zi FROM zone_ind ");
        while (rs1.next()) {
            a = rs1.getString("lib_zi");
            comboZone.addItem(a);
          model44.addRow(new Object[]{rs1.getString("id_zi")});
        }
         comboZone.setSelectedIndex(-1);
        table();
      CREER.setVisible(false);
      
      
      
       
    }
  
   
 public void table() throws SQLException {
       // String t[] = {"id","code_produit","reference","deseignation","rangement","fournisseur","remise","prix","stock"};
    //rs = db.exécutionQuery("select id_lot , cod_lot,lib_lot, sup_lot, state_lot from lot");
    if(creer==1)
        CREER.setVisible(true);
    else
        CREER.setVisible(false);
    if(comboZone.getSelectedItem()==null){
     rs = db.exécutionQuery("select * from lot left join investisseur on investisseur.id_invst =lot.id_invst LEFT join zone_ind on zone_ind.id_zi = lot.id_zi ");
}else{
 rs = db.exécutionQuery("select * from lot left join investisseur on investisseur.id_invst =lot.id_invst LEFT join zone_ind on zone_ind.id_zi = lot.id_zi where zone_ind.lib_zi='"+comboZone.getSelectedItem()+"'");       
      

    }
         model=new DefaultTableModel();
    model1=new DefaultTableModel();
 
    model.addColumn("code lot");
model.addColumn("nom lot");
model.addColumn("state lot");
model.addColumn("superficiel lot");

model.addColumn("situation physique");
model.addColumn("pris vent");
model.addColumn("type lot");
model.addColumn("nom zone");
//model.addColumn("date construire");
model.addColumn("date attribution");
model.addColumn("nom invst");

model.addColumn("id");
model.addColumn("obs");
       // x = new String[rs.];
   while(rs.next()){
model.addRow(new Object[]{rs.getString("cod_lot"),rs.getString("lib_lot"),
    rs.getString("state_lot"),rs.getString("sup_lot"),rs.getString("situation_physique"),
    rs.getString("pris_vent"),rs.getString("type_lot"),rs.getString("lib_zi"), 
    rs.getDate("date_A"),rs.getString("nom_invst"),rs.getString("id_lot"),rs.getString("observation")});
//model1.addRow(new Object[]{rs.getString("id_lot"),rs.getString("observation")});
}
 //   x = new String[rs.;
       tbl_prod.setModel(model);
 //  TableFilterHeader filterHeader = new TableFilterHeader(tbl_prod, AutoChoices.ENABLED);
      // tbl_prod.setModel(new ResultSetTableModel(rs));
        
        //  TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl_prod.getModel());
          //       tbl_prod.setRowSorter(sorter);

              // List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
             //  sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
              //  sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
              // sorter.setSortKeys(sortKeys);
              
              tbl_prod.getColumnModel().getColumn(10).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(10).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(10).setWidth(0);
   
           tbl_prod.getColumnModel().getColumn(11).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(11).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(11).setWidth(0);
   
   // tbl_prod.getColumnModel().getColumn(12).setMinWidth(0);
  // tbl_prod.getColumnModel().getColumn(12).setMaxWidth(0);
  // tbl_prod.getColumnModel().getColumn(12).setWidth(0);   
              
              
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        pris = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        typeComb = new javax.swing.JComboBox<>();
        txtref1 = new javax.swing.JTextField();
        txtran1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        CREER = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        INVST = new javax.swing.JTextField();
        situa = new javax.swing.JTextField();
        comboINVST = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        date_A = new org.jdesktop.swingx.JXDatePicker();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        ZONE = new javax.swing.JTextField();
        comboZone = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 500));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Code_Lot :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 10, 80, 27);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Nom_Lot : ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 50, 100, 27);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("Surface_Lot :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 100, 100, 27);
        jPanel2.add(txtdes);
        txtdes.setBounds(120, 100, 100, 30);
        jPanel2.add(pris);
        pris.setBounds(120, 190, 100, 30);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("Prix_vente");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 190, 100, 30);
        jPanel2.add(txtid);
        txtid.setBounds(120, 10, 100, 30);

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Nom investisseur :");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(390, 180, 100, 27);

        typeComb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cession", "Concession" }));
        typeComb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCombActionPerformed(evt);
            }
        });
        jPanel2.add(typeComb);
        typeComb.setBounds(490, 80, 100, 30);
        jPanel2.add(txtref1);
        txtref1.setBounds(120, 50, 100, 30);

        txtran1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtran1MouseClicked(evt);
            }
        });
        jPanel2.add(txtran1);
        txtran1.setBounds(120, 140, 100, 30);

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText("Nature Juridique:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 140, 100, 27);

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("Situation_physique :");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(0, 250, 100, 30);

        obs.setColumns(20);
        obs.setRows(5);
        jScrollPane2.setViewportView(obs);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(110, 320, 190, 80);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Observation :");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 320, 100, 27);

        CREER.setText("Créer");
        CREER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREERActionPerformed(evt);
            }
        });
        jPanel2.add(CREER);
        CREER.setBounds(630, 80, 80, 30);

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText("Type :");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(390, 80, 60, 27);
        jPanel2.add(INVST);
        INVST.setBounds(490, 180, 100, 30);
        jPanel2.add(situa);
        situa.setBounds(120, 250, 100, 30);

        jPanel2.add(comboINVST);
        comboINVST.setBounds(490, 180, 120, 30);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("Date_Attribution:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(390, 10, 90, 27);

        date_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_AActionPerformed(evt);
            }
        });
        jPanel2.add(date_A);
        date_A.setBounds(490, 10, 190, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/fff.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(590, 80, 30, 30);

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

        jButton5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/actualiser .png"))); // NOI18N
        jButton5.setText("actualiser");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        jButton3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/modifier.png"))); // NOI18N
        jButton3.setText("modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/ajouter.png"))); // NOI18N
        jButton2.setText("ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText("nom zone");

        jButton6.setText("Filtrer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("LOTS");

        jButton8.setText("Afficher tout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(115, 115, 115)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(36, 36, 36)
                .addComponent(jButton8)
                .addGap(37, 37, 37)
                .addComponent(ZONE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(470, 470, 470))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ZONE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)
                        .addComponent(jButton8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_prodMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseDragged
 
     System.out.println("EE : "+EE);
     
     String gg= "0";
      System.out.println("EE : "+gg);
      new String(gg).equals(EE);
     if(new String(gg).equals(EE)){
     Cession DD = null;
         try {
             DD = new Cession();
         } catch (SQLException ex) {
             Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
         }
     DD.setVisible(true);
    
 } else{
       
        Consession TT = null;
         try {
             TT = new Consession();
         } catch (SQLException ex) {
             Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
         }
     TT.setVisible(true); 
  
         
         
     }        // TODO add your handling code here:*/
    }//GEN-LAST:event_tbl_prodMouseDragged

    private void tbl_prodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_prodFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodFocusGained

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked

        noEnable();

        txtid.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0)));
        txtref1.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 1)));
        
      //  name= type.getText();
        txtdes.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 3)));
        txtran1.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2)));
        
        situa.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 4)));
        pris.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 5)));
        String ff;
      ff=(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 6)));
      
      ZONE.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(),7)));
     INVST.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 9)));
      comboINVST.setSelectedItem(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 9)));
      // date_C.setDate((Date) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 8));
      date_A.setDate((Date) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 8));
           obs.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 11)));
      if(ff.equals("Concession"))
      typeComb.setSelectedItem("Concession");
      else
          typeComb.setSelectedItem("Cession");
      
     //   EE=type.getText();
        //txtran1.setEnabled(false);     
     id= String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 10));
        // TODO add your handling code here:
        ajout =0;
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void tbl_prodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_prodKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodKeyPressed

    private void tbl_prodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_prodKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         actualiser();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
rs = db.exécutionUpdate("delete from  lot where id_lot ='"+id+"'");
 try {
            table();//afficher et actualiser le tableau
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
            actualiser(); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//rs = db.exécutionUpdate("update  lot set cod_lot='" +txtid.getText()+"',lib_lot= '"+txtref.getText()+"',sup_lot= '"+txtdes.getText()+"',state_lot= '"+txtran.getText()+"'where id_invst='"+id+"'");
 if(ajout==0){
    ajout=1;
    // actualiser();
    Enable();
    
    
    ZONE.setVisible(false);
    comboZone.setVisible(true);
     INVST.setVisible(false);
    comboINVST.setVisible(true);
     
      try {
     rs1 = db.exécutionQuery("SELECT lib_zi ,id_zi FROM zone_ind ");
     rs2 = db.exécutionQuery("SELECT * from investisseur");
String a,b;
comboZone.removeAllItems();
comboINVST.removeAllItems();
        while (rs1.next()) {
            a = rs1.getString("lib_zi");
            comboZone.addItem(a);
          model44.addRow(new Object[]{rs1.getString("id_zi")});
        }
         while (rs2.next()) {
            b = rs2.getString("nom_invst");
            comboINVST.addItem(b);
          model55.addRow(new Object[]{rs2.getString("id_invst")});
        }
         // ff=(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 6)));
          String ad;
          ad =(String.valueOf(model.getValueAt(tbl_prod.getSelectedRow(), 10)));
          comboINVST.getSelectedIndex();
        if(ad.equals("null")){
                System.out.println("");
                comboINVST.setSelectedIndex(-1);
            }
        else{
        comboINVST.setSelectedItem(ad);
        }
        
          
    } catch (SQLException ex) {
        Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
}else{
         ZONE.setVisible(true);
  //  comboZone.setVisible(false);
     INVST.setVisible(true);
    comboINVST.setVisible(false);
       
            ajout=0;
            noEnable();
            id_zi= String.valueOf(model44.getValueAt(comboZone.getSelectedIndex(), 0));
            if(comboINVST.getSelectedIndex()==-1){
                System.out.println("");
            }
                     id_invst= String.valueOf(model55.getValueAt(comboINVST.getSelectedIndex(), 0));
        rs = db.exécutionUpdate("update  lot set cod_lot='" +txtid.getText()+"',lib_lot= '"+txtref1.getText()+"',sup_lot= '"+txtdes.getText()+"'"
                + ",state_lot= '"+txtran1.getText()+"',type_lot= '"+typeComb.getSelectedItem()+"',situation_physique= '"+situa.getText()+"',pris_vent= '"+pris.getText()+"',id_zi= '"+id_zi+"',id_invst= '"+id_invst+"'where id_lot='"+id+"'");
    
if(date_A.getDate()!=null){
    Date date = date_A.getDate();

        String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
    rs = db.exécutionUpdate("update  lot set date_A= '"+newstring+"'where id_lot='"+id+"'");
    
}else{
rs = db.exécutionUpdate("update  lot set date_A= "+null+"where id_lot='"+id+"'");

}
 
        try {
            table();//afficher et actualiser le tableau
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
            actualiser();  }    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       if(ajout==0){
    ajout=1;
    actualiser();
    Enable();
    ZONE.setVisible(false);
    //comboZone.setVisible(true);
     INVST.setVisible(false);
    comboINVST.setVisible(true);
    try {
   //  rs1 = db.exécutionQuery("SELECT lib_zi ,id_zi FROM zone_ind ");
     rs2 = db.exécutionQuery("SELECT * from investisseur");
     
String a,b;
        
        // comboZone.setSelectedIndex(-1);
         while (rs2.next()) {
            b = rs2.getString("nom_invst");
            comboINVST.addItem(b);
          model55.addRow(new Object[]{rs2.getString("id_invst")});
        }
         
        comboINVST.setSelectedIndex(-1);
          
    } catch (SQLException ex) {
        Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
}else{
        ZONE.setVisible(true);
    //comboZone.setVisible(false);
     INVST.setVisible(true);
    comboINVST.setVisible(false);
       
            ajout=0;
             
             
            noEnable();
             
        String  xx =(String) typeComb.getSelectedItem();
        // rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,state_lot,pris_vent,type_lot,situation_physique)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
       // + ",'"+txtran1.getText()+"','"+pris.getText()+"','"+xx+"','"+situa.getText()+"')");
       rs = db.exécutionQuery("select id_lot from lot where lib_lot='"+txtref1.getText()+"'");
           try {
               if(rs.next()){
                   JOptionPane.showMessageDialog(this, "element existe déja");
               }else{
                   
                   
               
              
                   if(comboZone.getSelectedItem()!=null)
                    id_zi= String.valueOf(model44.getValueAt(comboZone.getSelectedIndex(), 0));
                   else id_zi = null;
                     if(comboINVST.getSelectedItem()!=null)
                     id_invst= String.valueOf(model55.getValueAt(comboINVST.getSelectedIndex(), 0));
                      else id_invst = "";
                    Date date = date_A.getDate() ;
                        // Date date2 = date_C.getDate() ;
                        int zz= -1;
                 
                         // zz= (int) (model44.getValueAt(comboZone.getSelectedIndex(), 0));
                    // if((date_C.getDate()==null)&&(date_A.getDate()==null)){
                       //   if(id_invst=="")
   // rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_C,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                    //       + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"',"+null+","+null+",'"+txtran1.getText()+"',"+null+")");        
                 //  else
          //      rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                //           + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"',"+null+","+null+",'"+txtran1.getText()+"','"+id_invst+"')");                
                   //  }
                if(date_A.getDate()!=null){
                      String  newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
                       
      //  rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_C,date_A,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
        //                   + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"','"+newstring+","+null+",'"+id_invst+"')");               
               
                   if(id_invst=="")
    rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                           + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"','"+newstring+"','"+txtran1.getText()+"',"+null+")");        
                   else
                rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                           + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"','"+newstring+"','"+txtran1.getText()+"','"+id_invst+"')");  
                  }
                  
                     else{
                         if(id_invst=="")
    rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                           + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"','"+null+"','"+txtran1.getText()+"',"+null+")");        
                   else
                rs = db.exécutionUpdate("INSERT INTO lot (cod_lot,lib_lot,sup_lot,pris_vent,type_lot,situation_physique,observation,id_zi,date_A,state_lot,id_invst)VALUES ('"+txtid.getText()+"','"+txtref1.getText()+"','"+txtdes.getText()+"'"
                           + ",'"+pris.getText()+"','"+xx+"','"+situa.getText()+"','"+obs.getText()+"','"+id_zi+"','"+null+"','"+txtran1.getText()+"','"+id_invst+"')");  
                       
                       
                   
                     } 
                     
                      
                     
                     
                     try {
                       creer=1;
                       table();
                      
                   } catch (SQLException ex) {
                       Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   actualiser(); }
           } catch (SQLException ex) {
               Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
           }
 }           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtran1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtran1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtran1MouseClicked

    private void CREERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREERActionPerformed
String  xx =(String) typeComb.getSelectedItem();
creer = 0;
CREER.setVisible(false);
        if(xx.equals("Concession") )    {
        
        Consession s = null;
    try {
        s = new Consession();
    } catch (SQLException ex) {
        Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
        s.setVisible(true);
        }
        
        else{
    try {
        Cession s =new Cession();
        s.setVisible(true);                       
     } catch (SQLException ex) {
        Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        }
    }//GEN-LAST:event_CREERActionPerformed

    private void typeCombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeCombActionPerformed

    private void date_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_AActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     try {
          id= null;
            actualiser();
         table();        // TODO add your handling code here:
     } catch (SQLException ex) {
         Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
if(id==null){
   JOptionPane.showMessageDialog(this, "selectionner une ligne dans le tableau svp");}else{
        String  xx =(String) typeComb.getSelectedItem();
creer = 0;
CREER.setVisible(false);
        if(xx.equals("Concession") )    {
        
        Consession s = null;
    try {
        s = new Consession();
    } catch (SQLException ex) {
        Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
        s.setVisible(true);
        }
        
        else{
    try {
        Cession s =new Cession();
        s.setVisible(true);                       
     } catch (SQLException ex) {
        Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        }        // TODO add your handling code here:}
}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
             id= null;
            actualiser();
            comboZone.setSelectedIndex(-1);
            table();// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed
void Enable(){
    
    txtid.setEnabled(true);
            
      txtref1.setEnabled(true);
        txtdes.setEnabled(true);
        txtref1.setEnabled(true);
        txtran1.setEnabled(true);
        pris.setEnabled(true);
                situa.setEnabled(true);
     typeComb.setEnabled(true);
     obs.setEnabled(true);
     //.setEnabled(true);
     date_A.setEnabled(true);
}
void noEnable(){
    
   txtid.setEnabled(false);
            
      txtref1.setEnabled(false);
        txtdes.setEnabled(false);
        txtref1.setEnabled(false);
        txtran1.setEnabled(false);
        pris.setEnabled(false);
                situa.setEnabled(false); 
    typeComb.setEnabled(false);
     obs.setEnabled(false);
      //.setEnabled(false);
     date_A.setEnabled(false);
     
}
    void    actualiser(){
                txtid.setText("");
            
      txtref1.setText("");
        txtdes.setText("");
        txtref1.setText("");
        txtran1.setText("");
        
        pris.setText("");
                situa.setText("");
                obs.setText("");
               // date_C.setDate(null);
date_A.setDate(null);
ZONE.setText("");
INVST.setText("");
              
           // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Lot().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Lot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CREER;
    private javax.swing.JTextField INVST;
    private javax.swing.JTextField ZONE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboINVST;
    private javax.swing.JComboBox<String> comboZone;
    private org.jdesktop.swingx.JXDatePicker date_A;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea obs;
    private javax.swing.JTextField pris;
    private javax.swing.JTextField situa;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtran1;
    private javax.swing.JTextField txtref1;
    private javax.swing.JComboBox<String> typeComb;
    // End of variables declaration//GEN-END:variables

     
}
