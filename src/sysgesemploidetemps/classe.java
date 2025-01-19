package sysgesemploidetemps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class classe {
    private int id;
    private String nom;
    private int effectif;
    
    connectBD bd = new connectBD();
    public classe(int id,String nom,int effectif){
        this.id = id;
        this.nom = nom;
        this.effectif = effectif;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setEffectif(int effectif){
        this.effectif = effectif;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public int getEffectif(){
        return this.effectif;
    }
    
    public boolean save(){
        PreparedStatement ps;
        String addQuery = "INSERT INTO `classe`(`nom`, `effectif`) VALUES(?,?)";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setString(1, this.nom);
            ps.setInt(2, this.effectif);
            
            if(ps.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
    
    public boolean update(){
        PreparedStatement st;
        String editQuery = "UPDATE `classe` SET `nom`=?,`effectif`=? WHERE `id_c`=?";
              
        try {
            st = bd.createConnection().prepareStatement(editQuery);
            st.setString(1, this.nom);
            st.setInt(2, this.effectif);
            st.setInt(3, this.id);
            return (st.executeUpdate()>0);
            } catch (SQLException ex) {
                System.out.println("upload failed");
                Logger.getLogger(classe.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    
    }
    public boolean delete(){
        PreparedStatement st;
        String editQuery = "DELETE FROM `classe` WHERE `id_c`=?";
              
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
        String selectQuery = "SELECT * FROM classe";
        
        st = bd.createConnection().prepareStatement(selectQuery);
        rs = st.executeQuery();
        
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
        Object[] row;
        
        while(rs.next()){
            row = new Object[3];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getInt(3);
            tableModel.addRow(row);
        }
    }
    public static String recupNom(int id){
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM classe Where id_c= ?";
      
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
        String selectQuery = "SELECT * FROM classe Where nom =?";
      
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
    public boolean isfree(String day,Time debut,Time fin){
        try {
            PreparedStatement ps;
            String query = "SELECT * FROM `cours` WHERE `id_c`=?";
            ResultSet rs;
            ps = bd.createConnection().prepareStatement(query);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Time t1 = rs.getTime(5);
                Time t2 = rs.getTime(6);
                System.out.println("-<"+rs.getString(4)+"-"+rs.getString(5)+"-"+rs.getString(6));
                if(day.equals(rs.getString(4))){
                    if((t1.before(debut)|| t1.equals(debut)) && (t2.after(fin)|| t2.equals(debut))){
                        return false;
                    }
                }
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(classe.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("libre");
         return true;
    }
}
