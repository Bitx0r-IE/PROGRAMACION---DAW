package Modelo;

import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombreApellidos;
    private int clave;

    private ArrayList<Cuenta> listaCuentas;
    //Constructor:

    public Cliente(String dni, String nombreApellidos, int clave) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.clave = clave;
    }

    //get y set:

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public int getNumCuentas(){
        return listaCuentas.size();
    }

    public Cuenta getCuenta(int x){
        return listaCuentas.get(x);
    }
}
