package com.company;

import Excepciones.DatoNoValidoException;
import Modelo.Agenda;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Agenda> listaAlumnos;

    public static void main(String[] args) {
        /*Crea una agenda con los datos de los alumnos de clase. De cada alumno guarda su código, nombre domicilio y
        * teléfono. Una vez introducido sus datos, se visualizarán los datos del alumnoque corresponda con un código
        * tecleado.*/
        try{
            listaAlumnos = new ArrayList<>();
            obtenerDatosAlum();
            buscarPorCod();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void buscarPorCod(){
        String codigo = JOptionPane.showInputDialog("Código del alumno: ");
        validarCod(codigo);
        //Buscar:
        int x;
        for (x = 0; listaAlumnos.size() && !listaAlumnos.get(x).getCodigo().equals(codigo); x++){}
        if( x == listaAlumnos.size()){
            JOptionPane.showMessageDialog(null, "ERROR: Alumno no encontrado");
        }
        else{
            JOptionPane.showMessageDialog(null, "ALumno: " + listaAlumnos.get(x) + "\n");
        }
    }
    public static void obtenerDatosAlum(){
        do {
            try{
                String codigo = JOptionPane.showInputDialog("Código del alumno");
                validarCod(codigo);
                String nombre = JOptionPane.showInputDialog("Nombre del alumno:");
                validarNombre(nombre);
                String dir = JOptionPane.showInputDialog("Domicilio del alumno:");
                validarDir(dir);
                String telf = JOptionPane.showInputDialog("Teléfono del alumno");
                validarTelf(telf);

                Agenda a = new Agenda(codigo, nombre, dir, telf);

                listaAlumnos.add(a);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: teclea un nombre");
            }
        }
        while(JOptionPane.showConfirmDialog(null, "¿Quieres continuar?")==0);
    }
    public static void validarCod(String codigo){

    }
    public static void validarNombre(String nombre){

    }
    public static void validarDir(String dir){

    }
    public static void validarTelf(String telf){

    }
}
