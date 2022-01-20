package com.company;

import Modelo.Cliente;
import Modelo.Gato;
import Modelo.Perro;
import Modelo.Veterinario;
import Excepciones.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static ArrayList<Veterinario> listaVeterinarios;

    public static void main(String[] args) {
        try {
            guardarDatos();
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Has decido salir del programa");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void guardarDatos(){
        //Pedir datos para crear clientes, veterinarios, gatos y perros:
        guardarVet();
    }
    public static String solicitarDato(String dato, String mensaje, String exp){
        String variable = "";
        boolean error = true;
        while (error){
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if(variable.isEmpty()){
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                }
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches()){
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                }
            }
            catch (DatoNoValido e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            error = false;
        }
        return variable;
    }
    public static void guardarVet(){
        boolean continuar = true;
        listaVeterinarios = new ArrayList<>();
        while(continuar){
            listaVeterinarios.add(new Veterinario(
                    solicitarDato("Nombre", "Teclea el nombre del veterianrio","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$"),
                    solicitarDato("Dirección", "Teclea la dirección","^[6789][0-9]{8}$"),
                    solicitarDato("Teléfono", "Teclea el teléfono","^[6789][0-9]{8}$"),
                    solicitarDato("DNI","Teclea el DNI","^[0-9]{8}[A-Za-z]$"),
                    solicitarDato("Número de la seguridad social","Teclea el número de la seguridad social","^01 [0-9]{8} [0-9]{2}$")));

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Hay más veterinarios?");
            if(respuesta != 0){
                continuar = false;
            }
        }
    }

}
