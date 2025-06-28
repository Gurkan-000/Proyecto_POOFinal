
package Controlador;

/**
 *
 * @author Giuss
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;

import Modelo.Bus;
import Modelo.Chofer;

import Util.Conexion;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C_Bus {
    private Conexion mysql;
    private Map<Integer,Bus> mapBus;
    private Map<Integer,Chofer> mapChofer;
    
    public C_Bus(HashMap<Integer,Chofer> mapChofer){
        mysql = new Conexion();
        mapBus = new HashMap();
        this.mapChofer=mapChofer;
    }
    
    //Insertando un Bus a la BDD
    public boolean insertarBus(Bus bus){
        String sql = "call sp_generarBus(?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            cs.setInt(1,bus.getChofer().getIdChofer());
            if(cs.execute()){
                try (ResultSet rs = cs.getResultSet()){
                    if(rs.next()){
                        bus.setIdBus(rs.getInt(1));
                    }
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());
            return false;
        }
    }
    
    //Consulta a la BDD y guarda un Bus en el HashMap
    public void llenarMapBus(){
        String sql = "call sp_llenarBuses()";
        
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            try (ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    Bus bus = new Bus();
                    
                    bus.setIdBus(rs.getInt(1));
                    bus.setChofer(mapChofer.get(rs.getInt(2)));
                    
                    mapBus.put(bus.getIdBus(),bus);  
                }
            }            
        }catch(SQLException e){
            
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());            
        }
    }
    
    //Actualzando un Bus en la BDD
    public boolean actualizarBus(Bus bus){
        String sql = "call sp_actualizarBus (?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            cs.setInt(1,bus.getIdBus());
            cs.setInt(2,bus.getChofer().getIdChofer());
            
            return cs.executeUpdate()>0;
            
        } catch (SQLException e) {           
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());
            return false;            
        }
    }
    
    //Eliminando un Bus de la BDD
    public boolean eliminarBus(int codigo){
        String sql = "call sp_eliminarBus(?)";
        mapBus.remove(codigo);
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            cs.setInt(1, codigo);
            return cs.executeUpdate()>0;
            
        } catch (SQLException e) {
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error : "+e.getErrorCode());
            return  false;
        }
    }
    
    //Llenando la tabla con los datos del HashMap
    public void llenarTabla(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0); 

        for (Bus x : mapBus.values()) {
            Object[] datos = new Object[2]; 

            if (x.getChofer() == null) {
                datos[0] = x.getIdBus();   
                datos[1] = "null";            
            } else {
                datos[0] = x.getIdBus();
                datos[1] = x.getChofer().getNombre();
            }
            dt.addRow(datos);
        }
    }
    
    //Este metodo se usa para llenar la tabla de bus de panel_infoViaje
    public void llenarTablaInfoViaje(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0); 

        for (Bus x : mapBus.values()) {
            Object[] datos = new Object[2]; 

            if (x.getChofer() != null) {
                datos[0] = x.getIdBus();
                datos[1] = x.getChofer().getNombre();      
                dt.addRow(datos);
            } 

        }
    }
    
    //Llena el map para solo obtener el chofer por id y llenar la tabla consulta
    public void llenarTablaBusxChofer(JTable tabla,int IDChofer) {
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);
        
        for(Bus x : mapBus.values()){
            
            if(x.getChofer() != null){
                if(x.getChofer().getIdChofer() == IDChofer){
                    Object [] datos = {x.getIdBus(),
                                    x.getChofer().getNombre()};
                    dt.addRow(datos);
                }
            }
    
        }
    }
    
    //Ingresa un solo Bus a la tabla
    public void insertarTabla(JTable tabla,Bus bus){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        Object [] datos = {bus.getIdBus(),
                           bus.getChofer().getNombre()};
        dt.addRow(datos);        
    }
    
    //Eliminar fila de la tabla chofer
    public void eliminarFilaTablaBus(JTable tabla,int fila){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        dt.removeRow(fila);        
    }
    
    //Cuando eliminamos a un chofer tambien hay que borrarlo dentro del mapBus
    public void eliminarChoferMapBus(int IDChofer){
        for(Bus x : mapBus.values()){
            if(x.getChofer() != null){
                if(x.getChofer().getIdChofer() == IDChofer){
                    x.setChofer(null);
                }
            }
        }
    }
    
    //Inserta un nuevo Bus al HashMap
    public void insertarMapBus(Bus bus){
        mapBus.put(bus.getIdBus(),bus);
    }
    
    //Busca un Bus en el HashMap
    public Bus buscarMapBus(int codigo){     
        return mapBus.get(codigo);        
    }
    
    //Eliminar un Chofer en el HashMap
    public void eliminarMapBus(int codigo){
        mapBus.remove(codigo);
    }
    
    public HashMap<Integer,Bus> getMapBus(){
        return (HashMap)mapBus;
    }
    
}
