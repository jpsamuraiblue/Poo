/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author tpp
 */
import java.sql.*;

public class ConexionSingleton {

    //crear una variable estatica
    public static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
              Runtime.getRuntime().addShutdownHook(new getClose());
               Class.forName("com.mysql.cj.jdbc.Driver");
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "admin");

               
                System.out.println("Entro a la conexion");
                
               
               
            }
            return connection;
            //return

        } catch (ClassNotFoundException | SQLException e) {
        throw new RuntimeException("conexion fallida", e);
        
        }
        
    }
    static class getClose extends Thread {
        @Override
        public void run() {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Conexion a la base de datos ingresada");
                }
            } catch (SQLException ex) {
                throw new RuntimeException("No se pudo cerrar la conexión", ex);
            }
        

        }
        
    }

}
