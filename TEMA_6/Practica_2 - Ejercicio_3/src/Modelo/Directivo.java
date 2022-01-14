package Modelo;

import java.lang.reflect.Constructor;

public class Directivo extends Empleado{
    private String categoria;

    //Constructor:

    public Directivo(String nombre, int edad, float sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
    }
}
