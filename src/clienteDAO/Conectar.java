
package clienteDAO;
 
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Charlie
 */
public class Conectar {
    Connection conect = null;
    public Connection conexion()
        {
            try {
                //Cargamos el Driver MySQL
                Class.forName("com.mysql.jdbc.Driver");
                //Class.forName("org.gjt.mm.mysql.Driver");
                conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/basecliente","root","");
                System.out.println("conexion establecida");
                JOptionPane.showMessageDialog(null,"Conectado");
               
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("error de conexion");
                JOptionPane.showMessageDialog(null,"Error de conexion"+e);
            }
            return conect;
        }
     
}