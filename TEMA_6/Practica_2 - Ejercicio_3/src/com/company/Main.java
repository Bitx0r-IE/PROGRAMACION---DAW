package com.company;

import Modelo.Persona;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Persona> listaPersonas;

    public static void main(String[] args) {
        // try catch generico:
        try {
            crearPersona();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void crearPersona(){
        listaPersonas = new ArrayList();
        listaPersonas.add(new Persona("Pepe", 19));
    }
}
