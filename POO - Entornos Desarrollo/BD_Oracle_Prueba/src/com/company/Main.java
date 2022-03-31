package com.company;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	    try {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String user = "daw25";
            String passwd = "daw25";
            Connection con = DriverManager.getConnection(url, user, passwd);
            
            CallableStatement c = con.prepareCall("{call datos_emp25_scott_v2(?,?)}");
            c.setInt(1, 1800);
            c.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);

            c.execute();
            ResultSet rs = (ResultSet)c.getObject(2);
            while (rs.next()){
                System.out.println(rs.getString(2));
            }
            rs.close();
            c.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
