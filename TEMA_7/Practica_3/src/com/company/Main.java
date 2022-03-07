package com.company;

import Modelo.Cliente;
import Modelo.Cuenta;
import Vista.V1;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    //Base de datos:
    private static ArrayList<Cliente> listaClientes;
    private static ArrayList<Cuenta> listaCuentas;
    //Ventanas:
    public static JFrame V1;
    public static JFrame V2;

    public static void main(String[] args) {
	    try {
            inicializar();
            mostrarVentanaPrincipal();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
    public static void mostrarVentanaPrincipal(){
        //copia pega del main de V1.java
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);//centrar ventana
        V1.pack();
        V1.setVisible(true);
    }
    public static void mostrarVentantaV2(){
        //copia pega del main de V2.java
    }
    public static void mostrarVentanaV3(){

    }
    public static void inicializar(){
        //Clientes:
        listaClientes = new ArrayList<>();
        //Cuentas:
        listaCuentas = new ArrayList<>();
    }
    public static boolean buscarCliente(String text, String s){

        return false;
    }
}
