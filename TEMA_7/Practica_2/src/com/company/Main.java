package com.company;

import Modelo.Persona;
import Vista.V1;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    //Base de datos:
    private static ArrayList<Persona> listaPersonas;
    private static ArrayList<String> listaCursos;
    //ventanas:
    private static JFrame V1, V2;

    public static void main(String[] args) {
        //Base datos:
        listaPersonas = new ArrayList<>();
        cursos();
        //Creación primera ventana, copia pega del main de v1:
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);//Que aparezca centrado
        V1.pack();
        V1.setVisible(true);
    }

    public static void crearPersona(String text, String tNombreText, String tApellidosText, String tCursoText){
        listaPersonas.add(new Persona(text, tNombreText, tApellidosText, tCursoText));
    }

    public static void cursos(){
        //Rellenar la lista de cursos con todas las opciones:
        listaCursos = new ArrayList<>();
        //1º:
        listaCursos.add("1A");
        listaCursos.add("1B");
        listaCursos.add("1C");
        listaCursos.add("1D");
        //2º:
        listaCursos.add("2A");
        listaCursos.add("2B");
        listaCursos.add("2C");
        listaCursos.add("2D");
        //3º:
        listaCursos.add("3A");
        listaCursos.add("3B");
        listaCursos.add("3C");
        listaCursos.add("3D");
        //4º:
        listaCursos.add("4A");
        listaCursos.add("4B");
        listaCursos.add("4C");
        listaCursos.add("4D");
    }

    public static boolean comprobarCurso(String text){
        if (listaCursos.contains(text)){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean comprobarDNI(String text){
        if (listaPersonas.contains(text)){
         return true;
        }
        else {
            return false;
        }
    }

    public static void modificar(){

    }
}
