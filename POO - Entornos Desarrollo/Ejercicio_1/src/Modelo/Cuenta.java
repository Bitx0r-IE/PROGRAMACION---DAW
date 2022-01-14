package Modelo;

public class Cuenta {
    private String titular;
    private double cantidad;

    //Contructor son cantidad:
    public Cuenta(String titular) {
        this.titular = titular;
    }

    //Contructor con ambos atributos:
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        //Condicional en caso de que cantitidad intrcida sea negativo:
        if (cantidad < 0){
            this.cantidad = 0;
        }
        else{
            this.cantidad = cantidad;
        }
    }

    //set y get:
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void ingresar(double cantidad){
        if (cantidad > 0){
            this.cantidad += cantidad;
        }
    }

    public void retirar(double cantidad){
        if (this.cantidad - cantidad < 0){
            this.cantidad = 0;
        }
        else{
            this.cantidad -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
