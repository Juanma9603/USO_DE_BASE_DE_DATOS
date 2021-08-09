package DAO;

import Entity.Categoria;
import Entity.DetallePrestamo;
import Entity.Libro;
import Entity.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePrestamoDAO {
    private Conexion con =new Conexion();

    public ArrayList<DetallePrestamo> getGetDetallePrestamo(int idPrestamo) throws Exception {
        ArrayList<DetallePrestamo> listDetallePrestamo = new ArrayList<DetallePrestamo>();
        try{
            String sql = "CALL sp_consultarDetallePrestamo(?)";
            PreparedStatement ps = con.getCon().prepareStatement(sql);
            ps.setInt(1,idPrestamo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listDetallePrestamo.add(
                        new DetallePrestamo(
                                0,
                                new Libro(0,new Categoria(), rs.getString(1), "","",0,""),
                                new Prestamo()
                        )
                );
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }finally {
            con.getCon().close();
            System.out.println("Close connection");
        }
        return listDetallePrestamo;
    }




}
