package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConsultasProductos;
import model.Productos;
import view.FormularioProductos;

/**
 *
 * @author juana
 */
public class ControladorProductos implements ActionListener {

    FormularioProductos objPr;
    ConsultasProductos prSQL;
    Productos pr;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProductos(FormularioProductos objPr, ConsultasProductos prSQL, Productos pr) {
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
        modelo = (DefaultTableModel) objPr.getTlbProductos().getModel();
        int filas = objPr.getTlbProductos().getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }

        modelo = prSQL.MostrarDatosTabla();
        objPr.getTlbProductos().setModel(modelo);
    }

    public void limpiar() {
        objPr.getTxtNombre().setText("");
        objPr.getTxtDescripcion().setText("");
        objPr.getTxtPrecio().setText("");
        objPr.getTxtCategoria().setText("");
        objPr.getTxtCantidad().setText("");
        objPr.getBtnGrupoPerecedero().clearSelection();
        objPr.getBtnGrupoPerecedero().setSelected(null, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == objPr.getBtnAgregar()) {

            String valor;

            if (objPr.getBtnSi().isSelected()) {
                valor = "Si";
            } else {
                valor = "No";
            }

            pr.setNombre(objPr.getTxtNombre().getText());
            pr.setDescripcion(objPr.getTxtDescripcion().getText());
            pr.setPrecio(objPr.getTxtPrecio().getText());
            pr.setTipo(objPr.getCbxTipo().getSelectedItem().toString());
            pr.setCatergoria(objPr.getTxtCategoria().getText());
            pr.setCantidad(Integer.parseInt(objPr.getTxtCantidad().getText()));
            pr.setPerecedero(valor);

            if (prSQL.registrarProductos(pr)) {
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objPr.getBtnModificar()) {

            String valor;

            if (objPr.getBtnSi().isSelected()) {
                valor = "Si";
            } else {
                valor = "No";
            }

            pr.setNombre(objPr.getTxtNombre().getText());
            pr.setCatergoria(objPr.getTxtCategoria().getText());
            pr.setPrecio(objPr.getTxtPrecio().getText());
            pr.setTipo(objPr.getCbxTipo().getSelectedItem().toString());
            pr.setCatergoria(objPr.getTxtCategoria().getText());
            pr.setCantidad(Integer.parseInt(objPr.getTxtCantidad().getText()));
            pr.setPerecedero(valor);

            if (prSQL.modificarProductos(pr)) {
                JOptionPane.showMessageDialog(null, "Registro modificado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objPr.getBtnEliminar()) {
            pr.setNombre(objPr.getTxtNombre().getText());

            if (prSQL.eliminarProductos(pr)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar.");
                limpiar();
            }
            verRegistros();
        }

        if (e.getSource() == objPr.getBtnBuscar()) {
            pr.setNombre(objPr.getTxtNombre().getText());

            if (prSQL.buscarProductos(pr)) {
                objPr.getTxtNombre().setText(String.valueOf(pr.getNombre()));
                objPr.getTxtDescripcion().setText(String.valueOf(pr.getDescripcion()));
                objPr.getTxtPrecio().setText(String.valueOf(pr.getPrecio()));
                objPr.getCbxTipo().setSelectedItem(pr.getTipo());
                objPr.getTxtCategoria().setText(String.valueOf(pr.getCatergoria()));
                objPr.getTxtCantidad().setText(String.valueOf(pr.getCantidad()));
                //objPr.getBtnGrupoPerecedero().setSelected(pr.getPerecedero(), true);

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el resultado.");
                limpiar();

            }
            verRegistros();
        }

        if (e.getSource() == objPr.getBtnLimpiar()) {
            limpiar();
        }

    }

}
