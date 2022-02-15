package Modelo;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private ArrayList<Producto> listaProducto;

    //Constructor:

    public Cliente(String nombre) {
        this.nombre = nombre;
        listaProducto = new ArrayList<>();
    }

    //set y get:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProducto(ArrayList<Producto> listaProducto) {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    public void setProducto(Producto p){
        this.listaProducto.add(p);
    }
}
