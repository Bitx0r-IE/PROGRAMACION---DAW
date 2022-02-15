package Modelo;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private Integer numUnidades;
    private Float precioUnitario;
    private ArrayList<Proveedor> listaProveedor;

    public ArrayList<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(Proveedor p) {
        this.listaProveedor.add(p);
    }

    //Constructor:

    public Producto(String n, Integer u, Float p) {
        this.nombre = n;
        this.numUnidades = u;
        this.precioUnitario = p;
        listaProveedor = new ArrayList<>();
    }


    //set y get:

    public void setNombre(String n) {
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumUnidades() {
        return numUnidades;
    }

    public void setPrecioUnitario(Float p){
        precioUnitario = p;
    }

    public void setNumUnidades(Integer u) {
        numUnidades = u;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void comprarUnidades(Integer u, Float p){
        setNuevoPrecio(u,p);
        numUnidades = numUnidades + u;
    }
    public void venderUnidades(Integer u){
        numUnidades = numUnidades - u;
    }
    public void setNuevoPrecio(int numUnidades, float p){
        precioUnitario = ((this.numUnidades * precioUnitario) + (numUnidades * p))/(this.numUnidades + numUnidades);
    }
    public Float getPrecio(){
        return precioUnitario;
    }
    public Float getPrecioVenta(){
        return precioUnitario * 2;
    }


}
