package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String direccionWeb;
    private LocalDate fundacion;
    private String pais;

    private ArrayList<String> telefonos;

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, LocalDate fundacion, String pais, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.fundacion = fundacion;
        this.pais = pais;
        this.telefonos = telefonos;
    }

    //get  set  de los atributos

    public String getNombre (String nombre){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad(String ciudad){
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion(String direccion){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccionWeb(String direccionWeb){
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    public int getFundacion(int fundacion){
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public String getPais(String pais){
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
