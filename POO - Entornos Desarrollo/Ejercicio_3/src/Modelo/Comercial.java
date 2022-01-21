package Modelo;

public class Comercial extends Empleados{
    private double comercial;

    //Constructor:


    public Comercial(String nombre, int edad, int salario, double comercial) {
        super(nombre, edad, salario);
        this.comercial = comercial;
    }

    //set y get:

    public double getComercial() {
        return comercial;
    }

    public void setComercial(double comercial) {
        this.comercial = comercial;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "comercial=" + comercial +
                '}';
    }

}
