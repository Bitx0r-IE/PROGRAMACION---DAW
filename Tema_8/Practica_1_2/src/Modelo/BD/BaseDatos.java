package Modelo.BD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    //Parametros de conexión:
    private String login = "root";
    private String password = "usbw";
    private String url = "jdbc:mysql://localhost:3306/practica_1_2";

    private Connection con;

    public BaseDatos() throws Exception{
        //Obtener Driver para mysql:
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Obterner conexión:
        con = DriverManager.getConnection(url, login, password);
        if (con == null){
            throw new Exception("Problemas con la conexión");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void cerrarBD(){
        try {
            con.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
}
