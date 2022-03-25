package Modelo;

/**
 *clase hija coche
 *
 * @author Victor Ibañez
 * @version 18/03/2022
 */
public class coche extends vehiculos{
    private boolean hibrido;

    //Constructor:
    public coche(String marca, int age, double precio, String color, boolean hibrido) {
        super(marca, age, precio, color);
        this.hibrido = hibrido;
    }

    public boolean isHibrido() {
        return hibrido;
    }

    public void setHibrido(boolean hibrido) {
        this.hibrido = hibrido;
    }

    /**
     * En el caso de los coches, si es híbrido (True) y tiene menos de 5 años, se le añadirá el
     * PLUS al precio.
     *
     */
    public void plus(){
        if (getAge() < 5 && hibrido == true){
            plus = (int) (precio + 250);
        }
        else
            plus = 0;
    }

    @Override
    public String toString() {
        return "coche{" + "\n" +
                "hibrido=" + hibrido + "\n" +
                ", marca='" + marca + "\n" +
                ", años=" + age + "\n" +
                ", precio=" + precio + "\n" +
                ", color='" + color + "\n" +
                ", plus=" + plus + "\n" +
                '}';
    }
}
