package Modelo;

public class Cliente extends Persona{
    private int telefono;

    //Constructor:

    public Cliente(String nombre, int edad, int telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }
}
