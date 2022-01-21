package Modelo;

import javax.swing.*;

public class Empleado {
    protected StringBuilder nombre;
    protected StringBuilder DNI;
    protected int edad;
    protected boolean casado;
    protected double salario;

    //Constructor:

    public Empleado() {
    }

    public Empleado(StringBuilder nombre, StringBuilder DNI, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }

    //get y set:

    public StringBuilder getNombre() {
        return nombre;
    }

    public void setNombre(StringBuilder nombre) {
        this.nombre = nombre;
    }

    public StringBuilder getDNI() {
        return DNI;
    }

    public void setDNI(StringBuilder DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Métodos:
    public String calificacionEdad(Empleado e){
        String calificacion = "";
        if (e.getEdad() <= 21){
            calificacion = "Principiante";
        }
        else if(e.getEdad() >= 22 && e.getEdad() <= 35){
            calificacion = "Intermedio";
        }
        else if(e.getEdad() > 35){
            calificacion = "Senior";
        }
        return calificacion;
    }

    //Imprimir los datos del empleado por pantalla:

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre=" + nombre +
                ", DNI=" + DNI +
                ", edad=" + edad +
                ", casado=" + casado +
                ", salario=" + salario +
                '}';
    }

    public double aumentoSalario(Empleado e){
        double porcentaje = Double.parseDouble(JOptionPane.showInputDialog("porcentaje de aumento:"));
        double aumento = (e.getSalario()) * porcentaje;
        return aumento;
    }
}
