package Modelo;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    //Relaciones con Empleado y Cliente:
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cliente> listaClientes;

    //Constructor:

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public Empresa(String nombre,ArrayList<Cliente> listaClientes) {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaEmpleados = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void setEmpleado(Empleado e){
        listaEmpleados.add(e);
    }
}
