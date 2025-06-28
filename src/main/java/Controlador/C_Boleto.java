
package Controlador;
/**
 *
 * @author Giuss
 */
import Modelo.AsientosViaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;

import Modelo.Boleto;
import Modelo.Viaje;

import Util.Conexion;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class C_Boleto {
    private Conexion mysql;
    private Map<Integer,Boleto> mapBoleto;
    private Map<Integer,Viaje> mapViaje;
    private List<AsientosViaje> listAsientosViaje;
    
    public C_Boleto(HashMap<Integer,Viaje> mapViaje){
        mysql = new Conexion();
        mapBoleto = new HashMap();
        listAsientosViaje = new ArrayList();
        this.mapViaje=mapViaje;
    }
    
    //Insertando un Boleto a la BDD
    public boolean insertarBoleto(Boleto boleto){
        String sql = "call sp_generarBoleto (?,?,?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement ps = connection.prepareCall(sql)){
            ps.setString(1,boleto.getNombre());
            ps.setString(2,boleto.getTipo());
            ps.setInt(3, boleto.getIdAsiento());
            ps.setInt(4,boleto.getViaje().getIdViaje());
            ps.setDouble(5,boleto.costeBoleto());
            if(ps.execute()){
                try (ResultSet rs = ps.getResultSet()){
                    if(rs.next()){
                        boleto.setIdBoleto(rs.getInt(1));
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
    
    //Consultando a la BDD y guarda un Boleto en el HashMap
    public void llenarMapBoleto(){
        String sql = "call sp_llenarBoletos()";
        try(Connection connection = mysql.getConexion();
            CallableStatement ps = connection.prepareCall(sql)){
            
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Boleto boleto = new Boleto();
                    
                    boleto.setIdBoleto(rs.getInt(1));
                    boleto.setNombre(rs.getString(2));
                    boleto.setIndice(rs.getString(3));
                    boleto.setViaje(mapViaje.get(rs.getInt(4)));
                    boleto.setIdAsiento(rs.getInt(5));

                    mapBoleto.put(boleto.getIdBoleto(),boleto);
                }
            }            
        }catch(SQLException e){            
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());            
        }
    }
    
    public void llenarListAsientoViaje(){
        String sql = "call sp_llenarAsientosViaje()";
        try (Connection connection = mysql.getConexion();
             CallableStatement cs = connection.prepareCall(sql)){
            
            try(ResultSet rs = cs.executeQuery()){
                
                while(rs.next()){
                    AsientosViaje asientosViaje = new AsientosViaje();
                    asientosViaje.setIDViaje(rs.getInt(1));
                    asientosViaje.setIDAsiento(rs.getInt(2));
                    
                    listAsientosViaje.add(asientosViaje);
                }
                
            }
 
        } catch (SQLException e) {
            System.out.println("Mensaje :"+e.getMessage());
            System.out.println("Codigo de error :"+e.getErrorCode());
        }
    }
    
    //Actualizando un Boleto en la BDD
    public boolean actualizarBoleto(Boleto boleto){
        String sql = "call sp_actualizarBoleto (?,?,?,?,?,?)";
        try(Connection connection = mysql.getConexion();
            CallableStatement ps = connection.prepareCall(sql)){
            
            ps.setInt(1,boleto.getIdBoleto());
            ps.setString(2,boleto.getNombre());
            ps.setString(3, boleto.getTipo());
            ps.setInt(4,boleto.getIdAsiento());
            ps.setInt(5,boleto.getViaje().getIdViaje());
            ps.setDouble(6, boleto.costeBoleto());
            
            return ps.executeUpdate()==0;
            
        } catch (SQLException e) {           
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error  : "+e.getErrorCode());
            return false;            
        }
    }
    
    //Eliminando un Boleto de la BDD
    public boolean eliminarBoleto(int codigo){
        String sql = "call sp_eliminarBoleto(?)";
        mapBoleto.remove(codigo);
        try(Connection connection = mysql.getConexion();
            CallableStatement ps = connection.prepareCall(sql)){
            
            ps.setInt(1, codigo);
            return ps.executeUpdate()>0;
            
        } catch (SQLException e) {
            System.out.println("Mensaje de error : "+e.getMessage());
            System.out.println("Codigo de error : "+e.getErrorCode());
            return  false;
        }
    }
    
    //Ingresa la tabla con los datos del HashMap
    public void llenarTabla(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Boleto x : mapBoleto.values()) {
            Object [] datos = {x.getIdBoleto(),
                               x.getNombre(),
                               x.getIdAsiento(),
                               x.getViaje().getIdViaje(),
                               String.format("%.1f",x.costeBoleto())};            
            dt.addRow(datos);
        }
    }
    
    public void llenarViajexBoleto(JTable tabla,int IdViaje){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Boleto x : mapBoleto.values()) {
            if(x.getViaje().getIdViaje() == IdViaje){
                Object [] datos = {x.getIdBoleto(),
                               x.getNombre(),
                               x.getTipo(),
                               x.getIdAsiento()};            
                dt.addRow(datos);
            }
        }
    }
    
    public void llenarTablaViajeRuta(JTable tabla){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);        
        for (Boleto x : mapBoleto.values()) {
            Object [] datos = {x.getIdBoleto(),
                               x.getNombre(),
                               x.getTipo(),
                               x.getIdAsiento()};            
            dt.addRow(datos);
        }
    }
    
    public void eliminarFilaTablaBoleto(JTable tabla, int fila){
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.removeRow(fila);
    }
    
    public void eliminarMapBoleto(int IdBoleto){
        mapBoleto.remove(IdBoleto);
    }
    
    public void habilitarAsientoSeleccionado(int idViaje, int idAsiento){
        listAsientosViaje.removeIf(x -> x.getIDViaje() == idViaje && x.getIDAsiento() == idAsiento);
    }
    
    //Ingresa un solo Boleto a la tabla
    public void insertarTabla(JTable tabla,Boleto boleto){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        Object [] datos = {boleto.getIdBoleto(),
                               boleto.getNombre(),
                               boleto.getIdAsiento(),
                               boleto.getViaje().getIdViaje(),
                               String.format("%.1f",boleto.costeBoleto())};
        dt.addRow(datos);        
    }
    
    public void habilitarAsientos(JButton[] asientos,boolean validacion){
        for (JButton asiento : asientos) {
            asiento.setEnabled(validacion);
        }
    }
    
    public void llamarAsientosDeViaje(JButton[] asientos,int IDViaje){
        
        List<Integer> AsientosFiltrados = new ArrayList<>();
        for (AsientosViaje asiento : listAsientosViaje) {
            if (asiento.getIDViaje() == IDViaje) {
                AsientosFiltrados.add(asiento.getIDAsiento());
            }
        }               
           
        for (JButton asiento : asientos) {
            asiento.setBackground(Color.WHITE);
            asiento.setForeground(Color.BLACK);
    
            int asientoId = Integer.parseInt(asiento.getText());
            if (AsientosFiltrados.contains(asientoId)) {
                asiento.setBackground(new Color(190, 0, 0));
                asiento.setForeground(Color.WHITE);
            }
        }

    }
    
    //Inserta un nuevo Boleto al HashMap
    public void insertarMapBoleto(Boleto boleto){
        mapBoleto.put(boleto.getIdBoleto(),boleto);
    }
    
    public void insertarListAsientoViaje(AsientosViaje asientoViaje){
        listAsientosViaje.add(asientoViaje);
        
    }
    
    //Busca un Boleta en el HashMap
    public Boleto buscarBoleto(int codigo){     
        return mapBoleto.get(codigo);        
    }
    
}
