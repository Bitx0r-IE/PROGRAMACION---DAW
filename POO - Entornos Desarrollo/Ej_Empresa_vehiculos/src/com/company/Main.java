package com.company;

import Modelo.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /**
         * Generar coches y motocicletas para comprobar el funcinamiento
         *
         * @author Victor Ibañez
         */
	    // write your code here
        coche c1 = new coche("1", 7, 500, "blanco", true);
        JOptionPane.showMessageDialog(null, c1.toString());

        coche c2 = new coche("1", 2, 500, "blanco", true);
        JOptionPane.showMessageDialog(null, c2.toString());

        motocicleta m1 = new motocicleta("2", 4 ,400, "azul", 150);
        JOptionPane.showMessageDialog(null, m1.toString());

        motocicleta m2 = new motocicleta("2", 4 ,400, "azul", 100);
        JOptionPane.showMessageDialog(null, m2.toString());
    }
}
