package Modelo.BD;

import Modelo.UML.Evento;

import javax.xml.stream.events.StartDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class EventoDAO {

    private static PreparedStatement sentenciaPrep;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;

    private static void GuardarEnvento(Evento evento) throws Exception {

        //Abrir la conexión:
        BaseDatos.BaseDatos();

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
}
