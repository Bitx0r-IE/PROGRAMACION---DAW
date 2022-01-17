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

    public ArrayList<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }

    @Override
    public String toString() {
        return "Directivo{" +
                "categoria='" + categoria + '\'' +
                ", subordinados=" + subordinados +
                '}';
    }
}
