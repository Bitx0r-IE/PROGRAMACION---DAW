package com.company;

import Modelo.Cliente;
import Modelo.Gato;
import Modelo.Perro;
import Modelo.Veterinario;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            do {

            }
            while (JOptionPane.showConfirmDialog(null, "¿Quiere continuar?")==0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listado = new ArrayList<>();
        //Crear clientes:
        listado.add(new Cliente("c1", "dir1", 111111111));
        listado.add(new Cliente("c2", "dir2", 222222222));
        listado.add(new Cliente("c3", "dir3", 333333333));
        return listado;
    }
    public static ArrayList<Gato> listaGatos(){
        ArrayList<Gato> lista = new ArrayList<>();
        //Crear gatos:
        lista.add(new Gato("Maine Coon", "g1", LocalDate.of(2016,1,23), "macho", 7, "largo",
                true, " ", false));
        lista.add(new Gato("Siames", "g1", LocalDate.of(2010,5,2), "hembra", 5, "corto",
                true, "alergia", true));
        lista.add(new Gato("Azul ruso", "g3", LocalDate.of(2018,7,14), "hembra", 6, "corto",
                true, " ", true));
        return lista;
    }
    public static ArrayList<Perro> listaPerros(){
        ArrayList<Perro> lista = new ArrayList<>();
        lista.add(new Perro("Labrador", "p1", LocalDate.of(2009,8,23), "macho", 33, "corto",
                false, "artritis", true));
        lista.add(new Perro("Border Collie", "p2", LocalDate.of(2015,3,12), "hembra", 33, "largo",
                true, " ", true));
        lista.add(new Perro("Labrador", "p3", LocalDate.of(2009,8,23), "macho", 33, "corto",
                false, "artritis", true));
        return lista;
    }
    public static ArrayList<Veterinario> listaVeterinario(){
        ArrayList<Veterinario> lista = new ArrayList<>();
        lista.add(new Veterinario("v1", "dir4", 444444444, "11111111A", 2222222));
        lista.add(new Veterinario("v2", "dir5", 555555555, "22222222B", 3333333));
        return lista;
    }
}
