package com.company;

import Modelo.Persona;
import Vista.ventanaListado;
import Vista.ventanaListado2;
import javafx.util.converter.PercentageStringConverter;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Persona> listaPerso;
    private static JFrame ventanaListado, ventanaListado2;

    public static void main(String[] args) {
        //lista de personas:
        listaPerso = new ArrayList<>();

	    // copia pega del main de la primera pestaña formulario, para que se inicien en el main del proyecto:
        ventanaListado = new JFrame("ventanaListado");
        ventanaListado.setContentPane(new ventanaListado().getPanel());
        ventanaListado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaListado.setLocationRelativeTo(null);//centrar la ventana para que no esté en la esquina superior izquierda
        ventanaListado.pack();
        ventanaListado.setVisible(true);
    }

    public static void crearPerso(String text, String tApellidosText, String tDNIText){
        listaPerso.add(new Persona(text, tApellidosText, tDNIText));
    }

    public void getDatos(){
        //Crear el String de datos para la segunda ventana:
        String datos = "";
        for (Persona persona: listaPerso){
            datos += persona.toString();
        }

        //Ventana 2: quitar ventana 1, copia pega del main de la ventana2 con modificaciones para insertar datos (priviamente hechos):
        ventanaListado.dispose();
        ventanaListado2 = new JFrame("ventanaListado2");
        ventanaListado2.setContentPane(new ventanaListado2(datos).getPanel());
        ventanaListado2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaListado2.setLocationRelativeTo(null);
        ventanaListado2.pack();
        ventanaListado2.setVisible(true);

    }
}
