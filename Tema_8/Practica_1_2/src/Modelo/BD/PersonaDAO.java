package Modelo.BD;

import Modelo.UML.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonaDAO {
    //Clase que contine los métodos de la tabla personas:

    private static PreparedStatement sentenciaPred;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;

    private static Persona queryByDni (Persona p) throws Exception{
        BaseDatos.abrirBD();

        plantilla = "select * from personas where dni = ?";
        sentenciaPred = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPred.setString(1, persona.getDni);
    }
}
