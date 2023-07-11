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
public class ConsultasProductos extends ConectarBD {

    public boolean buscarProductosVentas(Productos pr) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT nombre, valor_venta, cantidad FROM Articulo WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pr.setNombre(rs.getString("nombre"));
                pr.setPrecio(rs.getString("valor_venta"));
                pr.setCantidad(rs.getInt("cantidad"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean registrarProductos(Productos pr) {

        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO Articulo (nombre, descripcion, valor_venta, tipo, categoria, cantidad, perecedero) VALUES (?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getPrecio());
            ps.setString(4, pr.getTipo());
            ps.setString(5, pr.getCatergoria());
            ps.setInt(6, pr.getCantidad());
            ps.setString(7, pr.getPerecedero());

            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean modificarProductos(Productos pr) {

        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "UPDATE Articulo SET descripcion=?, valor_venta=?, tipo=?, categoria=?, cantidad=?, perecedero=? WHERE nombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getDescripcion());
            ps.setString(2, pr.getPrecio());
            ps.setString(3, pr.getTipo());
            ps.setString(4, pr.getCatergoria());
            ps.setInt(5, pr.getCantidad());
            ps.setString(6, pr.getPerecedero());
            ps.setString(7, pr.getNombre());

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminarProductos(Productos pr) {

        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "DELETE FROM Articulo WHERE nombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());

            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean buscarProductos(Productos pr) {

        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM Articulo WHERE nombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());

            rs = ps.executeQuery();

            if (rs.next()) {
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecio(rs.getString("valor_venta"));
                pr.setTipo(rs.getString("tipo"));
                pr.setCatergoria(rs.getString("categoria"));
                pr.setCantidad(rs.getInt("cantidad"));
                pr.setPerecedero(rs.getString("perecedero"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel MostrarDatosTabla() {
        String sql = "SELECT * FROM Articulo";

        Connection con = getConnection();
        Statement st;

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio c/u");
        model.addColumn("Tipo");
        model.addColumn("Categoría");
        model.addColumn("Cantidad");
        model.addColumn("Perecedero");

        String[] dato = new String[8];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(6);
                dato[6] = result.getString(7);
                dato[7] = result.getString(8);

                model.addRow(dato);
            }

        } catch (SQLException ex) {

        }
        return model;

    }
}
