package com.company;

import Modelo.Cliente;
import Modelo.Cuenta;
import Vista.V1;
import oracle.jrockit.jfr.JFR;

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
	    inicializar();
        mostrarVentanaPrincipal();
    }
    public static void mostrarVentanaPrincipal(){
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);//centrar ventana
        V1.pack();
        V1.setVisible(true);
    }
    public static void inicializar(){
        //Clientes:
        listaClientes = new ArrayList<>();
        //Cuentas:
        listaCuentas = new ArrayList<>();
    }
}
