package Modelo;

import java.util.ArrayList;

public class Cuenta {
    private String numero;

    private ArrayList<Movimiento> listaMovimientos;
    //Constructor:

    public Cuenta(String numero) {
        this.numero = numero;
        listaMovimientos = new ArrayList<>();
    }

    //get y set:

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public void setMovimiento(Movimiento m){
        listaMovimientos.add(m);
    }

    public Movimiento getMovimiento(int x){
        return listaMovimientos.get(x);
    }

    public Double getSaldo(){/*Al saldo 0.0 se le suman los movimientos y*/
        Double saldo = 0.0;
        for (int x = 0; x < listaMovimientos.size(); x++)
            saldo += listaMovimientos.get(x).getImporte();
        return saldo;
    }
}
