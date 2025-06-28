
package Controlador;

/**
 *
 * @author Giuss
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;

import Modelo.Chofer;
import Util.Conexion;

import java.util.Map;
import java.util.HashMap;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C_Chofer {
    private Conexion mysql;
    private Map<Integer,Chofer> mapChofer;
    
    public C_Chofer(){
        mysql = new Conexion();
        mapChofer = new HashMap();
    }
    
    //Insertando un Chofer a la BDD
    public boolean insertarChofer(Chofer chofer){
        String sql = "call sp_generarChofer (?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            cs.setString(1,chofer.getNombre());
            cs.setString(2, String.valueOf(chofer.getCategoria()));
            cs.setString(3,chofer.getFechaIngreso());
            if(cs.execute()){
                try (ResultSet rs = cs.getResultSet()){
                    if(rs.next()){
                        chofer.setIdChofer(rs.getInt(1));
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
    
    //Conulta la BDD y guarda un Chofer en el HashMap
    public void llenarMapChofer(){
        String sql = "call sp_llenarChoferes()";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            try (ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    Chofer chofer = new Chofer();
                    
                    chofer.setIdChofer(rs.getInt(1));
                    chofer.setNombre(rs.getString(2));
                    chofer.setIndice(rs.getString(3));
                    chofer.setFechaIngreso(rs.getString(4));

                    mapChofer.put(chofer.getIdChofer(),chofer);
                }
            }            
        }catch(SQLException e){            
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());            
        }
    }
    
    //Actualizando un Chofer en la BDD
    public boolean actualizarChofer(Chofer chofer){
        String sql = "call sp_actualizarChofer (?,?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement cs = connection.prepareCall(sql)){
            
            cs.setInt(1,chofer.getIdChofer());
            cs.setString(2,chofer.getNombre());
            cs.setString(3,chofer.getCategoria());
            cs.setString(4,chofer.getFechaIngreso());
            
            return cs.executeUpdate()>0;
            
        } catch (SQLException e) {           
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());
            return false;            
        }
    }
    
    
    //Eliminando un Chofer de la BDD
    public boolean eliminarChofer(int codigo){
        String sql = "call sp_eliminarChofer(?)";
        mapChofer.remove(codigo);
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
    
    //Ingresa a la tabla los datos del HashMap
    public void llenarTabla(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Chofer x : mapChofer.values()) {
            Object [] datos = {x.getIdChofer(),
                               x.getNombre(),
                               x.getCategoria(),
                               x.getFechaIngreso()};            
            dt.addRow(datos);
        }
    }
    
    public void llenarTablaChoferInfoBus(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Chofer x : mapChofer.values()) {
            Object [] datos = {x.getIdChofer(),
                               x.getNombre(),
                               x.getCategoria()};            
            dt.addRow(datos);
        }
    }
    
    public void llenarTablaChoferInfoBusFiltro(JTable tabla,String tipo){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Chofer x : mapChofer.values()) {
            if(x.getCategoria().equals(tipo)){
                Object [] datos = {x.getIdChofer(),
                                   x.getNombre(),
                                   x.getCategoria()};            
                dt.addRow(datos);
            }
        }
    }
    
    //Llenando el ComboBox de Chofer
    public void llenarComboChofer(JComboBox<Object> cbxChofer){
        cbxChofer.removeAllItems();
        cbxChofer.addItem("-- Eleja un chofer --");
        for(Chofer x:mapChofer.values()){
            
            cbxChofer.addItem(x);
        }
        
    }
    
    //Ingresa un solo Chofer a la tabla
    public void insertarTabla(JTable tabla,Chofer chofer){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        Object [] datos = {chofer.getIdChofer(),
                           chofer.getNombre(),
                           chofer.getCategoria(),
                           chofer.getFechaIngreso()};
        dt.addRow(datos);        
    }
    
    //Eliminar fila de la tabla chofer
    public void eliminarFilaTablaChofer(JTable tabla,int fila){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        dt.removeRow(fila);        
    }
    
    //Inserta un nuevo Chofer al HashMap
    public void insertarMapChofer(Chofer chofer){
        mapChofer.put(chofer.getIdChofer(),chofer);
    }
    
    //Busca un Chofer en el HashMap
    public Chofer buscarMapChofer(int codigo){     
        return mapChofer.get(codigo);        
    }
    
    //Eliminar un Chofer en el HashMap
    public void eliminarMapChofer(int codigo){
        mapChofer.remove(codigo);
    }
    
    
    
    public HashMap<Integer,Chofer> getMapChofer(){
        return (HashMap)mapChofer;
    }
    
}
