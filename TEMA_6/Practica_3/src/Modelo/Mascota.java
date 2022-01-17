package Modelo;

import java.time.LocalDate;

public class Mascota {
    private String tipo;
    private String raza;
    private String nombre;
    private LocalDate fecha_nac;
    private String sexo;
    private float peso;
    private String tipoPelo;

    //Constructor:
    public Mascota(String raza, String nombre, LocalDate fecha_nac, String sexo, float peso, String tipoPelo) {
        this.raza = raza;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.peso = peso;
        this.tipoPelo = tipoPelo;
    }

    //get y set:

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    //Mostrar datos del cliente:
    public String getDueño(Cliente dueño) {
        return Cliente.toString();
    }
}
