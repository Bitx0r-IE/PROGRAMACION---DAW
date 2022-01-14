package com.company;

import Modelo.*;
import org.omg.CORBA.FREE_MEM;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Empleado> listaEmpleados;
    private static ArrayList<Cliente> listaClientes;
    private static ArrayList<Directivo> listaDirectivos;

    public static void main(String[] args) {
        // try catch generico:
        try {
            crearPersona();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void crearPersona(){
        //Empleados:
        listaEmpleados = new ArrayList();
        //Empleado 1:
        listaEmpleados.add(new Empleado("Pepe", 19, 12000));
        //Empleado 2:
        listaEmpleados.add(new Empleado("Juan", 27, 15000));
        //Empleado 3:
        listaEmpleados.add(new Empleado("Manolo", 39, 16000));
        //Empleado 4:
        listaEmpleados.add(new Empleado("Leire", 30, 16000));

        //Clientes:
        listaClientes = new ArrayList();
        //Cliente 1:
        listaClientes.add(new Cliente("Pepa", 52, 111111111));
        //Cliente 2:
        listaClientes.add(new Cliente("Juana", 80, 222222222));
        //Cliente 3:
        listaClientes.add(new Cliente("Eugenio", 60, 333333333));

        //Directivos:
        listaDirectivos = new ArrayList();
        //Directivo 1:
        listaDirectivos.add(new Directivo("Michael", 40, 30000, "directivo"));
    }
}
