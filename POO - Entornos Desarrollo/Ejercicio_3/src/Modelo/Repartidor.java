package Modelo;

public class Repartidor extends Empleados{
    private double comision;

    //Constructor:

    public Repartidor(String nombre, int edad, int salario, double comision) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    //set y get:
    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "comision=" + comision +
                '}';
    }
}
