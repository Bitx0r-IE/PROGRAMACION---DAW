package com.company;

import Modelo.Libro;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    // Crear libros:
        Libro libro1 = new Libro(1111, "El ritmo de la guerra", "Brandon Sanderson", 1376);
        Libro libro2 = new Libro(2222, "El ojo del mundo", "Robert Jordan", 800);

        //to String:
        JOptionPane.showMessageDialog(null, libro1.toString() + "\n" + libro2.toString());

        //Comparar num paginas de los libros:
        if (libro1.getNumPaginas() > libro2.getNumPaginas()){
            JOptionPane.showMessageDialog(null, libro1.getTitulo() + " tiene más páginas que " + libro2.getTitulo());
        }
        else{
            JOptionPane.showMessageDialog(null, libro2.getTitulo() + " tiene más páginas que " + libro1.getTitulo());
        }
    }
}
