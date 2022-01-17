package Modelo;

import java.time.LocalDate;

public class Gato extends Mascota{
    private boolean casero;
    private String enfCronica;
    private boolean castrado;

    //Constructor:
    public Gato(String raza, String nombre, LocalDate fecha_nac, String sexo, float peso,
                String tipoPelo, boolean casero, String enfCronica, boolean castrado) {
        super(raza, nombre, fecha_nac, sexo, peso, tipoPelo);
        this.casero = casero;
        this.enfCronica = enfCronica;
        this.castrado = castrado;
    }

    //set y get:

    public boolean isCasero() {
        return casero;
    }

    public void setCasero(boolean casero) {
        this.casero = casero;
    }

    public String getEnfCronica() {
        return enfCronica;
    }

    public void setEnfCronica(String enfCronica) {
        this.enfCronica = enfCronica;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
