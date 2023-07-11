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
public class ConsultasProveedores extends ConectarBD {

    public boolean registrarClientes(Proveedores pr) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO Proveedor (nombre, identificacion, telefono, direccion, correo) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getNit());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getCorreo());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean modificarClientes(Proveedores pr) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "UPDATE Proveedor SET nombre=?, telefono=?, direccion=?, correo=? WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getTelefono());
            ps.setString(3, pr.getDireccion());
            ps.setString(4, pr.getCorreo());
            ps.setString(5, pr.getNit());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminarClientes(Proveedores pr) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "DELETE FROM Proveedor WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNit());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean buscarClientes(Proveedores pr) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombre, identificacion, telefono, direccion, correo FROM Proveedor WHERE identificacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNit());
            rs = ps.executeQuery();

            if (rs.next()) {
                pr.setNombre(rs.getString("nombre"));
                pr.setNit(rs.getString("identificacion"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCorreo(rs.getString("correo"));

                return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel MostrarDatosTabla() {
        String sql = "SELECT nombre, identificacion, telefono, direccion, correo FROM Proveedor";

        Connection con = getConnection();
        Statement st;

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Nombre");
        model.addColumn("NIT");
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
