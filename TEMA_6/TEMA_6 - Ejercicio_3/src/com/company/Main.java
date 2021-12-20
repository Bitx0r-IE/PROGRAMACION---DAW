package com.company;

import Excepciones.AñoNoValidoException;
import Excepciones.CampoNoRellenoException;
import Excepciones.CodigoNoValidoException;
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
            buscadorMayorEdad();
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
        validarDireccion(dir);

        String codPostal = JOptionPane.showInputDialog("Código postal: ");
        validarCodPostal(codPostal);

        String ciudad = JOptionPane.showInputDialog("Ciudad: ");
        validarCiudad(ciudad);

        //Añadir los datos del alumno a la clase persona:
        Persona a = new Persona(nombre, dNacimiento, mNacimiento, aNacimiento, dir, codPostal, ciudad);

        //Añadir la nueva persona creado en el la lista arrayList:
        persona.add(a);
    }

    public static void validarNombre(String nombre){
        boolean problemas = true;
        do {
            try {
                if (nombre.isEmpty()){
                    throw new DatoNoValidoException();
                }
                problemas = false;
            }
            catch (DatoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: campo obligatio no completado");
            }
        }
        while (problemas);
    }
    public static int pediDia(){
        boolean problemas = true;
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
        boolean problemas = true;
        do{
            try {
                //Comprobar existencia, tamaño y que sea un dato numérico:
                if (codPostal.isEmpty()){
                    throw new CampoNoRellenoException();
                }
                if (codPostal.length() != 5){
                    throw new CodigoNoValidoException();
                }
                Integer.parseInt(codPostal);
            }
            catch (CampoNoRellenoException e){
                JOptionPane.showMessageDialog(null, "ERROR: El campo es obligatorio");
            }
            catch (CodigoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: código introducido no válido, tmaño incorrecto");
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: El código postal tiene que ser numérico");
            }
        }
        while (problemas);
    }
    public static void validarCiudad(String ciudad){
        boolean problemas = true;
        do {
            try {
                if (ciudad.isEmpty()){
                    throw new CampoNoRellenoException();
                }
                problemas = false;
            }
            catch (CampoNoRellenoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Campo obligatorio sin completar");
            }
        }
        while (problemas);
    }
    /*validarCiudad y validarDireccion son identicos, solo realizan la funcion de comprobar se el campo está vacío,
    * pero están tienen funciones d e validación diferentes en caso de que en alguno de ellos se necesiten nuevas
    * especificaciones de validación*/
    public static void validarDireccion(String dir){
        boolean problemas = true;
        do {
            try {
                if (dir.isEmpty()){
                    throw new CampoNoRellenoException();
                }
                problemas = false;
            }
            catch (CampoNoRellenoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Campo obligatorio sin completar");
            }
        }
        while(problemas);
    }
    public static void buscadorMayorEdad(){
        int mayor = 0;
        int posMayor = 0;
        String nombreElche = "";
        StringBuilder listadoNombresMayor = new StringBuilder();

        //Durante la duración del bucle se buscarán los tres apartados que pide el ejercicio:
        for (int x = 0; x < persona.size(); x++){
            //Calcular la posición del mayor de edad:
            //La edad se calcula con .calcularEdad(), previamente creado en el Pesona
            int edad = persona.get(x).calcularEdad();
            if (edad > mayor){
                posMayor = x;
                mayor = edad;
            }
            //Buscar a personas que vivan en Elche:
            if (persona.get(x).isCiudad("Elche")){
                nombreElche += persona.get(x).getNombre() + "\n";
            }
            //Buscar mayores de edad:
            if (persona.get(x).mayorEdad()){
                listadoNombresMayor.append(persona.get(x).getNombre()).append("\n");
            }
        }
        //Mostrar resultados de las busquedas:
        mostrarBusqueda(mayor, posMayor, nombreElche, listadoNombresMayor);
    }
    public static void  mostrarBusqueda(int mayor, int posMayor, String nombreElche, StringBuilder listadoNombresMayor){
        //Persona más mayor de la lista:
        JOptionPane.showMessageDialog(null, "La persona más mayor es: "
                + persona.get(posMayor).getNombre() + "\n" + "Edad: " + mayor + " años");

        //Personas de Elche:
        if (nombreElche.compareTo("")==0){
            JOptionPane.showMessageDialog(null, "En el Elche viven: ");
        }
        else{
            JOptionPane.showMessageDialog(null, "En Elche viven: " + nombreElche);
        }

        //Personas mayores de edad:
        if (listadoNombresMayor.toString().compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Personas mayores de edad: ");
        }
        else {
            JOptionPane.showMessageDialog(null, "Personas mayores de edad: " + listadoNombresMayor);
        }
    }
}
