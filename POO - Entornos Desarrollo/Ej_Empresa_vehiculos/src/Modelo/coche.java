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
    public coche(String marca, int años, double precio, String color, boolean hibrido) {
        super(marca, años, precio, color);
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
     * @return true o false
     */
    public boolean plus (){
        if (getAños() < 5 && hibrido == true){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "coche{" + "\n" +
                "hibrido=" + hibrido + "\n" +
                ", marca='" + marca + "\n" +
                ", años=" + años + "\n" +
                ", precio=" + precio + "\n" +
                ", color='" + color + "\n" +
                ", plus=" + plus + "\n" +
                '}';
    }
}
