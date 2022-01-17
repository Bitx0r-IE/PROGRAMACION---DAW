package Modelo;

public class Veterinario extends Persona{
    private String dni;
    private int numSegSocial;

    //Constructor:

    public Veterinario(String nombre, String direccion, int telefono, String dni, int numSegSocial) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.numSegSocial = numSegSocial;
    }

    //get y set:
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(int numSegSocial) {
        this.numSegSocial = numSegSocial;
    }
}
