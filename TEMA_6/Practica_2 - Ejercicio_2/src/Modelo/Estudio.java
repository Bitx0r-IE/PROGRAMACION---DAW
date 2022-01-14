package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String dirWeb;
    private LocalDate fundacion;
    private String pais;
    private ArrayList<String> telefonos;

    //Constructor:

    public Estudio() {
    }

    public Estudio(String nombre, String ciudad, String direccion, String dirWeb, LocalDate fundacion, String pais, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirWeb = dirWeb;
        this.fundacion = fundacion;
        this.pais = pais;
        this.telefonos = telefonos;
    }

    //Sin telf:

    public Estudio(String nombre, String ciudad, String direccion, String dirWeb, LocalDate fundacion, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirWeb = dirWeb;
        this.fundacion = fundacion;
        this.pais = pais;
    }

    //set y get de los atributos:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public void setTelefono(String t){
        if (this.telefonos == null)
           this.telefonos.add(t);
    }
}
