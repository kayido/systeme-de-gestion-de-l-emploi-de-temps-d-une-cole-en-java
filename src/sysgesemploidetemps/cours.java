package sysgesemploidetemps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
public class cours {
    
    public int id_e;
    public int id_m;
    public int id_c;
    public String jour;
    public Time debut;
    public Time fin;
    connectBD bd = new connectBD();

    public cours(int id_c,int id_e,int id_m,String jour,Time debut,Time fin){
        this.id_c =id_c;
        this.id_e = id_e;
        this.id_m = id_m;
        this.jour = jour;
        this.debut = debut;
        this.fin =fin;
    }
    
    public boolean save(){
        PreparedStatement ps;
        String addQuery = "INSERT INTO `cours`(`id_c`, `id_e`, `id_m`, `jour`, `debut`, `fin`) VALUES (?,?,?,?,?,?)";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setInt(1, this.id_c);
            ps.setInt(2, this.id_e);
            ps.setInt(3, this.id_m);
            ps.setString(4, this.jour);
            ps.setTime(5, this.debut);
            ps.setTime(6, this.fin);
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
    
    public boolean update(cours c){
        PreparedStatement ps;
        String addQuery = "UPDATE `cours` SET `id_e`=?,`id_m`=?,`jour`=?,`debut`=?,`fin`=? WHERE `id_c`=? AND debut=? AND fin =?";
        try {
            ps = bd.createConnection().prepareStatement(addQuery);
            ps.setInt(1, this.id_e);
            ps.setInt(2, this.id_m);
            ps.setString(3, this.jour);
            ps.setTime(4, this.debut);
            ps.setTime(5, this.fin);
            ps.setInt(6, c.id_c);
            ps.setTime(7, c.debut);
            ps.setTime(8, c.fin);
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        PreparedStatement st;
        ResultSet rs;
        String editQuery = "DELETE FROM `cours`  WHERE id_c = ? AND debut=? AND fin = ?";        
        try {
            st = bd.createConnection().prepareStatement(editQuery);
             st.setInt(1, this.id_c);
            st.setTime(2, this.debut);
            st.setTime(3, this.fin);

            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(cours.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    
     public static void show(JTable table,int id) throws SQLException{
        connectBD bd = new connectBD();
        PreparedStatement st;
        ResultSet rs;
        String selectQuery = "SELECT * FROM cours where id_c = ?";
        st = bd.createConnection().prepareStatement(selectQuery);
        st.setInt(1, id);
        rs = st.executeQuery();
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        
        Object[] row;
        
        while(rs.next()){
            row = new Object[6];
            row[0] = classe.recupNom(rs.getInt(1));
            row[1] = enseignant.recupNom(rs.getInt(2));
            row[2] = matiere.recupNom(rs.getInt(3));
            row[3] = rs.getString(4);
            row[4] = rs.getTime(5);
            row[5] = rs.getTime(6);
            System.out.println(classe.recupNom(rs.getInt(1))+"-----"+enseignant.recupNom(rs.getInt(2)));
            tableModel.addRow(row);
        }
    }
}
