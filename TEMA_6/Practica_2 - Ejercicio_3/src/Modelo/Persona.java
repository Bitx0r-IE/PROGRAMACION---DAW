package Modelo;

public class Persona {
    private String nombre;
    private int edad;

    //Constructor:

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Set y get

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //to String es lo mismo:
    public String mostrar(){
        return this.nombre + " " + this.edad;
    }

}
