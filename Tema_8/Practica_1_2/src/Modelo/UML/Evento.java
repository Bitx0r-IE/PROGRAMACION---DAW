package Modelo.UML;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String nombre;
    private String loc;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int numPerso;

    //Constructor:

    public Evento(String nombre, String loc, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int numPerso) {
        this.nombre = nombre;
        this.loc = loc;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.numPerso = numPerso;
    }

    //get y set:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getNumPerso() {
        return numPerso;
    }

    public void setNumPerso(int numPerso) {
        this.numPerso = numPerso;
    }
}
