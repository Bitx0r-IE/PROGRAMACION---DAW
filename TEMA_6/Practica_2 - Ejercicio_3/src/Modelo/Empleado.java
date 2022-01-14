package Modelo;

import java.util.ArrayList;

public class Empleado extends Persona{
    private double sueldoBruto;

    //Constructor:

    public Empleado(String nombre, int edad, double sueldoBruto) {
        //clase padre
        super(nombre, edad);
        //clase hijo
        this.sueldoBruto = sueldoBruto;
    }

    //set y get:

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + " " + this.getSueldoBruto();
    }

    public Double calcularSalarioNeto(){
        return null;
    }
}
