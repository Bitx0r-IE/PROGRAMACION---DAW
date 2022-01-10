package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int año;
    private int duracion;
    private String tipo;

    private ArrayList<Estudio> estudioProd;

    public Pelicula(String titulo, int año, int duracion, String tipo, ArrayList<Estudio> estudioProd) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.estudioProd = estudioProd;
    }

    public String getTitulo(String titulo){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

