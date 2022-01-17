package Modelo;

import java.time.LocalDate;

public class Perro extends Mascota{
    private boolean castrado;
    private String enfCronica;
    private boolean chip;

    //Constructor:
    public Perro(String tipo, String raza, String nombre, LocalDate fecha_nac, String sexo, String peso,
                 String tipoPelo, boolean castrado, String enfCronica, boolean chip) {
        super(tipo, raza, nombre, fecha_nac, sexo, peso, tipoPelo);
        this.castrado = castrado;
        this.enfCronica = enfCronica;
        this.chip = chip;
    }

    //get y set:
    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getEnfCronica() {
        return enfCronica;
    }

    public void setEnfCronica(String enfCronica) {
        this.enfCronica = enfCronica;
    }

    public boolean isChip() {
        return chip;
    }

    public void setChip(boolean chip) {
        this.chip = chip;
    }
}
