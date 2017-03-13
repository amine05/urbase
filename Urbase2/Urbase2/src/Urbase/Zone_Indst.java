/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Urbase;

import DB.ResultSetTableModel;
import DB.db_connection;
import static java.lang.String.format;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.text.MessageFormat.format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static mondrian.olap.fun.vba.Vba.date;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import static mondrian.olap.fun.vba.Vba.date;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.CustomChoiceDecorator;
import net.coderazzi.filters.gui.TableFilterHeader;

public class Zone_Indst extends javax.swing.JFrame {

    ResultSet rs;
    db_connection db;
    DefaultTableModel model;
    DefaultTableModel model1;
     DefaultTableModel model33;
   static public String id;
    static public int kk = 1;
    int ajout = 0;
    String id_w;
     TableFilterHeader filterHeader ;
// RowSorter<TableModel> sorter ;
    public Zone_Indst() throws SQLException {
        initComponents();
        db = new db_connection();
        txtdet.setEnabled(false);
        //rr.setFormats("dd-MM-yyyy HH:mm:ss");
        rr.setFormats("dd-MM-yyyy");
        noEnable();
      filterHeader = new TableFilterHeader(tbl_prod, AutoChoices.ENABLED);
      //  filterHeader.setPosition(Position.TOP);
        // TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl_prod.getModel());
        //tbl_prod.setRowSorter(sorter);
         model33 = new DefaultTableModel();
        model33.addColumn("id_w");
        
        model = new DefaultTableModel(){
     
     public Class getColumnClass(int c) {
         return getValueAt(0, c).getClass();
     }
};
      //  RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

    
        table();
       
        comboWilaya();
        //  RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
 //tbl_prod.setRowSorter(sorter);
  //  tbl_prod.setRowSorter(sorter);
    
      //  tbl_prod.setAutoCreateRowSorter(true);
        // filterHeader = new TableFilterHeader(tbl_prod, AutoChoices.ENABLED);
        nbrLot1.setEnabled(false);
        txtdet.setEnabled(false);
        //.setVisible(false);
      
    
    }
    void comboWilaya(){
    String name_Zone;
    ResultSet rs1;
          comboZone.removeAllItems();
          // comboZone.setSelectedIndex(-1);
            rs1 = db.exécutionQuery("SELECT id_w, lib_w FROM wilya");

            try {
                while (rs1.next()) {
                    name_Zone = rs1.getString("lib_w");
                    comboZone.addItem(name_Zone);
                    model33.addRow(new Object[]{rs1.getString("id_w")});
                }
                 comboZone.setSelectedIndex(-1);

            } catch (SQLException ex) {
                Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    }
    void Enable(){
    
     txtid.setEnabled(true);

        txtref.setEnabled(true);
        //    n_pl.setText("");
     //   txtdet.setEnabled(true);
      //  nbrLot1.setEnabled(true);
                
            obs.setEnabled(true);
                rr.setEnabled(true);
                      sup_c.setEnabled(true);
                    sup_vs.setEnabled(true);
              nbr_lots.setEnabled(true);
                 nbr_lotc.setEnabled(true);
                  textZone.setEnabled(true);
    
    }
    
    
    void noEnable(){
      //  textZone.setVisible(false);
          //  comboZone.setVisible(false);
     txtid.setEnabled(false);

        txtref.setEnabled(false);
        //    n_pl.setText("");
        txtdet.setEnabled(false);
        nbrLot1.setEnabled(false);
                
            obs.setEnabled(false);
                rr.setEnabled(false);
                      sup_c.setEnabled(false);
                    sup_vs.setEnabled(false);
              nbr_lots.setEnabled(false);
                 nbr_lotc.setEnabled(false);
                  textZone.setEnabled(false);
    
    
    
    }

    public int Control_nbrLot() {

        int a = Integer.parseInt(nbrLot1.getText());
        int b = Integer.parseInt(nbr_lotc.getText());
        int c = Integer.parseInt(nbr_lots.getText());

        if (a == (b + c)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void table() throws SQLException {
        // String t[] = {"id","code_produit","reference","deseignation","rangement","fournisseur","remise","prix","stock"};
        // rs = db.exécutionQuery("select zone_ind.id_zi,code_zi, lib_zi, sup_zi , date_Creation , nbr_lot,nbr_lotC,nbr_lotS,Sup_Cess,Sup_VS ,OBSERVATION ,n_pl from zone_ind,permis_loture where ((zone_ind.id_zi=permis_loture.id_zi)or(1=1))");
if(comboZone.getSelectedItem()==null){
        rs = db.exécutionQuery("select * from zone_ind left join wilya on wilya.id_w = zone_ind.id_w ");
}else{
    
     rs = db.exécutionQuery("select * from zone_ind left join wilya on wilya.id_w = zone_ind.id_w where wilya.lib_w='"+comboZone.getSelectedItem()+"' ");
}
        String name;

        model = new DefaultTableModel();
        //{
     
   //  public Class getColumnClass(int c) {
     //    return getValueAt(0, c).getClass();
   //  }
//};
     RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

  
        //  model1 = new DefaultTableModel();

        model.addColumn("code");
        model.addColumn("nom ");
        model.addColumn("date creation");
        model.addColumn("nombre lots");
        model.addColumn("superficier");

        model.addColumn("superficier_Cession");
        model.addColumn("superficier_Voire");
        model.addColumn("nbr_lot Concession");
        model.addColumn("Nbr_Lot Cession");
        model.addColumn("lib_w");
     
        model.addColumn("id");
        model.addColumn("OBSERVATION");
         
         
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("code_zi"), rs.getString("lib_zi"), rs.getDate("date_Creation"), rs.getInt("nbr_lot"),
                 rs.getDouble("sup_zi"), rs.getDouble("Sup_Cess"),
                 rs.getDouble("Sup_VS"), rs.getInt("nbr_lotC"), rs.getInt("nbr_lotS"), rs.getString("lib_w"),rs.getString("id_zi"),rs.getString("OBSERVATION")});
            
        } 
        
         
           // tbl_prod.setModel(model);
       //  if(!rs.next())
       //tbl_prod.setModel(new ResultSetTableModel(rs));
           
               tbl_prod.setModel(model);
             //  model.setRowCount(0);
             //  if(tbl_prod.getRowCount()!=0)
         //  tbl_prod.setRowSorter(sorter);
             tbl_prod.getColumnModel().getColumn(10).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(10).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(10).setWidth(0);
   
   tbl_prod.getColumnModel().getColumn(11).setMinWidth(0);
   tbl_prod.getColumnModel().getColumn(11).setMaxWidth(0);
   tbl_prod.getColumnModel().getColumn(11).setWidth(0);
        //RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

   // tbl_prod.setRowSorter(sorter);
     
          
          // }
    
           
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtref = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rr = new org.jdesktop.swingx.JXDatePicker();
        txtdet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sup_c = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        sup_vs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        nbr_lots = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nbr_lotc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nbrLot1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        textZone = new javax.swing.JTextField();
        comboZone = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 750));
        setSize(new java.awt.Dimension(300, 200));

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
        jLabel7.setText("Code_Zone");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 20, 80, 27);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Nom_Zone");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 60, 100, 27);
        jPanel2.add(txtid);
        txtid.setBounds(120, 20, 100, 30);
        jPanel2.add(txtref);
        txtref.setBounds(120, 60, 100, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("Date_Creation:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(400, 150, 80, 27);

        rr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rrActionPerformed(evt);
            }
        });
        jPanel2.add(rr);
        rr.setBounds(510, 150, 190, 30);
        jPanel2.add(txtdet);
        txtdet.setBounds(510, 100, 100, 30);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Superficie_TOT");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(400, 100, 100, 27);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Sup_cessible");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(400, 20, 100, 30);
        jPanel2.add(sup_c);
        sup_c.setBounds(510, 20, 100, 30);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("observation :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 260, 80, 27);
        jPanel2.add(sup_vs);
        sup_vs.setBounds(510, 60, 100, 30);

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Nbr_Lot Cession");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 150, 110, 27);
        jPanel2.add(nbr_lots);
        nbr_lots.setBounds(120, 100, 100, 30);

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText("Nbr_Lot Concession");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 100, 110, 27);
        jPanel2.add(nbr_lotc);
        nbr_lotc.setBounds(120, 150, 100, 30);

        obs.setColumns(20);
        obs.setRows(5);
        jScrollPane2.setViewportView(obs);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(120, 280, 166, 96);

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("Sup_VRD");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(400, 60, 100, 27);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText("Nombre_Lots");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 200, 100, 27);
        jPanel2.add(nbrLot1);
        nbrLot1.setBounds(120, 200, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/application-edit-icon.png"))); // NOI18N
        jButton1.setText("Permer du loture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(510, 220, 170, 40);

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

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText("Nom Wilaya :");

        textZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textZoneActionPerformed(evt);
            }
        });

        jButton6.setText("Afficher tout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Filtrer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("ZONE INDUSTRIELLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(152, 152, 152)
                        .addComponent(textZone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboZone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textZone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       actualiser();
        //n_pl.setText("");

        //txtran.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        rs = db.exécutionUpdate("delete from zone_ind where  id_zi='" + id + "' ");
        try {
            table();
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiser();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    if (ajout == 0) {
           // actualiser();
            Enable();
            textZone.setVisible(false);
            comboZone.setVisible(true);
            String name_Zone;
            ResultSet rs1;
            rs1 = db.exécutionQuery("SELECT id_w, lib_w FROM wilya");
 comboZone.removeAllItems();
            try {
                while (rs1.next()) {
                    name_Zone = rs1.getString("lib_w");
                    comboZone.addItem(name_Zone);
                    model33.addRow(new Object[]{rs1.getString("id_w")});
                }
                // textZone.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 9)));
                    comboZone.setSelectedItem(textZone.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
            }
            ajout = 1;
        } else {
ajout= 0;
 textZone.setVisible(true);
           // comboZone.setVisible(false);

       
 id_w = String.valueOf(model33.getValueAt(comboZone.getSelectedIndex(), 0));
 
 int a = ((Integer.parseInt(nbr_lots.getText())) + (Integer.parseInt(nbr_lotc.getText())));
nbrLot1.setText(Integer.toString(a));
double ee =Double.parseDouble(sup_c.getText())+Double.parseDouble(sup_vs.getText()) ;
txtdet.setText(String.valueOf(ee));
 
 if(rr.getDate()!=null){
      Date date = rr.getDate();

        String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
        rs = db.exécutionUpdate("update  zone_ind set code_zi='" + txtid.getText() + "'"
                + ",lib_zi= '" + txtref.getText() + "',nbr_lot= '" + nbrLot1.getText() + "',sup_zi= '"
                + txtdet.getText() + "',nbr_lotC= '" + nbr_lotc.getText() + "',nbr_lotS= '" + nbr_lots.getText()
                + "',Sup_Cess= '" + sup_c.getText() + "',Sup_VS= '" + sup_vs.getText() + "',OBSERVATION= '"
                + obs.getText() + "',date_Creation= '" + newstring + "',id_w= '" + id_w +"' where id_zi='" + id + "'");}
 else {
  rs = db.exécutionUpdate("update  zone_ind set code_zi='" + txtid.getText() + "'"
                + ",lib_zi= '" + txtref.getText() + "',nbr_lot= '" + nbrLot1.getText() + "',sup_zi= '"
                + txtdet.getText() + "',nbr_lotC= '" + nbr_lotc.getText() + "',nbr_lotS= '" + nbr_lots.getText()
                + "',Sup_Cess= '" + sup_c.getText() + "',Sup_VS= '" + sup_vs.getText() + "',OBSERVATION= '"
                + obs.getText() + "',date_Creation= " +null+",id_w= '" + id_w +"' where id_zi='" + id + "'");
 
 }

        try {
            table();//afficher et actualiser le tableau
        } catch (SQLException ex) {
            Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
        }
        noEnable();
       actualiser();
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (ajout == 0) {
            actualiser();
            Enable();
            //textZone.setVisible(false);
            //comboZone.setVisible(true);
            String name_Zone;
         /*   ResultSet rs1;
          comboZone.removeAllItems();
            rs1 = db.exécutionQuery("SELECT id_w, lib_w FROM wilya");

           try {
                while (rs1.next()) {
                    name_Zone = rs1.getString("lib_w");
                    comboZone.addItem(name_Zone);
                    model33.addRow(new Object[]{rs1.getString("id_w")});
                }

            } catch (SQLException ex) {
                Logger.getLogger(Permet_Lot.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            ajout = 1;
        } else {
            try {
                ajout = 0;
                textZone.setVisible(true);
                noEnable();
                
                rs = db.exécutionQuery("select id_zi from zone_ind where lib_zi='"+txtref.getText()+"'");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "element existe déja");
                    actualiser();
                }else{
                    Date date = rr.getDate();
//String date_s = " 2011-01-18 00:00:00.0";
// Object date = null;
String newstring = "";


//int cc =Integer.parseInt(newstring);
//String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
id_w = String.valueOf(model33.getValueAt(comboZone.getSelectedIndex(), 0));                 

int  a;
double ee;
//   ee= ((double.(sup_vs.getText())) + (Integer.parseInt(sup_vs.getText())));

a = ((Integer.parseInt(nbr_lots.getText())) + (Integer.parseInt(nbr_lotc.getText())));
nbrLot1.setText(Integer.toString(a));
ee =Double.parseDouble(sup_c.getText())+Double.parseDouble(sup_vs.getText()) ;
txtdet.setText(String.valueOf(ee));
if(rr.getDate() !=null){
 newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
rs = db.exécutionUpdate("INSERT INTO zone_ind (code_zi,lib_zi,nbr_lot,sup_zi,nbr_lotC,nbr_lotS,Sup_Cess,Sup_VS,OBSERVATION,date_Creation,id_w)VALUES ('" + txtid.getText() + "','" + txtref.getText() + "',"
        + "'" + nbrLot1.getText() + "','" + txtdet.getText() + "','" + nbr_lotc.getText() + "','" + nbr_lots.getText() + "','" + sup_c.getText() + "','" + sup_vs.getText() + "','" + obs.getText() + "','" + newstring +"','" + id_w + "')");
}else
    rs = db.exécutionUpdate("INSERT INTO zone_ind (code_zi,lib_zi,nbr_lot,sup_zi,nbr_lotC,nbr_lotS,Sup_Cess,Sup_VS,OBSERVATION,date_Creation,id_w)VALUES ('" + txtid.getText() + "','" + txtref.getText() + "',"
        + "'" + nbrLot1.getText() + "','" + txtdet.getText() + "','" + nbr_lotc.getText() + "','" + nbr_lots.getText() + "','" + sup_c.getText() + "','" + sup_vs.getText() + "','" + obs.getText() + "',"+ null+",'" + id_w + "')");

try {
    table();
} catch (SQLException ex) {
    Logger.getLogger(Invst.class.getName()).log(Level.SEVERE, null, ex);
}
actualiser();
 
            //.setVisible(false);
// } else {
//   JOptionPane.showMessageDialog(this, "le total du nombre du lots est faut");


                }
            } catch (SQLException ex) {
                Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    void actualiser() {
       txtid.setText("");

        txtref.setText("");
        //    n_pl.setText("");
        txtdet.setText("");
        nbrLot1.setText("");
                
            obs.setText("");
                rr.setDate(null);
                      sup_c.setText("");
                    sup_vs.setText("");
              nbr_lots.setText("");
                 nbr_lotc.setText("");
                  textZone.setText("");
        // TODO add your handling code here:
    }
    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
//RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

    //tbl_prod.setRowSorter(sorter);
        textZone.setVisible(true);
        txtid.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0)));

        txtref.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 1)));
        nbrLot1.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 3)));
        txtdet.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 4)));

        //sString c= (String) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2);
        Date date;

        //   rr.setFormats("dd-MM-yyyy HH:mm:ss");
        // DD.setDate((date)tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2));
        rr.setDate((Date) tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 2));
        //  System.out.println("Urbase.Zone_Indst.tbl_prodMouseClicked()"+DD.toString());
        sup_c.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 5)));
        sup_vs.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 6)));
        nbr_lots.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 7)));
        nbr_lotc.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 8)));
          
        textZone.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 9)));
        
        //   id = String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 10));
        obs.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 11)));
      id= String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 10));

        // txtid.setEnabled(false);           // TODO add your handling code here:

       // String xx;

       // xx = String.valueOf(model1.getValueAt(0, 0));

        
        ajout=0;
noEnable();
        // rs.getString("id_zi")
        //id= String.valueOf(model.getValueAt(t.getSelectedRow(), 0));
        //nbrLot.setVisible(false);
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void rrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rrActionPerformed

    private void tbl_prodMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseDragged

        //txtid.setText(String.valueOf(tbl_prod.getValueAt(tbl_prod.getSelectedRow(), 0)));
        //   if (kk == 1) {
         //   if (tbl_prod.getSelectedColumn() == 9) {
            //    Permet_Lot x = null;
            //    try {
             //       x = new Permet_Lot();
            //    } catch (SQLException ex) {
              //      Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
            //    }
             //   x.setVisible(true);
             //   kk++;
            //}
      //  }

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prodMouseDragged

    private void textZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textZoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(id==null){
   JOptionPane.showMessageDialog(this, "selectionner une ligne dans le tableau svp");
    
}else{
        Permet_Lot x = null;
        try {
            x = new Permet_Lot();
        } catch (SQLException ex) {
            Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
        }
x.setVisible(true);}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            id= null;
            actualiser();
            table();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
             id= null;
            comboZone.setSelectedIndex(-1);
            table();// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Zone_Indst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zone_Indst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zone_Indst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zone_Indst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Zone_Indst().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Zone_Indst.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboZone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nbrLot1;
    private javax.swing.JTextField nbr_lotc;
    private javax.swing.JTextField nbr_lots;
    private javax.swing.JTextArea obs;
    private org.jdesktop.swingx.JXDatePicker rr;
    private javax.swing.JTextField sup_c;
    private javax.swing.JTextField sup_vs;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField textZone;
    private javax.swing.JTextField txtdet;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtref;
    // End of variables declaration//GEN-END:variables
}
