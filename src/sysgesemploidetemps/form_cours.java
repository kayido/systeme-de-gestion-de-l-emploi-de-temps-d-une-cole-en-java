/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sysgesemploidetemps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kaido
 */
public class form_cours extends javax.swing.JFrame {

    
    cours tmp ;
    public form_cours(classe c) {
        initComponents();
        try {
            cours.show(jTable1,c.getId());
        } catch (SQLException ex) {
            Logger.getLogger(form_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
        classe_c.setText(c.getNom());
        String []jours = {"lundi","mardi","mercredi","jeudi","vendredi","samedi"};
        for(int i =0;i<6;i++)
            combo_jours.addItem(jours[i]);
        
        try {
            ArrayList tab = enseignant.liste();
            for(int i =0;i<tab.size();i++)
                combo_en.addItem((String) tab.get(i));
        
        
        } catch (SQLException ex) {
            Logger.getLogger(form_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ArrayList tab2 = matiere.liste();
            for(int i =0;i<tab2.size();i++)
                combo_m.addItem((String) tab2.get(i));
        } catch (SQLException ex) {
            Logger.getLogger(form_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    public boolean valid(int a){
        if(a<8 || a>18){
            return true;
        }else{
            return false;
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        classe_c = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_m = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        combo_en = new javax.swing.JComboBox<>();
        combo_jours = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        debut = new javax.swing.JSpinner();
        fin = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "classe", "matiere", "professeur", "jour", "debut", "fin"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("classe");

        jLabel2.setText("matiere");

        jLabel3.setText("professeur");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("programmer emploi de temps");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel4.setText("jour");

        classe_c.setBackground(new java.awt.Color(51, 51, 51));
        classe_c.setForeground(new java.awt.Color(255, 255, 255));
        classe_c.setEnabled(false);

        jButton4.setText("rafraichir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("sauvegarder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("heure debut");

        jLabel7.setText("heure fin");

        combo_m.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jButton2.setText("visualisez emploi de temps");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combo_en.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        combo_jours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jButton3.setText("supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(classe_c))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(6, 6, 6)))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combo_jours, 0, 181, Short.MAX_VALUE)
                                        .addComponent(debut)
                                        .addComponent(fin)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combo_en, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(combo_m, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(40, 40, 40)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(classe_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(combo_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(combo_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(combo_jours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cl = classe_c.getText();
        String ens = (String) combo_en.getSelectedItem();
        String mat = (String) combo_m.getSelectedItem();
        String jour = (String) combo_jours.getSelectedItem();
        int h_debut = (int) debut.getValue();
        int h_fin = (int) fin.getValue();
        int id_m = matiere.recupId(mat);
        int id_e = enseignant.recupId(ens);
        int id_c = classe.recupId(cl);
        Time t1= new Time(h_debut,0,0);
        Time t2= new Time(h_fin,00,00);
        cours c = new cours(id_c,id_e,id_m,jour,t1,t2);
        classe cla = new classe(id_c,"",0);
        enseignant e = new enseignant(id_e,"","","");
        boolean isfree = cla.isfree(jour,t1,t2) ;
        System.out.println(isfree);
        if( (t1.getHours()>t2.getHours())){
            JOptionPane.showMessageDialog(rootPane,"les heures entrées sont invalides","Attention",JOptionPane.WARNING_MESSAGE);            
        }else{
            if(valid(t1.getHours()) && valid(t1.getHours())){
                JOptionPane.showMessageDialog(rootPane,"les heures entrées sont invalides","Attention",JOptionPane.WARNING_MESSAGE);            
            }else{
                if(e.isdispo(id_e,jour, t1, t2)){
                    if( e.istake( jour, t1, t2) && isfree){
                        if(c.save()){
                            JOptionPane.showMessageDialog(rootPane,"Informations enregistré avec succès","succès",JOptionPane.INFORMATION_MESSAGE);            
                        }else{
                            JOptionPane.showMessageDialog(rootPane,"UNE ERREUR EST SURVENUE","erreur",JOptionPane.ERROR_MESSAGE);            
                        }
                    }else{
                            JOptionPane.showMessageDialog(rootPane,"l enseignant est deja programmé dans une autre salle a cet heure","Attention",JOptionPane.WARNING_MESSAGE);            
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane,"enseignant non disponible","erreur",JOptionPane.ERROR_MESSAGE);            
                }
            }    
        }
        
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cl = classe_c.getText();
        String ens = (String) combo_en.getSelectedItem();
        String mat = (String) combo_m.getSelectedItem();
        String jour = (String) combo_jours.getSelectedItem();
        int h_debut = (int) debut.getValue();
        int h_fin = (int) fin.getValue();
        int id_m = matiere.recupId(mat);
        int id_e = enseignant.recupId(ens);
        int id_c = classe.recupId(cl);
        Time t1= new Time(h_debut,0,0);
        Time t2= new Time(h_fin,00,00);

        cours c = new cours(id_c,id_e,id_m,jour,t1,t2);
        enseignant e = new enseignant(id_e,"","","");
       
        if(c.delete()){
            JOptionPane.showMessageDialog(rootPane,"cours deprogrammé","reussi",JOptionPane.INFORMATION_MESSAGE);            
        }else{
            JOptionPane.showMessageDialog(rootPane,"UNE ERREUR EST SURVENUE","erreur",JOptionPane.ERROR_MESSAGE);            
        }

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String cl = classe_c.getText();
        String ens = (String) combo_en.getSelectedItem();
        String mat = (String) combo_m.getSelectedItem();
        String jour = (String) combo_jours.getSelectedItem();
        int h_debut = (int) debut.getValue();
        int h_fin = (int) fin.getValue();
        int id_m = matiere.recupId(mat);
        int id_e = enseignant.recupId(ens);
        int id_c = classe.recupId(cl);
        Time t1= new Time(h_debut,0,0);
        Time t2= new Time(h_fin,00,00);

        cours c = new cours(id_c,id_e,id_m,jour,t1,t2);
        enseignant e = new enseignant(id_e,"","","");
        if( (t1.getHours()>t2.getHours())){
            JOptionPane.showMessageDialog(rootPane,"les heures entrées sont invalides","Attention",JOptionPane.WARNING_MESSAGE);            
        }else{
            if(valid(t1.getHours()) && valid(t1.getHours())){
                JOptionPane.showMessageDialog(rootPane,"les heures entrées sont invalides","Attention",JOptionPane.WARNING_MESSAGE);            
            }else{
                if(e.isdispo(id_e,jour, t1, t2)){
                    if(c.update(tmp)){
                        JOptionPane.showMessageDialog(rootPane,"cours mis a jour","reussi",JOptionPane.INFORMATION_MESSAGE);            
                    }else{
                        JOptionPane.showMessageDialog(rootPane,"UNE ERREUR EST SURVENUE","erreur",JOptionPane.ERROR_MESSAGE);            
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane,"enseignant non disponible","erreur",JOptionPane.ERROR_MESSAGE);            
                }
            }    
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        int rIndex = jTable1.getSelectedRow();
        
        //display data
        classe_c.setText(model.getValueAt(rIndex, 0).toString());
        combo_en.setSelectedItem(model.getValueAt(rIndex, 1).toString());
        combo_m.setSelectedItem(model.getValueAt(rIndex, 2).toString());
        combo_jours.setSelectedItem(model.getValueAt(rIndex, 3).toString());
        Time a =  (Time) model.getValueAt(rIndex, 4);
        Time b = (Time) model.getValueAt(rIndex, 5);
        debut.setValue(a.getHours());
        fin.setValue(b.getHours());
        tmp = new cours(
                        classe.recupId(model.getValueAt(rIndex, 0).toString()),
                        enseignant.recupId(model.getValueAt(rIndex, 1).toString()),
                        matiere.recupId(model.getValueAt(rIndex, 2).toString()),
                        model.getValueAt(rIndex, 3).toString(),
                        a,b
        );
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int id;
        String cl = classe_c.getText();
        id = classe.recupId(cl);
        try {
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"classe","matiere","enseignant","jour","debut","fin"}));
            
            cours.show(jTable1,id);
        } catch (SQLException ex) {
            Logger.getLogger(form_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        emploi_temps et = new emploi_temps(classe.recupId(classe_c.getText()));
        et.setVisible(true);
        et.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(classe c) {
                new form_cours(c).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classe_c;
    private javax.swing.JComboBox<String> combo_en;
    private javax.swing.JComboBox<String> combo_jours;
    private javax.swing.JComboBox<String> combo_m;
    private javax.swing.JSpinner debut;
    private javax.swing.JSpinner fin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
