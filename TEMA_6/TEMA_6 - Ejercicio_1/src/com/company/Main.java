package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    /*Escribe un prgorama que pidalos datos necerarios para calcular la longitud de una circunferencia (2 * PI * radio),
	    * su área (PI * radio * radio) y el volumen de una esfera (4 * PI * radio * radio * radio/3)*/
        try{
            Circunferencia newCircunf = new Circunferencia(23);
            // MENSAJE:
            JOptionPane.showMessageDialog(null, "Circunferencia de radio ->:");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
}
