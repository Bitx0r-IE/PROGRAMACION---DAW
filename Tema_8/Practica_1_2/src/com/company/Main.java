package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventoDAO;
import Modelo.UML.Evento;
import Vista.V1;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static JFrame V1;

    private static BaseDatos bd;
    private static EventoDAO edao;

    private static ArrayList<Evento> listaEventos;

    public static void main(String[] args) {
	    try {
            //Conexión con la base de datos
            //bd = new BaseDatos();
            //edao = new EventoDAO(bd.getCon());
            //Creació ventana menu principal:
            crearVentanaMenu();
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void crearVentanaMenu(){
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);
        V1.pack();
        V1.setVisible(true);
    }
}
