
package Modelo;

/**
 *
 * @author RODRIGO
 */

public class Viaje {
    
    private int idViaje;
    private String fecha;
    private String hora; 
    private Bus bus;
    private Ruta ruta;
    private int asientosDispo;

    public Viaje() {
        bus = new Bus();
        ruta = new Ruta();
    }

    public Viaje(int idViaje, String fecha, String hora, Bus bus, Ruta ruta, int asientoDispo) {
        this.idViaje = idViaje;
        this.fecha = fecha;
        this.hora = hora;
        this.bus = bus;
        this.ruta = ruta;
        this.asientosDispo = asientoDispo;
    }

    // Getters
    public int getIdViaje() { return idViaje; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Bus getBus() { return bus; }
    public int getAsientosDispo() { return asientosDispo; }
    public Ruta getRuta() { return ruta; }

    // Setters
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setAsientosDispo(int asientosDispo) {
        this.asientosDispo = asientosDispo;
    }
    
    public double pagoChofer(){
        return bus.getChofer().getPago()*ruta.getPagoChof();
    }
    
    
}
