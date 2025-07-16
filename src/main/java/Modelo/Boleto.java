
package Modelo;
/**
 *
 * @author RODRIGO
 */
public class Boleto {   
    /*en boletos, int de idBoleto, string de nombre, int de idAsiento, int de 
    idViaje, ,int de tipo, string[adulto, niño, estudiante] esteTipo, un double coste, que variará en función del
    tipo(adulto, niño o estudiante)*/
    private int idBoleto;
    private String nombre;
    private int idAsiento;
    private Viaje viaje;
    private int indice; // 0 = Niño, 1 = Estudiante, 2 = Adulto

    private String[] tipos = {"Niño", "Estudiante", "Adulto"};
    private double[] costes = {0.5, 0.7, 1};

    public Boleto() {
        viaje = new Viaje();
    }
    
    public Boleto(int idBoleto, String nombre, int idAsiento, Viaje viaje, int indice) {
        this.idBoleto = idBoleto;
        this.nombre = nombre;
        this.idAsiento = idAsiento;
        this.viaje = viaje;
        this.indice = indice;
    }

    public int getIdBoleto() { 
        return idBoleto; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public int getIdAsiento() { 
        return idAsiento; 
    }
    public Viaje getViaje() { 
        return viaje; 
    }
    public String getTipo() { 
        return tipos[indice]; 
    }
    public int getIndice() { 
        return indice; 
    }
    public double getCoste() { 
        return costes[indice]; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }
    
    public void setIndice(String tipo){
        
        this.indice = (tipo.toLowerCase().equals("adulto"))? 2 : ((tipo.toLowerCase().equals("niño"))? 0 : 1);
    }
    
    public double costeBoleto(){
        return costes[indice]*viaje.getRuta().getCoste();
    }
    
}
