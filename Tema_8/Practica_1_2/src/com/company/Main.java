package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventoDAO;
import Modelo.UML.Evento;
import Vista.V1;
import Vista.VGuardaEvento;
import Vista.VModificarEvento;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    private static JFrame V1;
    private static JDialog VGuardar;
    private static JDialog VModificar;
    private static Evento evento;
    private static ArrayList<Evento> listaEventos;

    public static void main(String[] args) {
	    try {
            //Creació ventana menu principal:
            crearVentanaMenu();
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void crearVentanaMenu(){
        V1 = new JFrame("V1");
        V1.setContentPane(new V1().getpPrincipal());
        V1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        V1.setLocationRelativeTo(null);
        V1.pack();
        V1.setVisible(true);
    }
    public static void abrirVentanaGuardar(){
        VGuardar = new VGuardaEvento();
        VGuardar.pack();
        VGuardar.setLocationRelativeTo(null);
        VGuardar.setVisible(true);
        VGuardar.dispose();
    }
    public static void getDatosEvento(String nombre, String loc, LocalDate fecha, LocalTime horaI, LocalTime horaF, int aforo) throws Exception {
        //Crear objeto evento:
        evento = new Evento(nombre, loc, fecha, horaI, horaF, aforo);

        //Ejecutar guardado en BD:
        EventoDAO.GuardarEvento(evento);
    }
    public static String calcelarEvento(String nombre) throws Exception{
        //Consultar:
        evento = EventoDAO.consultarAcontecimiento(nombre);
        return evento.toString();
    }
    public static void borrarEvento() throws Exception{
        //EventoDAO.borrar(evento);
    }
    public static void abrirVentanaModificar(){
        VModificar = new VModificarEvento();
        VModificar.pack();
        VModificar.setVisible(true);
        VModificar.setLocationRelativeTo(null);
        VModificar.dispose();
    }
    public static ArrayList<String> datosLlenarComboBox() throws Exception{
        listaEventos = EventoDAO.consultarAcontecimientos();
        //Solo nombres a la ventana:
        ArrayList<String> nombres = new ArrayList<>();
        for (Evento a:listaEventos)
            nombres.add(a.getNombre());
        return nombres;
    }
    public static void getEventoSelec(int i){
        evento = listaEventos.get(i);
    }
    public static String getLoc(){
        return evento.getLoc();
    }
    public static String getFecha(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return evento.getFecha().format(formato);
    }
    public static String getHoraInit(){
        return evento.getHoraInicio().toString();
    }
    public static String getHoraFin(){
        return evento.getHoraFin().toString();
    }
    public static String getAforo(){
        return String.valueOf(evento.getNumPerso());
    }
    public static void getDatosActualizados(String loc, LocalDate fecha, LocalTime hInit,
                                            LocalTime hFin, int aforo) throws Exception{
        //Modificar objeto y mandarlo a la BD:
        evento.setLoc(loc);
        evento.setFecha(fecha);
        evento.setHoraInicio(hInit);
        evento.setHoraFin(hFin);
        evento.setNumPerso(aforo);

        //Actualizar y cerrar:
        EventoDAO.actualizar(evento);
    }
}
