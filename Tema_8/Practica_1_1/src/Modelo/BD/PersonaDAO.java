package Modelo.BD;

import Modelo.UML.Persona;
import com.company.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PersonaDAO {
    //Contiene los métodos que manipulan la tabla
    //objeto de acceso a datos (en inglés, data acccess object, abreviado DAO)

    private Connection con;

    public PersonaDAO(Connection con) {
        this.con = con;
    }

    public static void crearPerso(String text, String tfNombreText, String tfProfesionText, String tfTelefonoText) throws Exception {
        String edad = text;
        String nombre = tfNombreText;
        String prof = tfProfesionText;
        String telf = tfTelefonoText;
        Persona persona = (new Persona(nombre, edad, prof, telf));
        insertarPersona(persona);
    }
    public static void insertarPersona(Persona persona) throws Exception {
        Base_Datos conex = new Base_Datos();
        //Crear el insert de la nueva persona:
        String s = "INSERT INTO practica_1 VALUES(?, ?, ?, ?)";
        //Teoría de Prepared Statement, apuntes pg 11
        PreparedStatement ps = conex.con.prepareStatement(s);
        //Ejecutar el insert
        ps.setString(1, persona.getNombre());
        ps.setString(2, persona.getEdad());
        ps.setString(3, persona.getProfesion());
        ps.setString(4, persona.getTelefono());
        int n = ps.executeUpdate();
        if (n!=1){
            throw new Exception("El número de filas actualizadas no es 1");
        }
    }
    public static void opcion1(){
        Main.mostrarVentanaPersonas();
    }
    public static void opcion2(){
        Main.mostrarVentanaPersonas();

    }
    public static void opcion3(){
        Main.mostrarVentanaPersonas();
    }
}
