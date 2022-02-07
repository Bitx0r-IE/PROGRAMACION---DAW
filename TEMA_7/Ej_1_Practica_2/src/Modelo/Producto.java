package Modelo;

public class Producto {
    private String nombre;
    private String numUnidades;
    private String precioUnitario;

    //Constructor:

    public Producto(String nombre, String numUnidades, String precioUnitario) {
        this.nombre = nombre;
        this.numUnidades = numUnidades;
        this.precioUnitario = precioUnitario;
    }

    //set y get:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(String numUnidades) {
        this.numUnidades = numUnidades;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
