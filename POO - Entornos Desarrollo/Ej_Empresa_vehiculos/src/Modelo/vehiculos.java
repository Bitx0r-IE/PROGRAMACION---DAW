package Modelo;

/**
 *clase padre vehiculos
 *
 * @author Victor Ibañez
 * @version 18/03/2022
 */
public abstract class vehiculos {
    public String marca;
    public int años;
    public double precio;
    public String color;

    public int plus;

    //Constructor:
    public vehiculos(String marca, int años, double precio, String color) {
        this.marca = marca;
        this.años = años;
        this.precio = precio;
        this.color = color;
    }

    /**
     *Geenración de setters y getter
     *
     * @return atributos del objeto vehiculos
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "vehiculos{" +
                "marca='" + marca + '\'' +
                ", años=" + años +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                '}';
    }

}
