package Modelo;

/**
 *clase hija motocicleta
 *
 * @author Victor Ibañez
 * @version 18/03/2022
 */
public class motocicleta extends vehiculos{
    private double cilindrada;

    //Constructor:
    public motocicleta(String marca, int age, double precio, String color, double cilindrada) {
        super(marca, age, precio, color);
        this.cilindrada = cilindrada;
    }


    /**
     * En el caso de las motocicletas, si tienen una cilindrada mayor o igual a 250 y tienen
     * menos de 4 años, se le añadirá el PLUS al precio
     *Devuelve el precio +  plus o 0 en caso de que no se aplique el plus
     *
     * @author Victor Ibañez
     * @version 25/03/2022
     */
    public void plus(){
        if (getAge()<=4 && cilindrada >= 120){
            plus = (int) (precio + 250);
        }
        else
            plus = 0;
    }

    @Override
    public String toString() {
        return "motocicleta{" + "\n" +
                "ciclidrada=" + cilindrada + "\n" +
                ", marca='" + marca + "\n" +
                ", años=" + age + "\n" +
                ", precio=" + precio + "\n" +
                ", color='" + color + "\n" +
                ", plus=" + (precio + plus) + "\n" +
                '}';
    }
}
