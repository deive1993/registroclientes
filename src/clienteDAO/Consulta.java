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

   public void grabarCliente(Cliente cliente  ) throws SQLException{
        
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            
            if(cliente.getId()== null){
            grabar=conect.prepareStatement("INSERT INTO cliente (nombre, apellido, dni, email, "
                    + "telefono, celular, calle, altura, pisoDto) values (?,?,?,?,?,?,?,?,?)");
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
                  grabar=conect.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, email = ?, "
                          + "telefono = ?, celular = ?, calle = ?, altura = ?, pisoDto = ? WHERE id = ? ");
                 
            grabar.setString(1, cliente.getNombre());
            grabar.setString(2, cliente.getApellido());
            grabar.setInt(3, cliente.getDni());
            grabar.setString(4, cliente.getEmail());
            grabar.setString(5, cliente.getTelefono());
            grabar.setString(6, cliente.getCelular());
            grabar.setString(7, cliente.getCalle());
            grabar.setString(8, cliente.getAltura());
            grabar.setString(9, cliente.getPisoDto());
            grabar.setInt(10, cliente.getId());
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
   
  // public Cliente buscarCliente (String email, Integer dni)throws SQLException{      
   public Cliente buscarCliente (String email, String dni)throws SQLException{      
        Integer rst = 0;
        Cliente unCliente = null;
        Integer dnis = 0;
        String emails = "";
        
       try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            if(dni==null){
              //  grabar=conect.prepareStatement("SELECT * FROM cliente WHERE email= ?");
              grabar=conect.prepareStatement("select id,nombre,apellido,dni,email,telefono,celular,calle,altura,pisoDto from cliente");
              
             System.out.println("email");
              //  grabar.setString(1, email);
            } else{
                //grabar=conect.prepareStatement("SELECT * FROM cliente WHERE dni= ?");
               grabar=conect.prepareStatement("select id,nombre,apellido,dni,email,telefono,celular,calle,altura,pisoDto from cliente");

               // grabar.setInt(1, dni);
               dnis=Integer.valueOf(dni);
               System.out.println("dni");
            }
             ResultSet resultado = grabar.executeQuery();
             
                while(resultado.next()){
                    unCliente = new Cliente (resultado.getString("id"), resultado.getString("nombre"), Integer.parseInt(resultado.getString("dni")),
                            resultado.getString("email"), resultado.getString("telefono"), resultado.getString("celular"), resultado.getString("calle"), 
                            resultado.getString("altura"), resultado.getString("pisoDto"));
                }  
      } 
        catch (ClassNotFoundException e) {
              JOptionPane.showMessageDialog(null, e);}
       
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
      conect.close();
      return unCliente;
   }
    }
    
    
    
    
    /*
       public void buscarCliente (Cliente cliente)throws SQLException{
     
          try {
            Class.forName(driver);
            conect=DriverManager.getConnection(url,user,password);
            grabar=conect.prepareStatement("SELECT * FROM cliente WHERE nombre= ?");
            grabar.setString(1, cliente.getNombre());
            ResultSet resultado = grabar.executeQuery();
           if(resultado.next())
            {
                cliente.setId(Integer.parseInt(resultado.getString("id")));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setDni(Integer.parseInt(resultado.getString("dni")));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setCalle(resultado.getString("calle"));
                cliente.setAltura(resultado.getString("altura"));
                cliente.setPisoDto(resultado.getString("pisoDto"));
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
   }}
       */
    
    
    
   
     /* 
  
  
            grabar=conect.prepareStatement("SELECT * FROM cliente WHERE email=? ");
            grabar.setString(1, cliente.getEmail());
            ResultSet resultado = grabar.executeQuery();
            
            if(resultado.next())
            {
            //    cliente.setId(Integer.parseInt(resultado.getString("id")));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setDni(Integer.parseInt(resultado.getString("dni")));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setCalle(resultado.getString("calle"));
                cliente.setAltura(resultado.getString("altura"));
                cliente.setPisoDto(resultado.getString("pisoDto"));
            }
             
            
      }catch(SQLException ex){
         throw new SQLException(ex);
      } catch (ClassNotFoundException ex) {
           Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
       }
       return unCliente;
     
   }   catch (ClassNotFoundException ex) {
           Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    
    
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
      
      
      