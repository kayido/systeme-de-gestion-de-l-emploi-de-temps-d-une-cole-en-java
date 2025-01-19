package sysgesemploidetemps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
public class disponibilite {
    private int id;
    private int id_e;
    private String jour;
    private Time debut;
    private Time fin;
    
    connectBD bd = new connectBD();
    public disponibilite(int id,int id_e,String jour,Time debut,Time fin){
        this.id = id;
        this.id_e = id_e;
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setId_e(int id_e){
        this.id_e = id_e;
    }
    public void setJour(String jour){
        this.jour = jour;
    }
    public void setDebut(Time debut){
        this.debut = debut;
    }
    
    public void setFin(Time fin){
        this.fin = fin;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getId_e(){
        return this.id_e;
    }
    
    public String getJour(){
        return this.jour;
    }
    
    public Time getDebut(){
        return this.debut;
    }
    
    public Time getFin(){
        return this.fin;
    }
    
    public boolean save(){
        PreparedStatement ps;
        String addQuery = "INSERT INTO `disponibilte`(`jour`, `heure_d`, `heure_fin`, `id_e`) VALUES (?,?,?,?)";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setString(1, this.jour);
            ps.setTime(2, this.debut);
            ps.setTime(3, this.fin);
            ps.setInt(4, this.id_e);
            if(ps.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(disponibilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
    
    public boolean update(){
        PreparedStatement ps;
        String editQuery = "UPDATE `disponibilte` SET `jour`=?,`heure_d`=?,`heure_fin`=? WHERE `id_d`=? ";
        
        try {
            ps = bd.createConnection().prepareStatement(editQuery);
            ps.setString(1, this.jour);
            ps.setTime(2, this.debut);
            ps.setTime(3, this.fin);
            ps.setInt(4, this.id);
            if(ps.executeUpdate()>0){
                return true;
            }else{
                System.out.println("upload failed");
                return false;
            }
            } catch (SQLException ex) {
                System.out.println("upload failed");
                Logger.getLogger(disponibilite.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        return false;
    }
    
    public boolean delele(){
        PreparedStatement ps;
        String deleteQuery = "DELETE FROM `disponibilte` WHERE id_d =?";
        try {
            ps = bd.createConnection().prepareStatement(deleteQuery);
            ps.setInt(1, this.id);
            if(ps.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
            } catch (SQLException ex) {
                Logger.getLogger(disponibilite.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
    
    public static void show(JTable table) throws SQLException{
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM disponibilte";
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        Object[] row;
        
        while(rs.next()){
            row = new Object[5];
            row[0] = rs.getInt(1);
            row[2] = rs.getString(2);
            row[3] = rs.getTime(3);
            row[4] = rs.getTime(4);
            row[1] = enseignant.recupNom(rs.getInt(5));
            tableModel.addRow(row);
        }
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
