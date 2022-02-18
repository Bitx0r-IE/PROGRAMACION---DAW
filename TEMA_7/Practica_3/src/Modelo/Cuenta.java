package Modelo;

public class Cuenta {
    private String numero;
    private float saldo;

    //Constructor:

    public Cuenta(String numero, float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    //get y set:

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
