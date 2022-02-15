package com.company;

import Vista.V1;
import Modelo.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static JFrame V1;
    private static ArrayList<Cliente> listaCliente;
    private static Proveedor[] listaProveedor;
    private static Producto[] listaProd;

    private static Producto oProducto;
    private static Proveedor oProveedor;
    private static Cliente oCliente;

    public static void main(String[] args) {
        inicializar();
        mostrarVentana();
    }
    public static void inicializar(){
        listaProd = new Producto[5];
        //Crear lista productos:
        listaProd[0] =(new Producto("p1", 5, 3.45f));
        listaProd[1] = (new Producto("p2", 7, 6.34f));
        listaProd[2] = (new Producto("p3", 9, 12.1f));
        listaProd[3] = (new Producto("p4", 6, 2.65f));
        listaProd[4] = (new Producto("p5", 11, 13.55f));

        listaCliente = new ArrayList<>();
        //Crear clientes:
        listaCliente.add(new Cliente("Pepe"));
        listaCliente.add(new Cliente("Juan"));
        listaCliente.add(new Cliente("Maria"));
        listaCliente.add(new Cliente("Elena"));

        listaProveedor = new Proveedor[4];
        //Crear proveedores:
        listaProveedor[0] = new Proveedor("Manolo");
        listaProveedor[1] = new Proveedor("Alejandra");
        listaProveedor[2] = new Proveedor("Adolfo");
        listaProveedor[3] = new Proveedor("Lorena");

        //Relaciones entre producto y proveedor:
        listaProd[0].setListaProveedor(listaProveedor[1]);
        listaProd[2].setListaProveedor(listaProveedor[1]);
        listaProd[1].setListaProveedor(listaProveedor[1]);

        listaProd[4].setListaProveedor(listaProveedor[2]);
        listaProd[1].setListaProveedor(listaProveedor[2]);

        listaProd[3].setListaProveedor(listaProveedor[3]);
        listaProd[3].setListaProveedor(listaProveedor[3]);

        listaProd[2].setListaProveedor(listaProveedor[0]);
        listaProd[4].setListaProveedor(listaProveedor[0]);

        listaProd[3].setListaProveedor(listaProveedor[3]);
        listaProd[3].setListaProveedor(listaProveedor[2]);
    }
    public static void  mostrarVentana(){
        //Copia pega del main de la vista v1:
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getPanelPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);//centrar la pestaña
        V1.pack();
        V1.setVisible(true);
    }
    public static boolean buscarProd(String nombre){
        int x;
        for (x = 0; x < listaProd.length && listaProd[x].getNombre().compareToIgnoreCase(nombre) != 0; x++){}
        if (x == listaProd.length){
            oProducto = null;
            return false;
        }
        else{
            oProducto = listaProd[x];
            return true;
        }
    }
    public static void buscarCliente(String nombre){
        int x;
        for (x = 0; x < listaCliente.size() && listaCliente.get(x).getNombre().compareToIgnoreCase(nombre) != 0; x++){}
        if (x == listaCliente.size()){
            oCliente = new Cliente(nombre);
        }
        else {
            oCliente = listaCliente.get(x);
        }
    }
    public static boolean buscarUnidades(int u){
        return oProducto.getNumUnidades() >= u;
    }
    public static String getPrecio(){
        return String.valueOf(oProducto.getPrecioVenta());
    }
    public static String[] getDatosProveedores(){
        //Array para llenar la combobox de proveedores:
        String[] nombreProv = new String[oProducto.getListaProveedor().size()];
        for ()
    }
    public static void guardarVenta(String unidades){
        oProducto.venderUnidades(Integer.parseInt(unidades));
        oCliente.setProducto(oProducto);
    }
    public static void limpiar(){
        V1.dispose();
        mostrarVentana();
    }


}
