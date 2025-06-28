
package Controlador;

/**
 *
 * @author RODRIGO
 */
public class C_Controlador {
    
    public C_Chofer cChofer;
    public C_Ruta cRuta;
    public C_Bus cBus;
    public C_Viaje cViaje;
    public C_Boleto cBoleto;
    
    public C_Controlador(){
        cChofer = new C_Chofer();
        cRuta = new C_Ruta();
        cBus = new C_Bus(cChofer.getMapChofer());
        cViaje = new C_Viaje(cBus.getMapBus(), cRuta.getMapRuta());
        cBoleto = new C_Boleto(cViaje.getMapViaje());
    }
    
    
    
}
