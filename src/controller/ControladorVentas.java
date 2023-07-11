package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Clientes;
import model.ConsultarVentas;
import model.ConsultasClientes;
import model.ConsultasEmpleados;
import model.ConsultasProductos;
import model.DetalleVentas;
import model.Empleados;
import model.Inventario;
import model.Productos;
import model.Ventas;
import view.FormularioVentas;

/**
 *
 * @author juana
 */
public class ControladorVentas implements ActionListener {

    FormularioVentas objVe;
    ConsultasClientes clSQL;
    ConsultasEmpleados emSQL;
    ConsultasProductos prSQL;
    ConsultarVentas veSQL;
    Empleados em;
    Clientes cl;
    Productos pr;
    Inventario in;
    Ventas ve;
    DetalleVentas dv;

    public ControladorVentas(FormularioVentas objVe, ConsultasClientes clSQL, ConsultasEmpleados emSQL, ConsultasProductos prSQL, ConsultarVentas veSQL, Empleados em, Clientes cl, Productos pr, Inventario in, Ventas ve, DetalleVentas dv) {
        this.objVe = objVe;
        this.clSQL = clSQL;
        this.emSQL = emSQL;
        this.prSQL = prSQL;
        this.veSQL = veSQL;
        this.em = em;
        this.cl = cl;
        this.pr = pr;
        this.in = in;
        this.ve = ve;
        this.dv = dv;
        this.objVe.getBtnBuscarCliente().addActionListener(this);
        this.objVe.getBtnBuscarEmpleado().addActionListener(this);
        this.objVe.getBtnBuscarProducto().addActionListener(this);
        this.objVe.getBtnGenerarVenta().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objVe.getBtnBuscarCliente()) {
            cl.setIdentificacion(objVe.getTxtCodCliente().getText());

            if (objVe.getTxtCodCliente().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación.");
            } else {
                if (clSQL.buscarClientesVentas(cl)) {
                    objVe.getTxtNomCliente().setText(cl.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    objVe.getTxtNomCliente().setText("");
                }
            }
        }

        if (e.getSource() == objVe.getBtnBuscarEmpleado()) {
            em.setIdentificacion(objVe.getTxtCodEmpleado().getText());

            if (objVe.getTxtCodEmpleado().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una identificación.");
            } else {
                if (emSQL.buscarEmpleadosVentas(em)) {
                    objVe.getTxtNomEmpleado().setText(em.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    objVe.getTxtNomEmpleado().setText("");
                }
            }
        }

        if (e.getSource() == objVe.getBtnBuscarProducto()) {
            pr.setId(Integer.parseInt(objVe.getTxtCodProducto().getText()));

            if (objVe.getTxtCodProducto().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo.");
            } else {
                if (prSQL.buscarProductosVentas(pr)) {
                    objVe.getTxtNomProducto().setText(pr.getNombre());
                    objVe.getTxtPrecio().setText(pr.getPrecio());
                    objVe.getTxtStock().setText(String.valueOf(pr.getCantidad()));
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    objVe.getTxtNomProducto().setText("");
                    objVe.getTxtPrecio().setText("");
                }
            }
        }

        if (e.getSource() == objVe.getBtnGenerarVenta()) {
            //ve.setId_cliente(Integer.parseInt(objVe.getTxtCodCliente().getText()));
            ve.setId_cliente(cl.getId());
            ve.setId_empleado(Integer.parseInt(objVe.getTxtCodEmpleado().getText()));
            ve.setFactura(Integer.parseInt(objVe.getTxtFactura().getText()));
            ve.setFecha(objVe.getTxtFecha().getText());
            ve.setTotal(Double.valueOf(objVe.getTxtSubtotal().getText()));

            /*String idv = veSQL.IdVentas();
            int idve = Integer.parseInt(idv);

            for (int i = 0; i < objVe.getTlbVenta().getRowCount(); i++) {
                dv.setId_venta(idve);
                dv.setId_articulo(Integer.parseInt(objVe.getTlbVenta().getValueAt(i, 1).toString()));
                dv.setCantidad(Integer.parseInt(objVe.getTlbVenta().getValueAt(i, 3).toString()));
                dv.setSubtotal(Double.valueOf(objVe.getTxtSubtotal().getText()));
            }*/

            if (veSQL.registrarVentas(ve)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

            /*if (veSQL.registrarDetalleVentas(dv)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }*/
        }
    }

}
