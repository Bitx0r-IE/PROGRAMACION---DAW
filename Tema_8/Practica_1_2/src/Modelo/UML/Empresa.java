package Modelo.UML;

public class Empresa {
    private String nombre;
    private String loc;

    //Constructor:

    public Empresa() {
    }

    public Empresa(String nombre, String loc) {
        this.nombre = nombre;
        this.loc = loc;
    }

    //get y set:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
