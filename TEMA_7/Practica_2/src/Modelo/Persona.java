package Modelo;

public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private String curso;

    //Constructor:

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public Persona(String nombre, String apellidos, String dni, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.curso = curso;
    }

    //set y get:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    //toString:

    @Override
    public String toString() {
        return "Nombre = " + nombre + "\n" +
                "Apellidos = " + apellidos + "\n" +
                "DNI = " + dni + "\n" +
                "Curso = " + curso + "\n";
    }
}
