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
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtCelular;
    private JTextField txtCalle;
    private JTextField txtAltura;
    private JTextField txtPiso;

    @Override
    public void mouseClicked(MouseEvent e) {
        Registro registro = new Registro();
        registro.setVisible(true);
        
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
