package Modelo;

public class Veterinario extends Persona{
    private String dni;
    private String numSegSocial;

    //Constructor:

    public Veterinario(String nombre, String direccion, String telefono, String dni, String numSegSocial) {
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

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(String numSegSocial) {
        this.numSegSocial = numSegSocial;
    }
}
