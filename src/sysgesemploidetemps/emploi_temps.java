/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sysgesemploidetemps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kaido
 */
public class emploi_temps extends javax.swing.JFrame {
    public int duree(Time t1, Time t2){
        int x1 = t1.getHours();
        int x2 = t2.getHours();
        
        return x2-x1;
    }
    public  ArrayList essai(JTable table, int id){
        ArrayList<cours> tab = new ArrayList();
        try {
            connectBD bd = new connectBD();
            
            PreparedStatement st;
            ResultSet rs;
            String selectQuery = "SELECT * FROM cours where id_c =?";
            
            st = bd.createConnection().prepareStatement(selectQuery);
            st.setInt(1, id);
            rs = st.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[6];
                cours c = new cours(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getTime(5),rs.getTime(6));
                int n ;
                int j =c.debut.getHours();
                n=  c.fin.getHours();
                int i;
                
                for(i=j;i<n;i++){
                    
                    c.debut = new Time(i,00,00);
                    c.fin = new Time(i+1,00,00);
                    cours nc = new cours(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),c.debut,c.fin);
                    tab.add(nc);
                }
                
                
                
            }    
            return tab;
        } catch (SQLException ex) {
            Logger.getLogger(emploi_temps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tab;
    }
    public void showe(JTable table,int id) throws SQLException{
        ArrayList<cours> rs = this.essai(table,id);
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
       
        Object[] row;
        ArrayList<Time> times = new ArrayList();
        int i =0;
        for (i=8;i<20;i++){
            Time t = new Time(i,00,00);
            times.add(t);
        }
        
        int j = 0;
        i = 0;
        
        while(j<11){
            row = new Object[7];
            row[0] = times.get(j)+"-"+times.get(j+1);
            i=0;
            while(i<rs.size()){
                cours c = rs.get(i);
                if(c.debut.equals(times.get(j))&&c.fin.equals(times.get(j+1))){
                    switch (c.jour) {
                        case "lundi":
                            row[1] = matiere.recupNom(c.id_m);
                            break;
                        case "mardi":
                            row[2] = matiere.recupNom(c.id_m);
                            break;
                        case "mercredi":
                            row[3] = matiere.recupNom(c.id_m);
                            break;
                        case "jeudi":
                            row[4] = matiere.recupNom(c.id_m);
                            break;
                        case "vendredi":
                            row[5] = matiere.recupNom(c.id_m);
                            break;
                        case "samedi":
                            row[6] = matiere.recupNom(c.id_m);
                            break;
                        default:
                            break;
                    }
                    
                }
                i++;
                
            }
            tableModel.addRow(row);
            j++;
            
        }
       
    }
    public emploi_temps(int id) {
        initComponents();
        
        try {
             ArrayList<cours> cour =  this.essai(jTable1,id);  
            this.showe(jTable1,id);
        } catch (SQLException ex) {
            Logger.getLogger(emploi_temps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "horaire", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(10);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(emploi_temps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emploi_temps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emploi_temps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emploi_temps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(int id) {
                new emploi_temps(id).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
