package Modelo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Directivo extends Empleado{
    private String categoria;
    private ArrayList<Empleado> subordinados;
    //Constructor:

    public Directivo(String nombre, int edad, double sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
    }

    //set y get:

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String mostrar() {
        return this.getNombre()+ " " + this.getEdad() + " " +  this.getSueldoBruto() + " " + this.getCategoria();
    }
}
