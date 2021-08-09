package DAO;

import Entity.DetallePrestamo;
import Entity.Persona;
import Entity.Prestamo;
import Entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PrestamoDAO {
    Conexion con=new Conexion();

    public Prestamo Consultar(int ID)throws Exception{
        Prestamo objprestamo=new Prestamo();
        try {
            String sql = "CALL sp_consultarPrestamo (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                objprestamo=new Prestamo(
                        rs.getInt("Id_Prestamo"),
                        new Usuario(rs.getInt("Id_Usuario"),new Persona(),"","",""),
                        rs.getString("Date_prestamo"),new ArrayList<>()
                );
            }
        }catch (Exception e){
            System.out.println("SQL ERROR"+e);
        }finally {
            con.getCon().close();
        }
        return objprestamo;
    }

    public ArrayList<DetallePrestamo> getlistdetallePrestamo(Prestamo objprestamo) throws Exception{
        ArrayList<DetallePrestamo> lisDetallePrestamo =new ArrayList<>();
        //boolean bandera;
        //int j=6;
        try {
            String sql="CALL sp_registroPrestamo(?,?,?,?,?,?)";
            PreparedStatement ps =con.getCon().prepareStatement(sql);
            ps.setInt(1,objprestamo.getobjusuario().getID());
            ps.setInt(2,objprestamo.getListdetalle().get(0).getObjlibro().getID());
            int sizeLst = objprestamo.getListdetalle().size();
            int pendiente = 5-sizeLst;
            System.out.println("Size: "+sizeLst);
            System.out.println("Pendiete: "+pendiente);
            for(int i=1;i<sizeLst;i++){
                ps.setInt((i+2),objprestamo.getListdetalle().get(i).getObjlibro().getID());
                System.out.println("indice: "+(i+2)+" - IDLibro: "+objprestamo.getListdetalle().get(i).getObjlibro().getID());
            }
            for (int j=1;j<=pendiente;j++){
                ps.setInt((j+sizeLst+1),0);
                System.out.println("indice: "+(j+sizeLst+1)+" - IDLibro: 0");
            }
            ps.execute();
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+ err);
        }
        return lisDetallePrestamo;
    }

    public void Modificar(Prestamo objprestamo){
        try {
            String sql="CALL sp_prestamoUPDATE (?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objprestamo.getID());
            ps.setInt(2, objprestamo.getobjusuario().getID());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_prestamoDELETE(?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public ArrayList<Prestamo> list() throws Exception{
        ArrayList<Prestamo> listPrestamo=new ArrayList<Prestamo>();
        try {
            Statement stmt=con.getCon().createStatement();
            ResultSet rs= stmt.executeQuery("CALL sp_listarPrestamo");
            while (rs.next()){
                    Prestamo objTmpPrestamo=new Prestamo(
                            rs.getInt(1),
                            new Usuario(rs.getInt("Id_Usuario"),new Persona(),"","",""),
                            rs.getString(3),new ArrayList<>()
                    );
                    listPrestamo.add(objTmpPrestamo);
            }
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return listPrestamo;
    }
}
