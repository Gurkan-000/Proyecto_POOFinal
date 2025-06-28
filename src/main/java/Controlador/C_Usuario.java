
package Controlador;

/**
 *
 * @author RODRIGO
 */

import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.*;
import java.sql.SQLException;


public class C_Usuario {
    
    private Conexion conexion;
    
    public C_Usuario(){
        conexion = new Conexion();
    }
    
    public boolean buscarUsuario(Usuario usuario){
        
        String sql = "select Usuario,Contraseña from Usuario where Usuario=? and Contraseña=?";
        
        try (Connection connection = conexion.getConexion();
              PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }    
        }catch(SQLException e){
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error : "+e.getErrorCode());
            return false;
        }        
    }     
}
