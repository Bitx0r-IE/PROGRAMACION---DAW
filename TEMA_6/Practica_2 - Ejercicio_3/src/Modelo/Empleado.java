package Modelo;

public class Empleado extends Persona{
    private float sueldoBruto;

    //Constructor:

    public Empleado(String nombre, int edad, float sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }
}
