package Modelo;

import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private String descripcion;
    private float importe;

    //Constructor:

    public Movimiento(LocalDate fecha, String descripcion, float importe) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    //get y set:

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                '}';
    }
}
