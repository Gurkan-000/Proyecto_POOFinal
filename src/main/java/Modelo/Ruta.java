
package Modelo;

/**
 *
 * @author Giuss
 */
public class Ruta {
    
    private int idRuta;
    private String nombre;
    private double coste;
    private double pagoChof;
    
    public Ruta() {
    }

    public Ruta(int idRuta, double coste, double pagoChof, String nombre) {
        this.idRuta = idRuta;
        this.coste = coste;
        this.pagoChof = pagoChof;
        this.nombre = nombre;
    }

    //Getters
    public int getIdRuta() {
        return idRuta;
    }

    public double getCoste() {
        return coste;
    }

    public double getPagoChof() {
        return coste*0.4;
    }

    public String getNombre() {
        return nombre;
    }
    
    //Setters opcionales
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
