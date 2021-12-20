package Modelo;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private int dNacimiento;
    private int mNacimiento;
    private int aNacimiento;
    private String direccion;
    private String codPostal;
    private String ciudad;

    public Persona(String nombre, int dNacimiento, int mNacimiento, int aNacimiento, String direccion, String codPostal, String ciudad) {
        this.nombre = nombre;
        this.dNacimiento = dNacimiento;
        this.mNacimiento = mNacimiento;
        this.aNacimiento = aNacimiento;
        this.direccion = direccion;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getdNacimiento(){
        return dNacimiento;
    }

    public void setdNacimiento(String dNacimiento) {
        this.dNacimiento = dNacimiento;
    }

    public int getmNacimiento() {
        return mNacimiento;
    }

    public void setmNacimiento(String mNacimiento) {
        this.mNacimiento = mNacimiento;
    }

    public int getaNacimiento() {
        return aNacimiento;
    }

    public void setaNacimiento(String aNacimiento) {
        this.aNacimiento = aNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public boolean getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int calcularEdad(){
        LocalDate fechaNac = LocalDate.of(aNacimiento, mNacimiento, dNacimiento);
        LocalDate actualidad = LocalDate.now();

        Period periodo = Period.between(fechaNac, actualidad);
        return periodo.getYears();
    }
    public boolean mayorEdad(){
        return this.ciudad.equals(ciudad);
    }
    public boolean isCiudad(String ciudad){
        return this.ciudad.equals(ciudad);
    }
}
