package Modelo.UML;

import java.util.ArrayList;

public class Persona {
    private String nomApell;
    private String email;
    private String dni;
    private int telf;

    //Relaciones entre clases:

    private ArrayList<Evento> listaEventos;
    private Empresa empresa;

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(Evento evento) {
        this.listaEventos.add(evento);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    //Constructor:

    public Persona(String nomApell, String email, String dni, int telf, ArrayList<Evento> listaEventos, Empresa empresa) {
        this.nomApell = nomApell;
        this.email = email;
        this.dni = dni;
        this.telf = telf;
        this.listaEventos = listaEventos;
        this.empresa = empresa;
    }

    public Persona(){
        listaEventos = new ArrayList<>();
    }

    //get y set:

    public String getNomApell() {
        return nomApell;
    }

    public void setNomApell(String nomApell) {
        this.nomApell = nomApell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }
}
