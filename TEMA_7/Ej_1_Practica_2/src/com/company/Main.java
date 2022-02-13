package com.company;

import Excepciones.DatoNoValido;
import Vista.V1;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    private static JFrame V1;
    private static ArrayList<Producto> listaProd;
    private static ArrayList<Cliente> listaCliente;
    private static ArrayList<Proveedor> listaProv;

    public static void main(String[] args) {
        inicializar();
        mostrarVentana();
    }
    public static void inicializar(){
        listaProd = new ArrayList<>();
        //Crear lista productos:
        listaProd.add(new Producto("p1", "5", "3"));
        listaProd.add(new Producto("p2", "7", "6"));
        listaProd.add(new Producto("p3", "9", "12"));
        listaProd.add(new Producto("p4", "6", "2"));
        listaProd.add(new Producto("p5", "11", "15"));

        listaCliente = new ArrayList<>();
        //Crear clientes:
        listaCliente.add(new Cliente("Pepe"));
        listaCliente.add(new Cliente("Juan"));
        listaCliente.add(new Cliente("Maria"));
        listaCliente.add(new Cliente("Elena"));

        listaProv = new ArrayList<>();
        //Crear proveedores:
        listaProv.add(new Proveedor("Manolo"));
        listaProv.add(new Proveedor("Alejandra"));
        listaProv.add(new Proveedor("Adolfo"));
        listaProv.add(new Proveedor("Lorena"));
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
    public static void validarProd(JTextField tfNombreProd){
        try {
            if (listaProd.contains(tfNombreProd)){
                tfNombreProd.setBackground(Color.BLUE);
            }
            else{
                tfNombreProd.setBackground(Color.RED);
                throw new DatoNoValido("Producto no valido");
            }
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static void validarUnidades(JTextField tfUnidades) {
        try {
            if (listaProd.contains(tfUnidades)){
                tfUnidades.setBackground(Color.BLUE);
            }
            else{
                tfUnidades.setBackground(Color.RED);
                throw new DatoNoValido("Producto no valido");
            }
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static void porVolumen(){

    }
    public static void prontoPago(){

    }


}
