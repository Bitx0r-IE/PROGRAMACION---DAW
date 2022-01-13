package com.company;
import java.util.ArrayList;
import Modelo.*;

import javax.swing.*;

public class Main {

    private static Estudio[] estudioProd;

    private static ArrayList<Pelicula> listaPelis;

    public static void main(String[] args) {
	    // write your code here
        try {
            createEstudio();
            createPelicula();
            createTelefono();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void createPelicula(){

    }
    public static void createTelefono(){

    }
    public static void createEstudio(){
        estudioProd = new Estudio[5];
        ArrayList<String> telefonos = new ArrayList();
        telefonos.add("1111111111");
        telefonos.add("1234444166");
    }
}
