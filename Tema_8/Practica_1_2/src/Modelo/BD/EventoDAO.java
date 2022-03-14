package Modelo.BD;

import Modelo.UML.Evento;

import javax.xml.stream.events.StartDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EventoDAO {

    private static PreparedStatement sentenciaBase;
    private static String base;
    private static Statement sentencia;

    private static void GuardarEnvent(Evento evento) throws Exception {

        BaseDatos.BaseDatos();

        base = "INSERT INTO practica_1_2 VALUES(?, ?, ?, ?, ?)";
        sentenciaBase = BaseDatos.getCon().prepareStatement(base);
        //filas:

    }
}
