package Modelo;

public class Productos {
    private String nombre;
    private double precio;

    //Constructor:

    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //get y set:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return (float) precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular() {
        double calcular = getPrecio();
        return calcular;
    }
}
