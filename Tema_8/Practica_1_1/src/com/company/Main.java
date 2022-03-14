package com.company;

import Excepciones.DatoNoValido;
import Modelo.BD.Base_Datos;
import Modelo.BD.PersonaDAO;
import Modelo.UML.Persona;
import Vista.V1;
import Vista.V2;

import javax.swing.*;
import java.sql.*;

public class Main {

    private static JFrame V1;
    private static JFrame V2;
    //Declarar conexion con la Base de Datos:
    private static Base_Datos bd;
    private static PersonaDAO pdao;

    public static void main(String[] args) {
        try {
            //Iniciar base de datos:
            bd = new Base_Datos();
            pdao = new PersonaDAO(bd.getConnection());
            //ventana principal:
            mostrarVentanaPrincipal();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void mostrarVentanaPrincipal(){
        //copia pega main V1:
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);//Centrar ventana
        V1.pack();
        V1.setVisible(true);
    }
    public static void mostrarVentanaPersonas(){
        //copia pega main V2:
        V2 = new JFrame("V2");
        V2.setContentPane(new V2().getpInfo());
        V2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V2.setLocationRelativeTo(null);//Centrar ventana
        V2.pack();
        V2.setVisible(true);
    }

}
