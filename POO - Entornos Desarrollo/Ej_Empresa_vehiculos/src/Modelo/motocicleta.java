package Modelo;

/**
 *clase hija motocicleta
 *
 * @author Victor Ibañez
 * @version 18/03/2022
 */
public class motocicleta extends vehiculos{
    private double ciclidrada;

    //Constructor:
    public motocicleta(String marca, int años, double precio, String color, double ciclidrada) {
        super(marca, años, precio, color);
        this.ciclidrada = ciclidrada;
    }

    public double getCiclidrada() {
        return ciclidrada;
    }

    public void setCiclidrada(double ciclidrada) {
        this.ciclidrada = ciclidrada;
    }

    /**
     * En el caso de las motocicletas, si tienen una cilindrada mayor o igual a 250 y tienen
     * menos de 4 años, se le añadirá el PLUS al precio
     *
     * @return true o false
     */
    public boolean plus(){
        if (getAños()<=4 && getCiclidrada){
            return true;
        }
        return false;
    }



}
