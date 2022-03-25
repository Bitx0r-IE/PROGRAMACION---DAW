package Modelo;

/**
 *clase padre vehiculos
 *
 * @author Victor Ibañez
 * @version 18/03/2022
 */
public abstract class vehiculos {
    public String marca;
    public int age;
    public double precio;
    public String color;

    public int plus;

    //Constructor:
    public vehiculos(String marca, int age, double precio, String color) {
        this.marca = marca;
        this.age = age;
        this.precio = precio;
        this.color = color;
    }

    /**
     *Generación de setters y getter
     *
     * @return atributos del objeto vehiculos
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", años=" + age +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                '}';
    }

}
