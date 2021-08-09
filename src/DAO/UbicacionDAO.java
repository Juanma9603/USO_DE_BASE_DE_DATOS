package DAO;

import Entity.Ubicacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UbicacionDAO {
    Conexion con=new Conexion();

    public Ubicacion Consultar(int ID)throws Exception{
        Ubicacion objubicacion =new Ubicacion();

        try {
            String sql="CALL sp_consultarUbicacion (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                objubicacion=new Ubicacion(
                        rs.getInt("Id_Ubicacion"),
                        rs.getString("Pais"),
                        rs.getString("Region"),
                        rs.getString("Ciudad")
                );
            }
        }catch (SQLException e){
            System.out.println("SQL ERROR: "+e);
        }finally {
            con.getCon().close();
        }
        return objubicacion;
    }

    public void Registrar(Ubicacion objubicacion){
        try {
            String sql="CALL sp_ubicacionINSERT(?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setString(1,objubicacion.getPais());
            ps.setString(2, objubicacion.getRegion());
            ps.setString(3, objubicacion.getCiudad());
            ps.execute();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Modificar(Ubicacion objubicacion){
        try {
            String sql="CALL sp_ubicacionUPDATE(?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objubicacion.getID());
            ps.setString(2, objubicacion.getPais());
            ps.setString(3,objubicacion.getRegion());
            ps.setString(4,objubicacion.getCiudad());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_ubicacionDELETE(?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }

    }

    public ArrayList<Ubicacion> list() throws Exception{
        ArrayList<Ubicacion> listUbicacion=new ArrayList<Ubicacion>();
        try {
            Statement stmt =con.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("CALL sp_listarUbicacion();");
            while (rs.next()){
                Ubicacion objtmpUbicacion=new Ubicacion(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                listUbicacion.add(objtmpUbicacion);
            }
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return listUbicacion;
    }


}
