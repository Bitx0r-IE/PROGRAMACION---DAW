package Modelo;

import java.util.ArrayList;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String direccionWeb;
    private int fundacion;
    private String pais;
    private int telefono;

    private ArrayList<Pelicula> peliProducida;

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, int fundacion, String pais, int telefono, ArrayList<Pelicula> peliProducida) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.fundacion = fundacion;
        this.pais = pais;
        this.telefono = telefono;
        this.peliProducida = peliProducida;
    }

    public String getNombre (String nombre){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
