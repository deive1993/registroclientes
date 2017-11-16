/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
   
   //public void grabarCliente(String nombre, String apellido, Integer dni, String email, String telefono, String celular, String calle, String altura, String pisoDto ) throws SQLException{
   public void grabarCliente(String nombre, String apellido, String dni, String email, String telefono, String celular, String calle, String altura, String pisoDto ) throws SQLException{
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            grabar=conect.prepareStatement("insert into cliente (nombre, apellido, dni, email, telefono, celular, calle, altura, pisoDto) values (?,?,?,?,?,?,?,?,?)");
            grabar.setString(1, nombre);
            grabar.setString(2, apellido);
           // grabar.setInt(3, dni);
            grabar.setString(3, dni);
            grabar.setString(4, email);
            grabar.setString(5, telefono);
            grabar.setString(6, celular);
            grabar.setString(7, calle);
            grabar.setString(8, altura);
            grabar.setString(9, pisoDto);
            grabar.executeUpdate();

              
           } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       conect.close();
   }
   
   public void buscarCliente (String nombre, String apellido, String dni, String email, String telefono, String celular, String calle, String altura, String pisoDto)throws SQLException{
              try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
           // s=conect.prepareStatement("UPDATE palabras SET palabra'"+texto.getText());
          //  grabar=conect.prepareStatement("UPDATE cliente SET palabra='"+texto.getText()+"'");
           //grabar.setString(1, palabra);
            grabar.executeUpdate();

              for(int j = 0;j<cliente.length;j++){
                  
              }
           } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       conect.close();
   }
      public void actualizarCliente(String palabra) throws SQLException{
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
           // s=conect.prepareStatement("UPDATE palabras SET palabra'"+texto.getText());
          //  grabar=conect.prepareStatement("UPDATE cliente SET palabra='"+texto.getText()+"'");
            grabar.setString(1, palabra);
            grabar.executeUpdate();

            for(int j=0
              
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

      }
      
      