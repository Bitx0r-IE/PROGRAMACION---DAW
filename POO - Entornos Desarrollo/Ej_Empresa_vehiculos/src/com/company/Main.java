package com.company;

import Modelo.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<coche> listacoche;

    public static void main(String[] args) {
	    // write your code here
        coche c1 = new coche("1", 2, 500, "blanco", true);
        JOptionPane.showMessageDialog(null, c1.toString());

        motocicleta m1 = new motocicleta("2", 4 ,400, "azul", 150);
        JOptionPane.showMessageDialog(null, m1.toString());
    }
}
