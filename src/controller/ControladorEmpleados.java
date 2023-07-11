package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConsultasEmpleados;
import model.Empleados;
import view.FormularioEmpleados;

/**
 *
 * @author juana
 */
public class ControladorEmpleados implements ActionListener {

    FormularioEmpleados objEm;
    ConsultasEmpleados emSQL;
    Empleados em;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorEmpleados(FormularioEmpleados objEm, ConsultasEmpleados emSQL, Empleados em) {
        this.objEm = objEm;
        this.emSQL = emSQL;
        this.em = em;
        objEm.getBtnAgregar().addActionListener(this);
        objEm.getBtnBuscar().addActionListener(this);
        objEm.getBtnEliminar().addActionListener(this);
        objEm.getBtnLimpiar().addActionListener(this);
        objEm.getBtnModificar().addActionListener(this);
        verRegistros();
        limpiar();
    }

    private void verRegistros() {
        modelo = (DefaultTableModel) objEm.getTlbEmpleados().getModel();
        int filas = objEm.getTlbEmpleados().getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }

        modelo = emSQL.MostrarDatosTabla();
        objEm.getTlbEmpleados().setModel(modelo);
    }

    private void limpiar() {
        objEm.getTxtNombre().setText("");
        objEm.getTxtIdentificacion().setText("");
        objEm.getTxtTelefono().setText("");
        objEm.getTxtDireccion().setText("");
        objEm.getTxtCorreo().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objEm.getBtnAgregar()) {
            em.setNombre(objEm.getTxtNombre().getText());
            em.setIdentificacion(objEm.getTxtIdentificacion().getText());
            em.setTelefono(objEm.getTxtTelefono().getText());
            em.setDireccion(objEm.getTxtDireccion().getText());
            em.setCorreo(objEm.getTxtCorreo().getText());

            if (emSQL.registrarClientes(em)) {
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objEm.getBtnModificar()) {
            em.setNombre(objEm.getTxtNombre().getText());
            em.setIdentificacion(objEm.getTxtIdentificacion().getText());
            em.setTelefono(objEm.getTxtTelefono().getText());
            em.setDireccion(objEm.getTxtDireccion().getText());
            em.setCorreo(objEm.getTxtCorreo().getText());

            if (emSQL.modificarClientes(em)) {
                JOptionPane.showMessageDialog(null, "Registro modificado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar.");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objEm.getBtnEliminar()) {
            em.setIdentificacion(objEm.getTxtIdentificacion().getText());

            if (emSQL.eliminarClientes(em)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar.");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objEm.getBtnBuscar()) {
            em.setIdentificacion(objEm.getTxtIdentificacion().getText());

            if (emSQL.buscarClientes(em)) {
                objEm.getTxtNombre().setText(em.getNombre());
                objEm.getTxtIdentificacion().setText(em.getIdentificacion());
                objEm.getTxtTelefono().setText(em.getTelefono());
                objEm.getTxtDireccion().setText(em.getDireccion());
                objEm.getTxtCorreo().setText(em.getCorreo());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el resultado..");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objEm.getBtnLimpiar()) {
            limpiar();
        }
    }

}
