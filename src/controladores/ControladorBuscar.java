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
      Connection conect;
   PreparedStatement grabar;
    ResultSet resultado;
   String user = "root";
   String password = "";
   String url = "jdbc:mysql://localhost:3306/basecliente";
   String driver= "com.mysql.jdbc.Driver"; 
   
   
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
    /*
    
    public void mostrar(Cliente unCliente){
        txtNombre.setText(unCliente.getNombre());
        txtApellido.setText(unCliente.getApellido());
      //  txtDni.Integer.valueOf(txtDni.getText(unCliente.getDni));
            txtEmail.setText(unCliente.getEmail());
            txtTelefono.setText(unCliente.getTelefono());
            txtCelular.setText(unCliente.getCelular());
            txtCalle.setText(unCliente.getCalle());
            txtAltura.setText(unCliente.getAltura());
            txtPiso.setText(unCliente.getPisoDto());
       
    }
         */
        @Override
    public void mouseClicked(MouseEvent e) {
        
        Consulta consulta = new Consulta();
        
        Cliente cliente = null;
            try {
            if(cliente == null){
                Registro registrar = new Registro();
                registrar.setVisible(true);
            }else{
                consulta.buscarCliente(cliente);
           JOptionPane.showMessageDialog(null, "datos guardadas exitosamente");
            }
                        
       } 
     //  int dni = Integer.parseInt(txtDni);
       catch (SQLException ex) {
           Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
       }
    
              limpiar();
    }
        
        /*
            try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            grabar=conect.prepareStatement("SELECT * FROM cliente WHERE dni= ?");
            grabar.setString(1, txtDnis.getText());
            resultado = grabar.executeQuery();
            if(resultado.next()){
                txtNombre.setText(resultado.getString("nombre"));
                txtApellido.setText(resultado.getString("apellido"));
                txtDni.setText(resultado.getNString("dni"));
                txtEmail.setText(resultado.getString("email"));
                txtTelefono.setText(resultado.getString("telefono"));
                txtCelular.setText(resultado.getString("celular"));
                txtCalle.setText(resultado.getString("calle"));
                txtAltura.setText(resultado.getString("altura"));
                txtPiso.setText(resultado.getString("pisoDto"));
                JOptionPane.showMessageDialog(null, "datos encontrados");
            }else{
                JOptionPane.showMessageDialog(null, "datos no encontrados");
            }
            } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        
        
        
        
        
        
        
        
        */
        
        
       /*
        Consulta consulta = new Consulta();
          System.out.println("buscar");
          
        String email = txtEmails.getText();
        Cliente unCliente;
        try {
            unCliente= Consulta.buscarCliente(email);
             if(unCliente==null){
        
            }else{
            
        //mostrar(unCliente);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
          
          
          
          
          /*
        try {
            consulta.buscarCliente(txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtEmail.getText(), txtTelefono.getText(), txtCelular.getText(), txtCalle.getText(), txtAltura.getText(), txtPiso.getText());
      
            JOptionPane.showMessageDialog(null, "cliente encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
    

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
