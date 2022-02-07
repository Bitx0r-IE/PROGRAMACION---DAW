package com.company;

import Vista.V1;
import com.sun.corba.se.impl.protocol.MinimalServantCacheLocalCRDImpl;

import javax.swing.*;

public class Main {

    private static JFrame V1;

    public static void main(String[] args) {
        inicializar();
        mostrarVentana();
    }
    public static void inicializar(){

    }
    public static void  mostrarVentana(){
        //Copia pega del main de la vista v1:
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getPanelPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.pack();
        V1.setVisible(true);
    }
}
