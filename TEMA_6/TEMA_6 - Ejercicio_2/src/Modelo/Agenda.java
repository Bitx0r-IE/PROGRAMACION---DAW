package Modelo;

public class Agenda {
    private String nombre;
    private String codigo;
    private String telf;
    private String dir;

    public Agenda(String nombre, String codigo, String telf, String dir) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.telf = telf;
        this.dir = dir;
    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelf(){
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getDir(){
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", telf='" + telf + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }
}


