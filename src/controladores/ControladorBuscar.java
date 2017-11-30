/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clienteDAO.Consulta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Cliente;
import visual.Registro;


/**
 *
 * @author PC12
 */
public class ControladorBuscar implements MouseListener{

    private JTextField txtDnis;
    private JTextField txtEmails;

    
    
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtCelular;
    private JTextField txtCalle;
    private JTextField txtAltura;
    private JTextField txtPiso;
    
    public ControladorBuscar(JTextField txtDnis, JTextField txtEmails) {
        this.txtDnis = txtDnis;
        this.txtEmails = txtEmails;
    }

        public ControladorBuscar(JTextField txtNombre, JTextField txtApellido, JTextField txtDni, JTextField txtEmail, JTextField txtTelefono, JTextField txtCelular, JTextField txtCalle, JTextField txtAltura, JTextField txtPiso) {
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
        
        
//limpiar cajas de texto
        
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
       Cliente datos=null;

        /*
        Cliente cliente = new Cliente(txtNombre.setText(cliente.getNombre()), txtApellido.setText(cliente.getApellido()), 
                txtDni.setText(String.valueOf(cliente.getDni())), txtEmail.setText(cliente.getEmail()), txtTelefono.setText(cliente.getTelefono()), 
                txtCelular.setText(cliente.getCelular()), txtCalle.setText(cliente.getCalle()), txtAltura.setText(cliente.getAltura()), 
                txtPiso.setText(cliente.getPisoDto()));
           */
         try {
           if (txtEmails.getText().equals("")){
               System.out.println("dni loco");
               txtEmails.setVisible(false);
             datos = consulta.buscarCliente(null,txtDnis.getText());
               if(datos==null){
                   System.out.println("no hay nadita amigo");
                   
               }
               else{
                     Registro registrar = new Registro();
                     
                    System.out.println(datos.getId());
                    System.out.println(datos.getNombre());
                    System.out.println(datos.getApellido());
                    System.out.println(datos.getDni());
                   System.out.println(datos.getEmail());
                   System.out.println(datos.getTelefono());
                   System.out.println(datos.getCelular());
                   System.out.println(datos.getCalle());
                   System.out.println(datos.getAltura());
                   System.out.println(datos.getPisoDto());
                   
                   
                   
               }
               
           }   
            else
               if(txtDnis.getText().equals(0)){
               txtDni.setVisible(false);
               System.out.println("email loco");
               consulta.buscarCliente(txtEmails.getText(),null);
               }
           } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
           JOptionPane.showMessageDialog(null, "Conexion Establecida");
     
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
