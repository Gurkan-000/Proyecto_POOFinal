
package Modelo;

/**
 *
 * @author JOSE
 */
public class Chofer {
    /*acá un int de idChofer, string de nombre, int de categoria, string[profesional, semiProfesional] estaCategoria
    double pago que variará en función del tipo de chofer, 100% de pago para el profesional y 80% para el semi
    */
    private int idChofer;
    private String nombre;
    private String[] categorias = {"Profesional", "Semiprofesional"}; // 0 = profesional, 1 = semiProfesional
    private double[] factoresPago = {1.0, 0.8}; // 100% y 80%
    private int indice;
    private String fechaIngreso;

    public Chofer() {
    }
    
    public Chofer(int idChofer, String nombre, int indice, String fechaIngreso) {
        this.idChofer = idChofer;
        this.nombre = nombre;
        this.indice = indice;
        this.fechaIngreso = fechaIngreso;
    }
    
    // Getters
    public int getIdChofer() { return idChofer; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categorias[indice];}
    public double getPago() { return factoresPago[indice]; }
    public String getFechaIngreso() { return fechaIngreso; }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setIdChofer(int idChofer) {
        this.idChofer = idChofer;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public void setIndice(String categoria){ 
        this.indice = (categoria.toLowerCase().equals("profesional"))? 0 : 1;
    }
    
    @Override
    public String toString(){
        return String.format("%d %s", idChofer,nombre);
    }
    
}
