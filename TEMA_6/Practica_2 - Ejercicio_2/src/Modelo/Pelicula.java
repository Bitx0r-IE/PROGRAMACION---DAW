package Modelo;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int año;
    private float duracion;
    private String tipo;
    //Relación: Estudio - Pelicula --> Pelicula producida por varios estudios
    private ArrayList<Estudio> estudiosCine;

    //Constructor:
    public Pelicula(String titulo, int año, float duracion, String tipo, ArrayList<Estudio> estudiosCine) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.estudiosCine = estudiosCine;
    }

    // get y set de los atributos:
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getAño (){
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getEstudiosCine() {
        return estudiosCine;
    }

    public void setEstudiosCine(ArrayList<Estudio> estudiosCine) {
        this.estudiosCine = estudiosCine;
    }

}
