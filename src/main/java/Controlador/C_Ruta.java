
package Controlador;

/**
 *
 * @author Giuss
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;

import Modelo.Ruta;
import Util.Conexion;

import java.util.Map;
import java.util.HashMap;
import javax.swing.JComboBox;


public class C_Ruta {
    private Conexion mysql;
    private Map<Integer,Ruta> mapRuta;
    
    public C_Ruta(){
        mysql = new Conexion();
        mapRuta = new HashMap();
    }
    //Consultando a la BDD y guarda una Ruta en el HashMap
    public void llenarMapRuta(){
        String sql = "call sp_llenarRutas()";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            try (ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    Ruta ruta = new Ruta();
                    
                    ruta.setIdRuta(rs.getInt(1));
                    ruta.setCoste(rs.getDouble(2));
                    ruta.setNombre(rs.getString(3));
                    
                    mapRuta.put(ruta.getIdRuta(),ruta);
                }
            }            
        }catch(SQLException e){            
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());            
        }
    }
    
    //Llenando el ComboBox de Ruta
    public void llenarComboBox(JComboBox<Object> cbRuta){
        cbRuta.addItem("-- Selecciona una ruta --");
        for(Ruta x : mapRuta.values()){
            cbRuta.addItem(x);
        }
    }
    
    //Insertando una nueva Ruta al HashMap
    public void insertarMapRuta(Ruta ruta){
        mapRuta.put(ruta.getIdRuta(),ruta);
    }
    
    //Busca una Ruta en el HashMap
    public Ruta buscarRuta(int codigo){     
        return mapRuta.get(codigo);        
    }
    
    public HashMap<Integer,Ruta> getMapRuta(){
        return (HashMap)mapRuta;
    }
    
}
