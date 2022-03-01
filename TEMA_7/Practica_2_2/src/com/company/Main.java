package com.company;

import Modelo.*;

import java.util.ArrayList;

import Vista.V1;
import Vista.VDCompra;
import Vista.VDVenta;

import javax.swing.*;

public class Main {

    // "Base de datos"
    private static Proveedor[] aProveedores;
    private static Producto[] aProductos;
    private static ArrayList<Cliente> lClientes;

    private static JFrame V1;

    private static Producto oProducto;
    private static Cliente oCliente;

    public static void main(String[] args) {
        //Crear datos y mostrar ventana principal:
        crearDatos();
        mostrarVentana();
    }

    public static void crearDatos(){
        //Generar datos:
        // Proveedores:
        aProveedores = new Proveedor[5];
        aProveedores[0] = new Proveedor();
        aProveedores[0].setNombre("Luisa");
        aProveedores[1] = new Proveedor();
        aProveedores[1].setNombre("MÃ³nica");
        aProveedores[2] = new Proveedor();
        aProveedores[2].setNombre("InÃ©s");
        aProveedores[3] = new Proveedor();
        aProveedores[3].setNombre("Ana");
        aProveedores[4] = new Proveedor();
        aProveedores[4].setNombre("Miren");

        //Productos:
        aProductos=new Producto[3];
        aProductos[0] = new Producto("Producto uno",10,257.2f);
        aProductos[1] = new Producto("Producto dos",100,2f);
        aProductos[2] = new Producto("Producto tres",5,50f);

        // Relación entre clases:
        aProductos[0].setListaProveedores(aProveedores[1]);
        aProductos[0].setListaProveedores(aProveedores[3]);

        aProductos[1].setListaProveedores(aProveedores[4]);

        aProductos[2].setListaProveedores(aProveedores[0]);
        aProductos[2].setListaProveedores(aProveedores[4]);

        // clientes
        lClientes = new ArrayList();
    }

    public static void mostrarVentana() {
        V1 = new JFrame("Ventana");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setSize(500,700);
        V1.setLocationRelativeTo(null);
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.pack();
        V1.setVisible(true);
    }

    public static void mostrarDialogoCompra(String unidades)
    {
        VDCompra dialog = new VDCompra(Integer.parseInt(unidades));
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void mostrarDialogoVenta(String unidades)
    {
        VDVenta dialog = new VDVenta(Integer.parseInt(unidades),oProducto.getPrecioVenta());
        dialog.pack();
        dialog.setVisible(true);
    }

    public static boolean buscarProducto(String nombre){
        int x;
        for(x = 0; x < aProductos.length && aProductos[x].getNombre().compareToIgnoreCase(nombre)!= 0; x++){}
        if (x == aProductos.length)
        {
            oProducto = null;
            return false;
        }
        oProducto = aProductos[x];
        return true;
    }

    public static void buscarCliente(String nombre){
        int x;
        for(x = 0; x < lClientes.size() && lClientes.get(x).getNombre().compareToIgnoreCase(nombre)!= 0; x++){}
        if (x == lClientes.size())
        {
            // cliente nuevo
            oCliente = new Cliente(nombre);
        }
        else
            oCliente=lClientes.get(x);
    }

    public static boolean hayUnidades(int u)
    {
        return oProducto.getUnidades() >= u;
    }
    public static String getPrecio()
    {
        return String.valueOf(oProducto.getPrecioVenta());
    }

    public static String[] getDatosProveedores(){
        // Genera y entrega un array de String con el nombre de los proveedores para llenar la combobox
        String[] nombres = new String[oProducto.getListaProveedores().size()];
        for(int x = 0; x < oProducto.getListaProveedores().size();x++)
            nombres[x] = oProducto.getListaProveedores().get(x).getNombre();
        return nombres;
    }

    public static void guardarCompra(Integer unidades, String precio)
    {
        oProducto.comprarUnidades(unidades,Float.parseFloat(precio));
        // En proveedor no hace falta hacer nada.
    }

    public static void guardarVenta(int unidades)
    {
        oProducto.venderUnidades(unidades);
        oCliente.setProducto(oProducto);
    }

    public static void limpiar()
    {
        V1.dispose();
        mostrarVentana();
    }

    public static String getDatos()
    {
        String datos = "Productos: \n";

        datos += "Provedores: \n";

        datos += "Clientes: \n";

        return datos;
    }
}
