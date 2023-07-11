package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Login;
import view.FormularioLogin;
import view.FormularioPrincipal;

/**
 *
 * @author juana
 */
public class ControladorLogin implements ActionListener {

    FormularioLogin objVista;
    Login objLogin;
    FormularioPrincipal principal;

    public ControladorLogin() {
        objVista = new FormularioLogin();
        objVista.setVisible(true);
        objVista.getBtnAcceder().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objVista.getBtnAcceder()) {

            objLogin = new Login();

            objLogin.setUsuario(objVista.getTxtUsuario().getText());
            objLogin.setContraseña(String.valueOf(objVista.getTxtContraseña().getText()));
            
            if (objLogin.validarLogin() == 1) {
                FormularioPrincipal principal = new FormularioPrincipal();
                principal.setVisible(true);
                
                objVista.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El usuario y/o contraseña son incorrectos.");
                objVista.getTxtUsuario().setText("");
                objVista.getTxtContraseña().setText("");
            }
        }
    }
}
