package Modelo;

public class Empleado extends Persona{
    private float sueldoBruto;

    //Constructor:

    public Empleado(String nombre, int edad, float sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    //set y get:

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public float calcularSalario(float sueldoBruto){
        float impuestos = 10/100;
        float sueldoNeto = sueldoBruto * impuestos;
        return sueldoBruto;
    }
}
