package Modelo.BD;

import Modelo.UML.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpresaDAO {
    //Contiene los métodos de la tabla empresas
    private static PreparedStatement sentenciaPred;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;

    public static Empresa queryByNombre(String nombre) throws Exception{
      //Comprobar si la base de datos está abierta:
        if (BaseDatos.getCon() == null)
            BaseDatos.abrirBD();

        plantilla = "select * from empresas where nombre = ?";
        sentenciaPred = BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPred.setString(1, nombre);
        resultado = sentenciaPred.executeQuery();

        resultado.next();

        //Crear objeto empresa:
        Empresa empresa = new Empresa();
        empresa.setNombre(resultado.getString("nombre"));
        empresa.setLoc(resultado.getString("direccion"));

        resultado.close();

        return empresa;
    }
    public static void altaEmpresa(Empresa empresa) throws Exception{
        try {
            BaseDatos.abrirBD();
            plantilla = "INSERT INTO empresas VALUES (?, ?)";
            sentenciaPred = BaseDatos.getCon().prepareStatement(plantilla);
            sentenciaPred.setString(1, empresa.getNombre());
            sentenciaPred.setString(2, empresa.getLoc());

            sentenciaPred.executeUpdate();

            BaseDatos.cerrarBD();
        }
        catch (java.sql.SQLIntegrityConstraintViolationException e){
            //La empresa no es un problema, ya existe
            //El resto de excepciones si se relanzan
            BaseDatos.cerrarBD();
        }
    }
}
