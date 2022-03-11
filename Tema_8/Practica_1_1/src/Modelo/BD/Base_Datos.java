package Modelo.BD;

import Excepciones.DatoNoValido;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Base_Datos {
    static Connection connection;
    private String url = "jdbc:mysql://localhost:3307/practica_1";
    private String user = "root";
    private String passwd = "usbw";

    public Base_Datos() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url, user, passwd);

        if (!connection.isValid(2)){
            throw new DatoNoValido("Problemas con la base de datos");
        }
    }

    public static void cerrarBD() throws Exception {
        connection.close();
    }

    //get set connection:

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
