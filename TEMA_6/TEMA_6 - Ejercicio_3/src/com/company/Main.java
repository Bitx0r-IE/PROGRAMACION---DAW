package com.company;

import Excepciones.DatoNoValidoException;
import Modelo.Persona;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Persona> persona;

    public static void main(String[] args) {
        /*Define una clase Persona con los siguientes datos: nombre, dNacimiento (día nacimiento), mNacimiento (mes nacimiento),
        *aNacimiento (año nacimiento), dirección, código postal y ciudad.
        *Crea varios objetos de tipo Persona y a través de un programa muestra los siguientes datos:
        *   - Nombre de la persona de mayor edad
        *   - Nombre de las personas que viven en Elche
        *   - Número de personas mayores de edad
        * Hay que comprobar que todos los campos contienen información y que es lógica.*/
        try{
            persona = new ArrayList<>();
            obtenerDatos();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void obtenerDatos(){
        do{
            try {
                do {
                    String nombre = JOptionPane.showInputDialog("Nombre de la persona: ");
                    validarNombre(nombre);
                    String dNac = JOptionPane.showInputDialog("Día de nacimiento: ");
                    String mNac = JOptionPane.showInputDialog("Mes de nacimiento: ");
                    String aNac = JOptionPane.showInputDialog("Año de nacimiento: ");
                    validarFecha(dNac, mNac, aNac);
                    String dir = JOptionPane.showInputDialog("Dirección: ");
                    String codPostal = JOptionPane.showInputDialog("Código postal: ");
                    String ciudad = JOptionPane.showInputDialog("Ciudad: ");
                    validarCodPostal(codPostal);
                    //Añadir los datos del alumno a la clase persona:
                    Persona a = new Persona(nombre, dNac, mNac, aNac, dir, codPostal, ciudad);
                    //Añadir la nueva persona creado en el la lista arrayList:
                    persona.add(a);
                }
                while (JOptionPane.showConfirmDialog(null, "¿Quiere continuar?: ")==0);
            }
            catch (DatoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: el dato introducido no es válido");
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: formato no correcto");
            }
        }
        while(JOptionPane.showConfirmDialog(null, "¿Quieres continuar?: ")==0);
    }

    public static void validarNombre(String nombre) throws DatoNoValidoException {
        boolean isNumeric = nombre.chars().allMatch(Character::isDigit);
        if (isNumeric == false){
            throw new DatoNoValidoException();
        }
    }
    public static void validarFecha(String dNac, String mNac, String aNac) throws NumberFormatException, DatoNoValidoException{
        try{
            int dNacimiento = Integer.parseInt(dNac);
            int mNacimiento = Integer.parseInt(mNac);
            int aNacimiento = Integer.parseInt(aNac);
            //Condiciones para realizar DatoNoValido:
            if (aNacimiento > 2021 || mNacimiento > 12 || mNacimiento < 1 || dNacimiento > 31 || dNacimiento < 1){
                throw new DatoNoValidoException();
            }
            if (aNac.length() < 4 ){
                throw new DatoNoValidoException();
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR");
        }
    }
    public static void validarCodPostal(String codPostal) throws NumberFormatException, DatoNoValidoException{
        int CodPostal = Integer.parseInt(codPostal);
        if (codPostal.length() < 5){
            throw new DatoNoValidoException();
        }
    }
    public static void deElche(){
        StringBuilder listaElche = new StringBuilder();
        for (int x = 0; x < persona.size(); x++){
            if (persona.get(x).getCiudad()){
                listaElche.append(persona.toString()+"\n");
            }
        }
    }
}
