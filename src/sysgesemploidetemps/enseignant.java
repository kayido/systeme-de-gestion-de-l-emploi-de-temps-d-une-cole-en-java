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

public class enseignant {
    private int id;
    private String nom;
    private String numero;
    private String adresse;
    
    connectBD bd = new connectBD();
    public enseignant(int id,String nom,String numero,String adresse){
        this.id = id;
        this.nom = nom;
        this.numero = numero;
        this.adresse = adresse;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getAdresse(){
        return this.adresse;
    }
    
    public boolean save(){
        PreparedStatement ps;
        String addQuery = "INSERT INTO `enseignant` (`nom_e`, `numero_tel`, `adresse`) VALUES(?,?,?)";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setString(1, this.nom);
            ps.setString(2, this.numero);
            ps.setString(3, this.adresse);
            if(ps.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
    
    public boolean update(){
        PreparedStatement st;
        String editQuery = "UPDATE `enseignant` SET `nom_e`=?,`numero_tel`=?,`adresse`=? WHERE `id_e`=?";
        
        try {
            st = bd.createConnection().prepareStatement(editQuery);
            st.setString(1, this.nom);
            st.setString(2, this.numero);
            st.setString(3, this.adresse);
            st.setInt(4, this.id);
            if(st.executeUpdate()>0){
                return true;
            }else{
                System.out.println("upload failed");
                return false;
            }
            } catch (SQLException ex) {
                System.out.println("upload failed");
                Logger.getLogger(enseignant.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        return false;
    }
     public boolean delete(){
        PreparedStatement st;
        String editQuery = "DELETE FROM `enseignant` WHERE `id_e`=?";
              
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
        String selectQuery = "SELECT * FROM enseignant";
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        Object[] row;
        
        while(rs.next()){
            row = new Object[4];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            tableModel.addRow(row);
        }
    }
    
    public static ArrayList liste() throws SQLException{
        ArrayList<String> tab = new ArrayList();
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM enseignant";
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
       
        
        while(rs.next()){
            tab.add(rs.getString(2));
        }
        return tab;
    }
    public static String recupNom(int id){
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM enseignant Where id_e= ?";
      
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
    public static int recupId(String nom){
    
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM enseignant Where nom_e =?";
      
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
    public ArrayList dispo(int id){
        ArrayList<String> t =new ArrayList();
        try {
            PreparedStatement ps;
            String query = "SELECT * FROM `disponibilte` WHERE `id_e` = ?";
            ResultSet rs;
            ps = bd.createConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                String tt = rs.getString(2)+"-"+ rs.getTime(3) +"-"+rs.getTime(4);
                t.add(tt);
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public  boolean isdispo(int id,String day,Time debut,Time fin){
        
        ArrayList<String> ld = dispo(id);
        int i;
        for(i=0;i<ld.size();i++){
            String tmp = ld.get(i);
            String [] tab = tmp.split("-");
            String jour = tab[0]; 
            Time t1 = Time.valueOf(tab[1]);
            Time t2 = Time.valueOf(tab[2]);
            if(jour.equals(day)){
                if((t1.before(debut)|| t1.equals(debut)) && (t2.after(fin)|| t2.equals(debut))){
                    return true;
                }
            }
        }
        return false;
    }
     public boolean istake(String day,Time debut,Time fin){
        try {
            PreparedStatement ps;
            String query = "SELECT * FROM `cours` ";
            ResultSet rs;
            ps = bd.createConnection().prepareStatement(query);
            //ps.setInt(1, this.id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Time t1 = rs.getTime(5);
                Time t2 = rs.getTime(6);
                if(day.equals(rs.getString(4))){
                    if((t1.before(debut)|| t1.equals(debut)) && (t2.after(fin)|| t2.equals(debut))){
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
     }
     /*public static void main(String [] args){
         
     }*/
    
}
