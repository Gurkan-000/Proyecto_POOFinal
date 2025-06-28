
package Modelo;

/**
 *
 * @author JOSE
 */
public class Bus {
    /*acá un int de idBus y un int de idChofer*/
    private int idBus;
    private Chofer chofer;
    
    public Bus(){
        chofer = new Chofer();
    }
    
    public Bus(int idBus, Chofer chofer) {
        this.idBus = idBus;
        this.chofer = chofer;
    }

    // Getters
    public int getIdBus() {
        return idBus;
    }
    
    public Chofer getChofer() {
        return chofer;
    }
    
    // Setters
    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
}
