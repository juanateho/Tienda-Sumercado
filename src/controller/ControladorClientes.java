package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.ConsultasClientes;
import view.FormularioClientes;

/**
 *
 * @author juana
 */
public class ControladorClientes implements ActionListener {

    FormularioClientes objCl;
    ConsultasClientes clSQL;
    Clientes cl;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorClientes(FormularioClientes objCl, ConsultasClientes clSQL, Clientes cl) {
        this.objCl = objCl;
        this.clSQL = clSQL;
        this.cl = cl;
        this.objCl.getBtnAgregar().addActionListener(this);
        this.objCl.getBtnModificar().addActionListener(this);
        this.objCl.getBtnEliminar().addActionListener(this);
        this.objCl.getBtnBuscar().addActionListener(this);
        this.objCl.getBtnLimpiar().addActionListener(this);
        verRegistros();
        limpiar();
    }

    private void verRegistros() {
        modelo = (DefaultTableModel) objCl.getTlbClientes().getModel();
        int filas = objCl.getTlbClientes().getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }

        modelo = clSQL.MostrarDatosTabla();
        objCl.getTlbClientes().setModel(modelo);
    }

    private void limpiar() {
        objCl.getTxtNombre().setText("");
        objCl.getTxtIdentificacion().setText("");
        objCl.getTxtTelefono().setText("");
        objCl.getTxtDireccion().setText("");
        objCl.getTxtCorreo().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == objCl.getBtnAgregar()) {
            cl.setNombre(objCl.getTxtNombre().getText());
            cl.setIdentificacion(objCl.getTxtIdentificacion().getText());
            cl.setTelefono(objCl.getTxtTelefono().getText());
            cl.setDireccion(objCl.getTxtDireccion().getText());
            cl.setCorreo(objCl.getTxtCorreo().getText());

            if (clSQL.registrarClientes(cl)) {
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objCl.getBtnModificar()) {
            cl.setNombre(objCl.getTxtNombre().getText());
            cl.setIdentificacion(objCl.getTxtIdentificacion().getText());
            cl.setTelefono(objCl.getTxtTelefono().getText());
            cl.setDireccion(objCl.getTxtDireccion().getText());
            cl.setCorreo(objCl.getTxtCorreo().getText());

            if (clSQL.modificarClientes(cl)) {
                JOptionPane.showMessageDialog(null, "Registro modificado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objCl.getBtnEliminar()) {
            cl.setIdentificacion(objCl.getTxtIdentificacion().getText());

            if (clSQL.eliminarClientes(cl)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objCl.getBtnBuscar()) {
            cl.setIdentificacion(objCl.getTxtIdentificacion().getText());

            if (clSQL.buscarClientes(cl)) {
                objCl.getTxtNombre().setText(cl.getNombre());
                objCl.getTxtIdentificacion().setText(cl.getIdentificacion());
                objCl.getTxtTelefono().setText(cl.getTelefono());
                objCl.getTxtDireccion().setText(cl.getDireccion());
                objCl.getTxtCorreo().setText(cl.getCorreo());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el resultado..");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objCl.getBtnLimpiar()) {
            limpiar();
        }
    }

}
