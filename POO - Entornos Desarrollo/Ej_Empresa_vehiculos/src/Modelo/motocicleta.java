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


    /**
     * En el caso de las motocicletas, si tienen una cilindrada mayor o igual a 250 y tienen
     * menos de 4 años, se le añadirá el PLUS al precio
     *
     * @return precio + plus o 0
     */
    public void plus(){
        if (getAños()<=4 && ciclidrada >= 120){
            plus = (int) (precio + 250);
        }
        else
            plus = 0;
    }

    @Override
    public String toString() {
        return "motocicleta{" + "\n" +
                "ciclidrada=" + ciclidrada + "\n" +
                ", marca='" + marca + "\n" +
                ", años=" + años + "\n" +
                ", precio=" + precio + "\n" +
                ", color='" + color + "\n" +
                ", plus=" + (precio + plus) + "\n" +
                '}';
    }
}
