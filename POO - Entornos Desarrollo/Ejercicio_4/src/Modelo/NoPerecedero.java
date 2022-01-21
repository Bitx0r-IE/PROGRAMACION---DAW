package Modelo;

public class NoPerecedero extends Productos{
    private String tipo;

    //Constructor:

    public NoPerecedero(String nombre, float precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //get y set:

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

}
