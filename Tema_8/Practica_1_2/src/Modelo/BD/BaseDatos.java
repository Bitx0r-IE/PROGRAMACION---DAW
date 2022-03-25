package Modelo.BD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    //Parametros de conexión:
    private static String login = "root";
    private static String password = "usbw";
    private  static String url = "jdbc:mysql://localhost:3306/practica_1_2";

    private static Connection con;

    public static void abrirBD() throws Exception{
        //Obtener Driver para mysql:
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Obterner conexión:
        con = DriverManager.getConnection(url, login, password);
        if (con == null){
            throw new Exception("Problemas con la conexión");
        }
    }

    public static Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public static void cerrarBD(){
        try {
            con.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
}
