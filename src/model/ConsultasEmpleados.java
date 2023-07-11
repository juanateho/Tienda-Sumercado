package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juana
 */
public class ConsultasEmpleados extends ConectarBD {
    
    public boolean buscarEmpleadosVentas(Empleados em) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombres FROM Empleado WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                em.setNombre(rs.getString("nombres"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean registrarClientes(Empleados em) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO Empleado (id_credenciales, nombres, identificacion, telefono, direccion, correo) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getIdentificacion());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getDireccion());
            ps.setString(6, em.getCorreo());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean modificarClientes(Empleados em) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "UPDATE Empleado SET nombres=?, telefono=?, direccion=?, correo=? WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getTelefono());
            ps.setString(3, em.getDireccion());
            ps.setString(4, em.getCorreo());
            ps.setString(5, em.getIdentificacion());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminarClientes(Empleados em) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "DELETE FROM Empleado WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getIdentificacion());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public boolean buscarClientes(Empleados em) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombres, identificacion, telefono, direccion, correo FROM Empleado WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                em.setNombre(rs.getString("nombres"));
                em.setIdentificacion(rs.getString("identificacion"));
                em.setTelefono(rs.getString("telefono"));
                em.setDireccion(rs.getString("direccion"));
                em.setCorreo(rs.getString("correo"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public DefaultTableModel MostrarDatosTabla() {
        String sql = "SELECT nombres, identificacion, telefono, direccion, correo FROM Empleado";

        Connection con = getConnection();
        Statement st;

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Nombre");
        model.addColumn("Identificación");
        model.addColumn("Telefono");
        model.addColumn("Dirección");
        model.addColumn("Correo");

        String[] dato = new String[5];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);

                model.addRow(dato);
            }

        } catch (SQLException ex) {

        }
        return model;

    }
}
