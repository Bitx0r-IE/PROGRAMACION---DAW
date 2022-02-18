package Modelo;

import java.util.ArrayList;

public class Cuenta {
    private String numero;

    private ArrayList<Movimiento> listaMovimientos;
    //Constructor:

    public Cuenta(String numero) {
        this.numero = numero;

    }

    //get y set:

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
