package Modelo.BD;

import Modelo.UML.Evento;

import javax.xml.stream.events.StartDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventoDAO {

    private static Evento evento;
    private static PreparedStatement sentenciaPrep;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;

    public static void GuardarEvento(Evento evento) throws Exception {

        //Abrir la conexión:
        BaseDatos.abrirBD();

        //Preparar la sentencia sql que se quiere ejecutar:
        plantilla = "INSERT INTO (nombre, loc, fecha, horaInicio, horaFin, numPerso) practica_1_2 VALUES(?, ?, ?, ?, ?)";
        sentenciaPrep = BaseDatos.getCon().prepareStatement(plantilla);
        //filas:
        sentenciaPrep.setString(1, evento.getNombre());
        sentenciaPrep.setString(2, evento.getLoc());
        sentenciaPrep.setDate(3, conversionDate(evento.getFecha()));
        sentenciaPrep.setTime(4, conversionTime(evento.getHoraInicio()));
        sentenciaPrep.setTime(5, conversionTime(evento.getHoraFin()));
        sentenciaPrep.setInt(6, evento.getNumPerso());

        //Ejecutar la sentencia:
        int n = sentenciaPrep.executeUpdate();
        System.out.println(n + "filas insertadas");

        //cerrar conexión:
        BaseDatos.cerrarBD();
    }

    public static java.sql.Date conversionDate(LocalDate fecha){
        //Conversión LocalDate en java.sql.Date:
        return java.sql.Date.valueOf(fecha);
    }

    public static java.sql.Time conversionTime(java.time.LocalTime hora){
        //Conversión java.sql.Time en java.time.Time:
        return java.sql.Time.valueOf(hora);
    }
    public static Evento consultarAcontecimiento(String n) throws Exception{
        //Consultar en la base de datos:
        BaseDatos.abrirBD();

        plantilla = "SELECT * FROM EVENTO WHERE NOMBRE = ?";
        sentenciaPrep = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPrep.setString(1, n);

        resultado = sentenciaPrep.executeQuery();
        if (resultado.next()){
            crearObjeto();
        }
        else
            throw new Exception("No hay ningún acontecimiento con ese nombre");

        BaseDatos.cerrarBD();

        return evento;
    }
    public static void crearObjeto() throws Exception{
        //evento = new Evento();

        evento.setNombre(resultado.getString("nombre"));
        evento.setLoc(resultado.getString("loc"));
        // de java.sql.Date a LocalDate:
        // LocalDate f = resultado.getDate("fecha").toLocalDate(); //yyyy-mm-dd
        String fe = new SimpleDateFormat("dd/MM/yyyy").format(resultado.getDate("fecha")); // paso a String
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fe, formato);

        // System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(resultado.getDate("fecha")));

        evento.setFecha(fecha);
        evento.setHoraInicio(resultado.getTime("horaInicio").toLocalTime());
        evento.setHoraFin(resultado.getTime("horaFin").toLocalTime());
        evento.setNumPerso(resultado.getInt("numPerso"));
    }
    public static void borrar(Evento e) throws Exception{
        //Metodo para borrar un evento de la BD:
        BaseDatos.abrirBD();
        plantilla = "delete from evento where nombre = ?";
        sentenciaPrep = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPrep.setString(1, e.getNombre());

        int n = sentenciaPrep.executeUpdate();
        if (n == 0)
            throw new Exception();
        System.out.println(n + " filas borradas");
        // Cerrar la conexión:
        BaseDatos.cerrarBD();
    }
    public static ArrayList<Evento> consultarAcontecimientos() throws Exception{
        //Metodo para consultar un evento de la BD:
        BaseDatos.abrirBD();
        plantilla = "select * from evento";
        sentenciaPrep = BaseDatos.getCon().prepareStatement(plantilla);
        //Puede ser un Statement
        resultado = sentenciaPrep.executeQuery();
        ArrayList<Evento> lista = new ArrayList<>();
        while (resultado.next()){
            crearObjeto();
            lista.add(evento);
        }
        BaseDatos.cerrarBD();
        return lista;
    }
    public static void actualizar(Evento e) throws Exception {
        //Metodo save:
        //Abrir conexión
        BaseDatos.abrirBD();

        plantilla = "update evento set loc = ?, fecha = ?, horaInicio = ?, horaFin = ?, numPerso = ? where nombre = ?";
        sentenciaPrep = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPrep.setString(6, e.getNombre());
        sentenciaPrep.setString(1, e.getLoc());
        sentenciaPrep.setDate(2, conversionDate(e.getFecha()));
        sentenciaPrep.setTime(3, conversionTime(e.getHoraInicio()));
        sentenciaPrep.setTime(4, conversionTime(e.getHoraFin()));
        sentenciaPrep.setInt(5, e.getNumPerso());

        //Ejecutar sentencia:
        int n = sentenciaPrep.executeUpdate();
        System.out.println(n + " filas modificadas");

        //Cerrar conexión:
        BaseDatos.cerrarBD();
    }
}
