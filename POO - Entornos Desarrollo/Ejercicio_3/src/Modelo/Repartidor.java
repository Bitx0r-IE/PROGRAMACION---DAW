package Modelo;

public class Repartidor extends Empleados{
    private String zona;

    //Constructor:

    public Repartidor(String nombre, int edad, int salario, String zona) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    //set y get:

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "zona='" + zona + '\'' +
                '}';
    }

}
