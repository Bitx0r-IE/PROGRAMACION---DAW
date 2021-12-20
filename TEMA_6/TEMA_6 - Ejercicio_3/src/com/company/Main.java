package com.company;

import Excepciones.AñoNoValidoException;
import Excepciones.CampoNoRellenoException;
import Excepciones.DatoNoValidoException;
import Modelo.Persona;
import javax.swing.JOptionPane;
import java.time.DateTimeException;
import java.time.LocalDate;
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
            do {
                persona = new ArrayList<>();
                obtenerDatos();
            }
            while (JOptionPane.showConfirmDialog(null, "¿Quiere continuar?: ")==0);
            //Una vez el usuario decida no continuar creando persanas, se procede a mostrar los datos pedidos por el ejercicio:
            buscarDeElche();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void obtenerDatos() throws DatoNoValidoException {
        String nombre = JOptionPane.showInputDialog("Nombre de la persona: ");
        validarNombre(nombre);

        /*La generacion de la fecha se hace de manera diferente, el método que se usa en en el resto de casos da
        problemas en caso de que el dato que se quiere introducir sea int:*/
        int dNacimiento, mNacimiento, aNacimiento;
        do{
            //Pedir al usuario día, mes y año; la fecha se puede contruir posteriormente de ser necesario:
            dNacimiento = pediDia();
            mNacimiento = pedirMes();
            aNacimiento = pedirAño();
        }
        while (validarFecha(dNacimiento, mNacimiento, aNacimiento));

        String dir = JOptionPane.showInputDialog("Dirección: ");

        String codPostal = JOptionPane.showInputDialog("Código postal: ");

        String ciudad = JOptionPane.showInputDialog("Ciudad: ");
        validarCodPostal(codPostal);

        //Añadir los datos del alumno a la clase persona:
        Persona a = new Persona(nombre, dNacimiento, mNacimiento, aNacimiento, dir, codPostal, ciudad);

        //Añadir la nueva persona creado en el la lista arrayList:
        persona.add(a);
    }

    public static void validarNombre(String nombre) throws DatoNoValidoException {
        boolean isNumeric = nombre.chars().allMatch(Character::isDigit);
        if (isNumeric == false){
            throw new DatoNoValidoException();
        }
    }
    public static int pediDia(){
        boolean problemas = true;:
        int dia = 0;
        do {
            try {
                String d = JOptionPane.showInputDialog("Día de nacimiento: ");
                if (d.isEmpty()){
                    throw new CampoNoRellenoException();
                }
                dia = Integer.parseInt(d);
                if (dia < 1 || dia > 31){
                    throw new DatoNoValidoException();
                }
                problemas = false;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: Escribe un número");
            }
            catch (CampoNoRellenoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Campo obligatorio no completado");
            }
            catch (DatoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: escriba un dia real");
            }
        }
        while (problemas);
        return dia;
    }
    public static int pedirMes(){
        boolean problemas = true;
        int mes = 0;
        do {
           try {
               String m = JOptionPane.showInputDialog(null, "Mes de nacimiento: ");
               if (m.isEmpty()){
                   throw new CampoNoRellenoException();
               }
               mes = Integer.parseInt(m);
               if (mes < 1 || mes > 12){
                   throw new DatoNoValidoException();
               }
               problemas = false;
           }
           catch (CampoNoRellenoException e){
               JOptionPane.showMessageDialog(null, "ERROR: campo obligatorio no completado");
           }
           catch (NumberFormatException e){
               JOptionPane.showMessageDialog(null, "ERROR: El mes debe ser numérico");
           }
           catch (DatoNoValidoException e){
               JOptionPane.showMessageDialog(null, "ERROR: Mes introducido no es correcto");
           }
        }
        while (problemas);
        return mes;
    }
    public static int pedirAño(){
        boolean problemas = true;
        int año = 0;
        do {
            try {
                String a = JOptionPane.showInputDialog("Año de nacimiento: ");
                if (a.isEmpty()){
                    throw new CampoNoRellenoException();
                }
                año = Integer.parseInt(a);
                if (año < 1910 || año > 2021){
                    //Se considera que si no ha personas vivas nacidas antes de 1910
                    throw new AñoNoValidoException();
                }
                problemas = false;
            }
            catch (CampoNoRellenoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Campo obligatorio no completado");
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: El año debe ser numérico");
            }
            catch (AñoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Año no valido");
            }
        }
        while (problemas);
        return año;
    }
    public static boolean validarFecha(int dia, int mes, int año){
        //Construir fecha y comprobar que esta es lógica:
        try {
            LocalDate fechaNac = LocalDate.of(año, mes, dia);
            //En caso de que no se produzca un error:
            return false;
        }
        catch (DateTimeException e){
            JOptionPane.showMessageDialog(null, "ERROR: la fehca introducida no es correcta");
        }
        return true;
    }
    public static void validarCodPostal(String codPostal) throws NumberFormatException, DatoNoValidoException{
        int CodPostal = Integer.parseInt(codPostal);
        if (codPostal.length() < 5){
            throw new DatoNoValidoException();
        }
    }
    public static void buscarDeElche(){
        StringBuilder listaElche = new StringBuilder();
        for (int x = 0; x < persona.size(); x++){
            if (persona.get(x).getCiudad()){
                listaElche.append(persona.toString()+"\n");
            }
        }
    }
}
