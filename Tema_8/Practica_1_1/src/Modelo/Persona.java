package Modelo;

public class Persona {
    String nombre;
    int edad;
    String profesion;
    int telefono;

    //Constructor:

    public Persona(String nombre, int edad, String profesion, int telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    //get y set:

    public String getNombre() {
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
