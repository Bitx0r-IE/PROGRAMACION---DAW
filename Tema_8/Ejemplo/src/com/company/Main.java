package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. Cargar el controlador de acceso a datos:
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Conectarse a la base de Datos:
            // String url = "jdbc:mysql://[url]/[nombre de la base de datos]";
            String url = "jdbc:mysql://localhost:3307/prueba";
            String user = "root";
            String passwd = "usbw";
            Connection con = DriverManager.getConnection(url, user, passwd);

            // 3. Construir comandos SQL:
            Statement sentencia = con.createStatement();
            String s = "insert into tablauno values ('1111111B', 'pepe')";
            sentencia.executeUpdate(s);

            // 4. Cerrar:
            con.close();
        }
        catch (Exception e){
            System.out.println("Problemas con la base de datos " + e.getMessage());
        }
    }
}
