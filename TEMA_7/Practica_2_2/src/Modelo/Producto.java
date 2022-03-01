package Modelo;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private Integer unidades;
    private Float precioUnitario;

    private ArrayList<Proveedor> listaProveedores;

    //get y set de listaProveedores:

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(Proveedor p) {
        this.listaProveedores.add(p);
    }

    //Constructor:

    public Producto(String n, Integer u, Float p) {
        this.nombre = n;
        this.unidades = u;
        this.precioUnitario = p;
        listaProveedores = new ArrayList();
    }

    //set y get:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer u) {
        this.unidades = u;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float p) {
        this.precioUnitario = p;
    }

    //Operaciones:

    public void comprarUnidades(Integer u, Float p){
        setNuevoPecio(u, p);
        unidades = unidades - u;
    }

    public void venderUnidades(Integer u){
        unidades = unidades - u;
    }

    public void setNuevoPecio(int unidades, float p){
        precioUnitario = ((this.unidades * this.precioUnitario) + (unidades * p))/(this.unidades + unidades);
    }

    public Float getPrecio(){
        return precioUnitario;
    }

    public Float getPrecioVenta(){
        return precioUnitario * 2;
    }
}
