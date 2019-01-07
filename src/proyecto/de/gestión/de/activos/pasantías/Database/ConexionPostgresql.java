/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.de.gestión.de.activos.pasantías.Database;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author JUNIORCEDE
 */
public class ConexionPostgresql {
    private static Connection conexionBD;
    public static Connection getConexion() {
        return conexionBD;
    }       
    public void setConexion(Connection conexionBD) {
        this.conexionBD = conexionBD;
    }
    public ConexionPostgresql conectar() {
        try {
          Class.forName("org.postgresql.Driver");// carga el driver y oracle 
         String BaseDeDatos = "jdbc:postgresql://localhost:5432/gestionActivos?autoReconnect=true&relaxAutoCommit=true"; //crea una variable con la direccion el puerto y la instancia (express)
         conexionBD = DriverManager.getConnection(BaseDeDatos, "postgres","12345");  // carga la conexion (usuario contraseña)
         if (conexionBD != null) {
            //JOptionPane.showMessageDialog(null, "Conectado a la base de datos Postresql!");
            //System.out.println("Conectado a la base de datos Postresql!");
         } else {
             JOptionPane.showMessageDialog(null, "Error en la Conexión !");
         }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "PostgreSQL "+ e.getMessage());
        }
        return this;
    }
    
    public boolean ejecutar(String sql) { //
        System.out.println(sql);
        try {
            Statement sentencia; // objetos para sentencias de oracle 
            getConexion().setAutoCommit(false);
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeUpdate(sql); //ejecuta el insert delete y el updte
            getConexion().commit();
        } catch (SQLException e) {
            if (e.getErrorCode()==0) return false; //Por error "Cannot commit when autocommit is enabled"
            JOptionPane.showMessageDialog(null, e.getErrorCode());
            return false;
        }        
        return true;
    }
    public  static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error de Conexion",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
