package Modelo;

public class Perecedero extends Productos{
    private int diasCaducar;

    //Constructor:

    public Perecedero(String nombre, float precio, int diasCaducar) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    //get y set:

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasCaducar=" + diasCaducar +
                '}';
    }

}
