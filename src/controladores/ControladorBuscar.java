/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clienteDAO.Consulta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import visual.Registro;

/**
 *
 * @author PC12
 */
public class ControladorBuscar implements MouseListener{
   
    private JTextField txtDnis;
    private JTextField txtEmails;

    public ControladorBuscar(JTextField txtDnis, JTextField txtEmails) {
        this.txtDnis = txtDnis;
        this.txtEmails = txtEmails;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        
        Consulta consulta = new Consulta();
          System.out.println("buscar");
          
        try {
            consulta.buscarCliente(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtEmail.getText(), txtTelefono.getText(), txtCelular.getText(), txtCalle.getText(), txtAltura.getText(), txtPiso.getText());
      
            JOptionPane.showMessageDialog(null, "cliente encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
