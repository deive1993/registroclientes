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
import models.Cliente;

/**
 *
 * @author PC12
 */
public class ControladorGrabar implements MouseListener{
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtCelular;
    private JTextField txtCalle;
    private JTextField txtAltura;
    private JTextField txtPiso;

    public ControladorGrabar(JTextField txtNombre, JTextField txtApellido, JTextField txtDni, JTextField txtEmail, 
            JTextField txtTelefono, JTextField txtCelular, JTextField txtCalle, JTextField txtAltura, JTextField txtPiso) {
        this.txtNombre = txtNombre;
        this.txtApellido = txtApellido;
        this.txtDni = txtDni;
        this.txtEmail = txtEmail;
        this.txtTelefono = txtTelefono;
        this.txtCelular = txtCelular;
        this.txtCalle = txtCalle;
        this.txtAltura = txtAltura;
        this.txtPiso = txtPiso;
    }
 
    
    

     public void limpiar(){
       txtNombre.setText("");
       txtApellido.setText("");
       txtDni.setText("");
       txtEmail.setText("");
       txtTelefono.setText("");
       txtCelular.setText("");
       txtAltura.setText("");
       txtCalle.setText("");
       txtPiso.setText("");
   }
       
       
    @Override
    public void mouseClicked(MouseEvent e) {
        Consulta consulta = new Consulta();
        Cliente cliente = new Cliente(txtNombre.getText(), txtApellido.getText(), Integer.valueOf(txtDni.getText()) , txtEmail.getText(), 
                txtTelefono.getText(), txtCelular.getText(), txtCalle.getText(), txtAltura.getText(), txtPiso.getText());
        
        System.out.println("datos guardados");
               try {
                   
           consulta.grabarCliente(cliente);
           
           JOptionPane.showMessageDialog(null, "datos guardadas exitosamente");
       } 
       catch (SQLException ex) {
           Logger.getLogger(ControladorGrabar.class.getName()).log(Level.SEVERE, null, ex);
       }
    
               limpiar();
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
