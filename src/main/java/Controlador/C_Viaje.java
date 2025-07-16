
package Controlador;

/**
 *
 * @author Giuss
 */


import Modelo.Bus;
import Modelo.Ruta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;

import Modelo.Viaje;
import Util.Conexion;
import Util.FechasHora;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C_Viaje {
    private Conexion mysql;
    
    private Map<Integer,Viaje> mapViaje;
    private Map<Integer,Bus> mapBus;
    private Map<Integer,Ruta> mapRuta;
    
    public C_Viaje(HashMap<Integer,Bus>mapBus, HashMap<Integer,Ruta>mapRuta){
        mysql = new Conexion();
        mapViaje = new HashMap();
        this.mapBus = mapBus;
        this.mapRuta = mapRuta;
    }
    
    //Insertando un Viaje a la BDD
    public boolean insertarViaje(Viaje viaje){
        String sql = "call sp_generarViaje (?,?,?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
          
            cs.setString(1,viaje.getFecha());
            cs.setString(2,viaje.getHora());
            cs.setInt(3,viaje.getBus().getIdBus());
            cs.setDouble(4, viaje.pagoChofer());
            cs.setInt(5,viaje.getRuta().getIdRuta());
            if(cs.execute()){
                try (ResultSet rs = cs.getResultSet()){
                    if(rs.next()){
                        viaje.setIdViaje(rs.getInt(1));
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
    
    //Consultando a la BDD y guarda un Viaje en el HashMap
    public void llenarMapViaje(){
        String sql = "call sp_llenarViajes()";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            try (ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    Viaje viaje = new Viaje();
                    
                    viaje.setIdViaje(rs.getInt(1));
                    viaje.setFecha(rs.getString(2));
                    viaje.setHora(rs.getString(3));
                    viaje.setBus(mapBus.get(rs.getInt(4)));
                    viaje.setAsientosDispo(rs.getInt(5));
                    viaje.setRuta(mapRuta.get(rs.getInt(6)));

                    mapViaje.put(viaje.getIdViaje(),viaje);
                }
            }            
        }catch(SQLException e){            
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());            
        }
    }
    
    //Actualizando un Viaje en la BDD
    public boolean actualizarViaje(Viaje viaje){
        String sql = "call sp_actualizarViaje (?,?,?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            cs.setInt(1,viaje.getIdViaje());
            cs.setObject(2,viaje.getFecha());
            cs.setObject(3,viaje.getHora());
            cs.setInt(4,viaje.getBus().getIdBus());
            cs.setInt(5,viaje.getRuta().getIdRuta());
            
            return cs.executeUpdate()>0;
            
        } catch (SQLException e) {           
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());
            return false;            
        }
    }
    
    
    //Eliminando un Viaje de la BDD
    public boolean eliminarViaje(int codigo){
        String sql = "call sp_eliminarViaje(?)";
        mapViaje.remove(codigo);
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
        for (Viaje x : mapViaje.values()) {
            Object [] datos = new Object[4];
            
            datos[0]=x.getIdViaje();
            datos[1]=x.getRuta().getNombre();
            datos[2]=x.getFecha();
            datos[3]=FechasHora.parseHora(x.getHora());

            dt.addRow(datos);
        }
    }
    
    //Esta tabla se usa en panel_consultaChofer
    public void llenarTablaChoferViajes(JTable tabla,int idChofer){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Viaje x : mapViaje.values()) {
            if(x.getBus().getChofer().getIdChofer() == idChofer){
                Object [] datos = {x.getIdViaje(),
                                   x.getFecha(),
                                   x.getRuta().getNombre(),
                                   x.pagoChofer()};
            
                dt.addRow(datos);
            }

        }
    }
    
    public void llenarTablaViajeRuta(JTable tabla,String ruta){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Viaje x : mapViaje.values()) {
            if (x.getRuta().getNombre().equals(ruta)) {
                Object[] fila = new Object[] {
                    x.getIdViaje(),
                    x.getFecha(),
                    FechasHora.parseHora(x.getHora())
                };
                dt.addRow(fila);
            }
        }
    }
    
    public void eliminarMapViaje(int idViaje){
        mapViaje.remove(idViaje);
    }
    
    public void eliminarFilaTablaViaje(JTable tabla, int fila){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.removeRow(fila);
    }
    
    //Ingresando un solo Viaje a la tabla
    public void insertarTabla(JTable tabla,Viaje viaje){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        Object [] datos = {viaje.getIdViaje(),
                           viaje.getRuta().getNombre(),
                           viaje.getFecha(),
                           FechasHora.parseHora(viaje.getHora())};
        dt.addRow(datos);        
    }
    
    //Insertando un nuevo Viaje al HashMap
    public void insertarMapViaje(Viaje viaje){
        mapViaje.put(viaje.getIdViaje(),viaje);
    }
    
    //Busca un Viaje en el HashMap
    public Viaje buscarViaje(int codigo){     
        return mapViaje.get(codigo);        
    }
    
    public boolean existeBusesAsignados(int idBus){
        for(Viaje x : mapViaje.values()){
            if(x.getBus().getIdBus() == idBus){
                return true;
            }
        }
        return false;
    }
    
    public HashMap<Integer,Viaje> getMapViaje(){
        return (HashMap)mapViaje;
    }
    
}
