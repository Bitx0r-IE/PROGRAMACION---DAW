package Modelo;

public class Programador extends Empleado{
    private int lineasDeCodigoPorHora;
    private StringBuilder lenguajeDominante;

    //Constructor:

    public Programador() {
    }

    public Programador(StringBuilder nombre, StringBuilder DNI, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, StringBuilder lenguajeDominante) {
        super(nombre, DNI, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    //get y set:

    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    public StringBuilder getLenguajeDominante() {
        return lenguajeDominante;
    }

    public void setLenguajeDominante(StringBuilder lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }
}
