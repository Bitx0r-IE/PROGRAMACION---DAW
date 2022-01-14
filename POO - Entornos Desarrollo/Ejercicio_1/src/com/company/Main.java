package com.company;

import Modelo.Cuenta;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {;

        Cuenta paco = new Cuenta("Paco", 300000);
        Cuenta capo = new Cuenta("Pipo", 1000000);
        Cuenta leire = new Cuenta("Leire", 60000);

        JOptionPane.showMessageDialog(null, paco.toString() + "\n" + capo.toString() + "\n" +
                                        leire.toString());

        //Ingresar dinero:
        paco.ingresar(1777);
        capo.ingresar(500);
        leire.ingresar(40000);

        //Retirar dinero:
        capo.retirar(20000);
        paco.retirar(130000);

        //Mostrar resultados:
        JOptionPane.showMessageDialog(null, "Resultados tras cambios \n" + "\n" +paco.toString() +
                                        capo.toString() + "\n" + leire.toString());
    }
}
