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
public class ConsultasClientes extends ConectarBD {

    public boolean buscarClientesVentas(Clientes cl) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombres FROM Cliente WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                cl.setNombre(rs.getString("nombres"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean registrarClientes(Clientes cl) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO Cliente (nombres, identificacion, telefono, direccion, correo) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getIdentificacion());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCorreo());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean modificarClientes(Clientes cl) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "UPDATE Cliente SET nombres=?, telefono=?, direccion=?, correo=? WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getTelefono());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getCorreo());
            ps.setString(5, cl.getIdentificacion());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminarClientes(Clientes cl) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "DELETE FROM Cliente WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getIdentificacion());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean buscarClientes(Clientes cl) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombres, identificacion, telefono, direccion, correo FROM Cliente WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                cl.setNombre(rs.getString("nombres"));
                cl.setIdentificacion(rs.getString("identificacion"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setCorreo(rs.getString("correo"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel MostrarDatosTabla() {
        String sql = "SELECT nombres, identificacion, telefono, direccion, correo FROM Cliente";

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
