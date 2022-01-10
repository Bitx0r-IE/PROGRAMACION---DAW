package Modelo;

import javax.swing.*;

public class Pelicula {
    private String titulo;
    private int año;
    private int duracion;
    private String tipo;

    public Pelicula(String titulo, int año, int duracion, String tipo) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getTitulo(String titulo){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

