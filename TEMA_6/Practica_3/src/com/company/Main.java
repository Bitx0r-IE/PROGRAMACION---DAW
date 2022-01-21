package com.company;

import Modelo.*;
import Excepciones.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static ArrayList<Veterinario> listaVeterinarios;
    private static ArrayList<Cliente> lisaClientes;
    private static ArrayList<Mascota> listaMascotas;
    private static ArrayList<String> razasPerro;
    private static ArrayList<String> razasGato;

    public static void main(String[] args) {
        try {
            guardarDatos();
            mostrarMenu();
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
        JOptionPane.showMessageDialog(null, "Introducir datos del verinario/s");
        guardarVet();
        JOptionPane.showMessageDialog(null, "Introducir datos del cliente/s");
        guardarClientes();
        JOptionPane.showMessageDialog(null, "Introducir datos de la mascota");
        guardarClientes();
    }
    public static void guardarRazas(){
        //Añadir razas de perros:
        razasPerro.add("San Bernardo");
        razasPerro.add("Border Collie");
        razasPerro.add("Boxer");
        razasPerro.add("Gran Danes");
        razasPerro.add("Pug");
        razasPerro.add("Corgi");
        razasPerro.add("Pastor Alemán");
        razasPerro.add("Golden Retriever");
        razasPerro.add("Pitbull");

        //añadir razas de gatos:
        razasGato.add("Siames");
        razasGato.add("Persa");
        razasGato.add("Maine Coon");
        razasGato.add("Bosque de Noruega");
        razasGato.add("Azur ruso");
        razasGato.add("Abisino");
        razasGato.add("Sphynx");
        razasGato.add("Siveriano");
        razasGato.add("Gato común");
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
                    solicitarDato("Nombre", "Teclea el nombre del veterianrio","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    solicitarDato("Dirección", "Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$"),
                    solicitarDato("Teléfono", "Teclea el teléfono","^[6789][0-9]{8}$"),
                    solicitarDato("DNI","Teclea el DNI","^[0-9]{8}[A-Za-z]$"),
                    solicitarDato("Número de la seguridad social","Teclea el número de la seguridad social","^01 [0-9]{8} [0-9]{2}$")));

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Hay más veterinarios?");
            if(respuesta != 0){
                continuar = false;
            }
        }
    }
    public static void guardarClientes(){
        //pedir datos de cliente, tras pedir datos de mascota, al realizar la relación con el dueño se selecciona una ya creado:
        boolean continuar = true;
        lisaClientes = new ArrayList<>();
        while (continuar){
            lisaClientes.add(new Cliente(
                    solicitarDato("Nombre","Teclea el nombre del cliente","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    solicitarDato("Dirección","Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][z]+)* [0-9]{1,3} [0-9][a-zA-Z]$"),
                    solicitarDato("Teléfono","Teclea el teléfono","^[6789][0-9]{8}$")));
        }
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Hay más clientes?");
        if (respuesta != 0){
            continuar = false;
        }
    }
    public static void guardarMascotas(){
        boolean continuar = true;
        listaMascotas = new ArrayList<>();
        try {
            while (continuar){
                String tipo = JOptionPane.showInputDialog("¿Perro o Gato?");
                if (tipo.equalsIgnoreCase("perrro")){
                    listaMascotas.add(new Perro(
                            solicitarDato("Raza","Teclea la raza de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                            solicitarDato("Nombre","Teclea el nombre de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                            solicitarDato("Fecha nacimiento","Teclea la fecha de nacimiento","[0-3][0-]/[0-1][0-9]/2"),
                            solicitarDato("String sexo","Teclea el sexo de la mascota", "^(Macho|Hembra)"),
                            Float.parseFloat(solicitarDato("Longitud","Teclea la longitud","[0-9]{1,}(.[0-9])?$")),
                            solicitarDato("Tipo de pelo", "Teclea el tipo de pelo", "^(Largo|Corto)")
                    ));
                }
                else{
                    if(tipo.equalsIgnoreCase("gato")){
                        //¿Fecha con con un?
                        listaMascotas.add(new Gato(
                                solicitarDato("Raza","Teclea la raza de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                                solicitarDato("Nombre","Teclea el nombre de la mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                                solicitarDato("Fecha nacimiento","Teclea la fecha de nacimiento","[0-3][0-]/[0-1][0-9]/2"),
                                solicitarDato("String sexo","Teclea el sexo de la mascota", "^(Macho|Hembra)"),
                                Float.parseFloat(solicitarDato("Longitud","Teclea la longitud","[0-9]{1,}(.[0-9])?$")),
                                solicitarDato("Tipo de pelo", "Teclea el tipo de pelo", "^(Largo|Corto)")
                        ));
                    }
                }
            }
        }
        catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static void datosDueño(){
        //pedir los datos del dueño, en la lista de clientes y hacer la relacion entre dueño y mascota
    }
    public static void datosVet(Mascota m){
        //pedir datos veterinario, pedidos con anterioridad y hacer la relacion entre vet y mascota
        boolean error = true;
        int x = 0;
        while (error){
            try {
                String nombre = solicitarDato("Nombre", "Nombre del veterinario", "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$");
                for (x = 0; x < listaVeterinarios.size() && listaVeterinarios.get(x).getNombre().compareToIgnoreCase(nombre)!=0;x++){
                }
                if (x == listaVeterinarios.size())
                    throw new DatoNoValido("No hay ningún veterinarion con ese nombre");
                error = false;
            }
            catch (DatoNoValido e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            //Realcion mascota - vet:
            listaVeterinarios.get(x).setMascota(m);
            return listaVeterinarios.get(x);
        }
    }
    public static void mostrarMenu(){
        //Menu de selección de opciones
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Mostrar el nÃºmero de clientes que poseen un tipo de animal concreto.\n" +
                        "2 - Datos personales del cliente a partir del nombre de mascota.\n" +
                        "3- Datos del veterinario a partir de los datos de una mascota.\n" +
                        "4- Datos de las mascotas de un cliente.\n" +
                        "5- Datos de las mascotas de un veterinario.\n" +
                        "6- Terminar.\n"));
                switch (opcion) {
                    case 1:
                        //opcion1();
                        break;
                    case 2:
                        //opcion2();
                        break;
                    case 3:
                        //opcion3();
                        break;
                    case 4:
                        //opcion4();
                        break;
                    case 5:
                        //opcion5();
                        break;
                    case 6:
                        break;
                    default:
                        throw new DatoNoValido("La opciÃ³n elegida no existe");

                }
            } catch (DatoNoValido e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
        while (opcion != 6);
    }

}
