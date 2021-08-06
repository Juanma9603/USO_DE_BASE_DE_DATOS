package DAO;

import com.mysql.cj.jdbc.Driver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion implements Serializable {
    private Connection con=null;

    public Conexion(){
    con=Conexion.Conectar();
    }

    public Connection getCon() {

        return con;
    }

    public static Connection Conectar(){
        Connection c=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","123456789");
            System.out.println("Conectado");

        }catch (Exception e){
            System.out.println("SQL Error"+e);
        }
        return c;
    }
}
