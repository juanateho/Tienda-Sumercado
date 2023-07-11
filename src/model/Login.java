package model;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author juana
 */
public class Login {
    
    private String usuario, contraseña;
    
    ConectarBD conexion = new ConectarBD();
    Connection con = conexion.getConnection();
    
    public int validarLogin() {
        int a = 0;
        
        try {
            
            String sql = "SELECT * FROM Credenciales WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "'";
            
            PreparedStatement st;
            ResultSet rs;
            
            st = con.prepareStatement(sql);
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                a = 1;
            } else {                
                a = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return a;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
