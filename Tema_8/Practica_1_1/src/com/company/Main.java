package com.company;

import Vista.V1;
import Vista.V2;
import Modelo.*;
import javax.swing.*;
import java.sql.*;

public class Main {

    private static JFrame V1;
    private static JFrame V2;
    //Declarar conexion con la Base de Datos:
    private static Connection con;

    public static void main(String[] args) {
        try {
            //Iniciar base de datos:
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3307/practica_1";
            String user = "root";
            String passwd = "usbw";

            con = DriverManager.getConnection(url, user, passwd);

            //ventana principal:
            mostrarVentanaPrincipal();
        }
        catch (Exception e){
            System.out.println("Problemas con la base de datos " + e.getMessage());
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
    public static void cerrarBD() throws SQLException {
        con.close();
    }
    public static void crearPerso(String text, String tfNombreText, String tfProfesionText, String tfTelefonoText) throws SQLException {
        int edad = Integer.parseInt(text);
        String nombre = tfNombreText;
        String prof = tfProfesionText;
        int telf = Integer.parseInt(tfTelefonoText);
        Persona persona = (new Persona(nombre, edad, prof, telf));
        comandos(persona);
    }

    public static void comandos(Persona persona) throws SQLException {
        PreparedStatement sentencia
        //Crear el insert de la nueva persona:
        String s = null;
        //Ejecutar el insert
        sentencia.executeUpdate(s);
    }
}
