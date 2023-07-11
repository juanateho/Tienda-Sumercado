package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juana
 */

public class ConsultarVentas extends ConectarBD {

    public String IdVentas() {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String idv = "";
        String sql = "SELECT max(id_ventas) FROM Ventas";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return idv;
    }

    public boolean registrarVentas(Ventas ve) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO Venta (id_cliente, id_empleado, factura, fecha_venta, total) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getId_cliente());
            ps.setInt(2, ve.getId_empleado());
            ps.setInt(3, ve.getFactura());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getTotal());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean registrarDetalleVentas(DetalleVentas dv) {
        Connection con = getConnection();
        PreparedStatement ps;

        String sql = "INSERT INTO DetalleVenta (id_venta, id_articulo, subtotal, iva, descuento) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getId_venta());
            ps.setInt(2, dv.getId_articulo());
            ps.setDouble(3, dv.getSubtotal());
            ps.setDouble(4, dv.getIva());
            ps.setDouble(5, dv.getDescuento());
            ps.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
