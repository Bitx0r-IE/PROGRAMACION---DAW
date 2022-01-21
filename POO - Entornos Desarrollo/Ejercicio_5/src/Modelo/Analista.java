package Modelo;

public class Analista extends Empleado{
    private int personas_a_cargo;

    //Constructor:

    public Analista(StringBuilder nombre, StringBuilder DNI, int edad, boolean casado, double salario, int personas_a_cargo) {
        super(nombre, DNI, edad, casado, salario);
        this.personas_a_cargo = personas_a_cargo;
    }

    //get y set:

    public int getPersonas_a_cargo() {
        return personas_a_cargo;
    }

    public void setPersonas_a_cargo(int personas_a_cargo) {
        this.personas_a_cargo = personas_a_cargo;
    }
}
