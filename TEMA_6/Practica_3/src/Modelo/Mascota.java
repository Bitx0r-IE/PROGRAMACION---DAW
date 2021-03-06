package Modelo;

public class Mascota {
    private String raza;
    private String nombre;
    private String fecha_nac;
    private String sexo;
    private float peso;
    private String tipoPelo;

    private Cliente dueño;
    private Veterinario vet;

    //Constructor:
    public Mascota(String raza, String nombre, String fecha_nac, String sexo, float peso, String tipoPelo) {
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

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
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

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Veterinario getVet() {
        return vet;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }
}
