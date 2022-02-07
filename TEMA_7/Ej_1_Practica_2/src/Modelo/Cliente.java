package Modelo;

public class Cliente {
    private String nombre;

    //Constructor:

    public Cliente(String nombre) {
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
