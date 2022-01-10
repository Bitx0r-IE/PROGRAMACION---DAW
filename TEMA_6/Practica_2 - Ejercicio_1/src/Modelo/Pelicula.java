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

    public int getAño(int año){
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion(int duracion){
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo(String tipo){
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

