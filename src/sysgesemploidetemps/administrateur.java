package sysgesemploidetemps;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
public class administrateur {
    private int id;
    private String nom;
    private String password;
    
    public administrateur(int id,String nom,String password){
        this.id = id;
        this.nom = nom;
        this.password = password;
    }
    
    
    public boolean authentification(){
        try {
            connectBD bd = new connectBD();
            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM `administrateur` WHERE nom=? AND password=?";
            ps = bd.createConnection().prepareStatement(query);
            ps.setString(1, this.nom);
            ps.setString(2, this.password);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(){
        try {
            connectBD bd = new connectBD();
            PreparedStatement ps;
            ResultSet rs;
            String query = "UPDATE administrateur SET nom=?,password=? WHERE id=1";
            ps = bd.createConnection().prepareStatement(query);
            ps.setString(1, this.nom);
            ps.setString(2, this.password);
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(administrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
