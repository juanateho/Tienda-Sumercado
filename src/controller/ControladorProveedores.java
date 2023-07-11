package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConsultasProveedores;
import model.Proveedores;
import view.FormularioProveedores;

/**
 *
 * @author juana
 */
public class ControladorProveedores implements ActionListener{
    
    FormularioProveedores objPr;
    ConsultasProveedores prSQL;
    Proveedores pr;
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorProveedores(FormularioProveedores objPr, ConsultasProveedores prSQL, Proveedores pr) {
        this.objPr = objPr;
        this.prSQL = prSQL;
        this.pr = pr;
        this.objPr.getBtnAgregar().addActionListener(this);
        this.objPr.getBtnEliminar().addActionListener(this);
        this.objPr.getBtnModificar().addActionListener(this);
        this.objPr.getBtnBuscar().addActionListener(this);
        this.objPr.getBtnLimpiar().addActionListener(this);
        verRegistros();
        limpiar();
    }
    
    public void verRegistros() {
        modelo = (DefaultTableModel) objPr.getTlbProveedores().getModel();
        int filas = objPr.getTlbProveedores().getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }

        modelo = prSQL.MostrarDatosTabla();
        objPr.getTlbProveedores().setModel(modelo);
    }

    public void limpiar() {
        objPr.getTxtNombre().setText("");
        objPr.getTxtIdentificacion().setText("");
        objPr.getTxtTelefono().setText("");
        objPr.getTxtDireccion().setText("");
        objPr.getTxtCorreo().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == objPr.getBtnAgregar()) {
            pr.setNombre(objPr.getTxtNombre().getText());
            pr.setNit(objPr.getTxtIdentificacion().getText());
            pr.setTelefono(objPr.getTxtTelefono().getText());
            pr.setDireccion(objPr.getTxtDireccion().getText());
            pr.setCorreo(objPr.getTxtCorreo().getText());

            if (prSQL.registrarClientes(pr)) {
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objPr.getBtnModificar()) {
            pr.setNombre(objPr.getTxtNombre().getText());
            pr.setNit(objPr.getTxtIdentificacion().getText());
            pr.setTelefono(objPr.getTxtTelefono().getText());
            pr.setDireccion(objPr.getTxtDireccion().getText());
            pr.setCorreo(objPr.getTxtCorreo().getText());

            if (prSQL.modificarClientes(pr)) {
                JOptionPane.showMessageDialog(null, "Registro modificado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar.");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objPr.getBtnEliminar()) {
            pr.setNit(objPr.getTxtIdentificacion().getText());

            if (prSQL.eliminarClientes(pr)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar.");
                limpiar();
            }
            verRegistros();
        }
        
         if (e.getSource() == objPr.getBtnBuscar()) {
            pr.setNit(objPr.getTxtIdentificacion().getText());

            if (prSQL.buscarClientes(pr)) {
                objPr.getTxtNombre().setText(pr.getNombre());
                objPr.getTxtIdentificacion().setText(pr.getNit());
                objPr.getTxtTelefono().setText(pr.getTelefono());
                objPr.getTxtDireccion().setText(pr.getDireccion());
                objPr.getTxtCorreo().setText(pr.getCorreo());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el resultado..");
                limpiar();
            }
            verRegistros();
        }
        
        if (e.getSource() == objPr.getBtnLimpiar()) {
            limpiar();
        }
        
    }
    
}
