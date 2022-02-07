package Modelo;

public class Proveedor {
    private String nombre;

    //Constructor:

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    //set y get:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
