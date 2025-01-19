package sysgesemploidetemps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class matiere {
    private int id;
    private String nom;
    
    
    connectBD bd = new connectBD();
    public matiere(int id,String nom){
        this.id = id;
        this.nom = nom;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public boolean save(){
        PreparedStatement ps;
        String addQuery = "INSERT INTO `matiere` (`nom_m`) VALUES(?)";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setString(1, this.nom);
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(matiere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
    
    public boolean update(){
        PreparedStatement st;
        String editQuery = "UPDATE `matiere` SET `nom_m`=? WHERE `id_m`=?";
              
        try {
            st = bd.createConnection().prepareStatement(editQuery);
            st.setString(1, this.nom);
          
            st.setInt(2, this.id);
            return (st.executeUpdate()>0);
            } catch (SQLException ex) {
                System.out.println("upload failed");
                Logger.getLogger(matiere.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    
    }
    public boolean delete(){
        PreparedStatement st;
        String editQuery = "DELETE FROM `matiere` WHERE `id_m`=?";
              
        try {
            st = bd.createConnection().prepareStatement(editQuery);
            st.setInt(1, this.id);
            return (st.executeUpdate()>0);
            } catch (SQLException ex) {
                Logger.getLogger(classe.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }
    public static void show(JTable table) throws SQLException{
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM matiere";
        
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
        
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
        Object[] row;
        
        while(rs.next()){
            row = new Object[2];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            tableModel.addRow(row);
        }
    }
    
    public static int recupId(String nom){
    
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM matiere Where nom_m =?";
      
        try {
            st = bd.createConnection().prepareStatement(selectQuery);
            st.setString(1, nom);
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(matiere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static String recupNom(int id){
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM matiere Where id_m= ?";
      
        try {
            st = bd.createConnection().prepareStatement(selectQuery);
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(matiere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "none";
    }
    
    public static ArrayList liste() throws SQLException{
        ArrayList<String> tab = new ArrayList();
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM matiere";
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
       
        
        while(rs.next()){
            tab.add(rs.getString(2));
        }
        return tab;
    }
}
