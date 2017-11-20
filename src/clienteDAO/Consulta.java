/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteDAO;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import controladores.ControladorBuscar;
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
 * @author PC12
 */
public class Consulta {

   Connection conect;
   PreparedStatement grabar;
   String user = "root";
   String password = "";
   String url = "jdbc:mysql://localhost:3306/basecliente";
   String driver= "com.mysql.jdbc.Driver";  

   JTextField txtNombre;
   JTextField txtApellido;
   JTextField txtDni;
   JTextField txtEmail;
   JTextField txtTelefono;
   JTextField txtCelular;
   JTextField txtCalle;
   JTextField txtAltura;
   JTextField txtPiso;
   
   public void grabarCliente(Cliente cliente  ) throws SQLException{
        
       try {
           
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            if(cliente.getId()== null){
            grabar=conect.prepareStatement("insert into cliente (nombre, apellido, dni, email, telefono, celular, calle, altura, pisoDto) values (?,?,?,?,?,?,?,?,?)");
            
            grabar.setString(1, cliente.getNombre());
            grabar.setString(2, cliente.getApellido());
            grabar.setInt(3, cliente.getDni());
            grabar.setString(4, cliente.getEmail());
            grabar.setString(5, cliente.getTelefono());
            grabar.setString(6, cliente.getCelular());
            grabar.setString(7, cliente.getCalle());
            grabar.setString(8, cliente.getAltura());
            grabar.setString(9, cliente.getPisoDto());

             }else{
                  grabar=conect.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, email = ?, telefono = ?, celular = ?, calle = ?, altura = ?, pisoDto = ? WHERE id = ? ");
                 
            grabar.setString(1, cliente.getNombre());
            grabar.setString(2, cliente.getApellido());
            grabar.setInt(3, cliente.getDni());
            grabar.setString(4, cliente.getEmail());
            grabar.setString(5, cliente.getTelefono());
            grabar.setString(6, cliente.getCelular());
            grabar.setString(7, cliente.getCalle());
            grabar.setString(8, cliente.getAltura());
            grabar.setString(9, cliente.getPisoDto());
            }
             grabar.executeUpdate();

           } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       conect.close();
   }
   
    public Cliente buscarCliente (String email, String dni)throws SQLException{
       Integer rsta = 0;
       Cliente unCliente = null;
       
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            
            if(email!=null)
          
                    grabar=conect.prepareStatement("SELECT * FROM cliente WHERE dni= ?");
            
            else{
                grabar=conect.prepareStatement("SELECT * FROM cliente WHERE email= ?");
                
            }
            
         ResultSet resultado = grabar.executeQuery();
         while(resultado.next()){
            tareas.add(new Mewrua(resultado.getInt("codigo"), resultado.getInt("orden"), resultado.getString("nombre_mostrar")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      } catch (ClassNotFoundException ex) {
           Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
       }
      return unCliente;
   }
    
    
    public Cliente buscarCliente (Cliente cliente)throws SQLException{
       Cliente unCliente = null;
        try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            grabar=conect.prepareStatement("SELECT * FROM cliente WHERE dni= ?");
            grabar.setString(1, txtDni.getText());
            ResultSet resultado = grabar.executeQuery();
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
      } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       conect.close();
       return null;
    }
   
   /*
   public static Cliente buscarCliente (String email)throws SQLException{
   
       Cliente unCliente = null;
       //String q = "SELECT * FROM cliente" + " WHERE email='"+email+"'";
       try{
    
         conect=DriverManager.getConnection(url,user,password);
         PreparedStatement consulta = conect.prepareStatement("SELECT * FROM cliente" + " WHERE email='"+email+"'");
         ResultSet resultado = consulta.executeQuery();

      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
      }
      unCliente= asignarCliente();
        
      return unCliente;
   }
   
   public static Cliente asignarCliente(){
             Cliente unCliente = null;
             String nombre;
             String apellido;
             Integer dni;
             String email;
             String telefono;
             String celular;
             String calle;
             String altura;
             String pisoDto;
        try {
               while(resultado.next()){
            rst = resultado.getInt(1);
         }
        } catch (Exception e) {
        }
      
      return unCliente;
                
    }
   
   */
     /* 
  
  
   public ArrayList<Cliente> recuperarTodas(Connection conexion) throws SQLException{
      ArrayList<Mewrua> tareas = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT codigo, nombre_mostrar, orden FROM " + this.tabla + " ORDER BY codigo");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            tareas.add(new Mewrua(resultado.getInt("codigo"), resultado.getInt("orden"), resultado.getString("nombre_mostrar")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return tareas;
   }




   
      public void actualizarCliente(String palabra) throws SQLException{
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
           // s=conect.prepareStatement("UPDATE palabras SET palabra'"+texto.getText());
          //  grabar=conect.prepareStatement("UPDATE cliente SET palabra='"+texto.getText()+"'");
            grabar.setString(1, palabra);
            grabar.executeUpdate();

           // for(int j=0
              
           } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       conect.close();
   }
   
   public void borrarPorID(String cliente, Integer id) throws SQLException{
      try{
         conect=DriverManager.getConnection(url,user,password);
         PreparedStatement consulta = conect.prepareStatement("DELETE FROM " + cliente + " WHERE id = ?");
         consulta.setInt(1, id);
         consulta.executeUpdate();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
      }
       conect.close();
   }
  
   public Integer obtenerMaxID(String cliente) throws SQLException{
     Integer rst = 0; 
     try{
         System.out.println(cliente);
         conect=DriverManager.getConnection(url,user,password);
         PreparedStatement consulta = conect.prepareStatement("select max(id) as ultid from " + cliente );
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            rst = resultado.getInt(1);
         }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
      }
      conect.close(); 
      return rst;
      
   }
   


      public String obtenerClienteID(String cliente, Integer id) throws SQLException{
          String rst = ""; 
      try{
         conect=DriverManager.getConnection(url,user,password);
         PreparedStatement consulta = conect.prepareStatement("SELECT nombre, apellido, dni, email, telefono, celular, calle, altura, pisoDto FROM  " + cliente +  " WHERE id = ?" );
         consulta.setInt(1, id);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            rst = resultado.getString("nombre, apellido, dni, email, telefono, celular, calle, altura, pisoDto");
         }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e);
      }
       conect.close();
       return rst;
   }
*/
      }
      
      