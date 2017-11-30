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

/**
 *
 * @author USER
 */
public class ControladorBuscarRe implements MouseListener{
       Connection conect;
   PreparedStatement grabar;
    ResultSet resultado;
   String user = "root";
   String password = "";
   String url = "jdbc:mysql://localhost:3306/basecliente";
   String driver= "com.mysql.jdbc.Driver"; 

       private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtCelular;
    private JTextField txtCalle;
    private JTextField txtAltura;
    private JTextField txtPiso;

    public ControladorBuscarRe(JTextField txtNombre, JTextField txtApellido, JTextField txtDni, JTextField txtEmail, JTextField txtTelefono, JTextField txtCelular, JTextField txtCalle, JTextField txtAltura, JTextField txtPiso) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
     Cliente cliente = new Cliente(txtNombre.setText(cliente.getNombre()), txtApellido.setText(cliente.getApellido()), 
             txtDni.setText(String.valueOf(cliente.getDni())), txtEmail.setText(cliente.getEmail()), txtTelefono.setText(cliente.getTelefono()), 
             txtCelular.setText(cliente.getCelular()), txtCalle.setText(cliente.getCalle()), 
             txtAltura.setText(cliente.getAltura()), txtPiso.setText(cliente.getPisoDto()));
     
     Consulta consulta = new Consulta();
        
           try {
               cliente.setNombre(txtNombre.getText());
               consulta.buscarCliente(cliente);
           } catch (SQLException ex) {
               Logger.getLogger(ControladorBuscarRe.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }*/
       
         try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            grabar=conect.prepareStatement("SELECT * FROM cliente WHERE dni= ?");
            grabar.setString(1, txtDni.getText());
            resultado = grabar.executeQuery();
            if(resultado.next()){
                txtNombre.setText(resultado.getString("nombre"));
                txtApellido.setText(resultado.getString("apellido"));
                txtDni.setText(resultado.getString("dni"));
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
