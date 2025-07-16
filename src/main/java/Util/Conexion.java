
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private final String URL="jdbc:mysql://localhost:3306/bddAgenciaViajes";
    private final String Usuario="root";
    private final String Contraseña="hololive"; 
    
    private Connection connection = null;
    
    public Connection getConexion(){
        try{
            
            connection = DriverManager.getConnection(URL, Usuario, Contraseña);
        
            return connection;          
        }catch(SQLException e){
            
            System.out.println("Error  : "+e.getMessage());
            System.out.println("Codigo : "+e.getErrorCode());
            
            return null;            
        }
    }
    
}
