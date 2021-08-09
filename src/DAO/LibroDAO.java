package DAO;

import Entity.Categoria;
import Entity.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO {
    Conexion con=new Conexion();

    public Libro Consultar(int ID)throws Exception{
        Libro objLibro=new Libro();
        try {
            String sql="CALL sp_consultarLibro ();";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                objLibro=new Libro(
                        rs.getInt("Id_Libro"),
                        new Categoria(rs.getInt("Id_Categoria"),"",""),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Editorial"),
                        rs.getInt("Volumen"),
                        rs.getString("Tema")
                );
            }
        }catch (SQLException er){
            System.out.println("SQL ERROR: "+er);
        }finally {
            con.getCon().close();
        }
        return objLibro;
    }

    public void Registrar(Libro objlibro){
        try {
            String sql="CALL sp_libroINSERT (?,?,?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objlibro.getobjcategoria().getID());
            ps.setString(2,objlibro.getTitle());
            ps.setString(3, objlibro.getAuthor());
            ps.setString(4,objlibro.getEditorial());
            ps.setInt(5,objlibro.getVolumen());
            ps.setString(6, objlibro.getTema());
            ps.execute();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Modificar(Libro objlibro){
        try {
            String sql="CALL sp_libroUPDATE(?,?,?,?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objlibro.getID());
            ps.setInt(2,objlibro.getobjcategoria().getID());
            ps.setString(3,objlibro.getTitle());
            ps.setString(4, objlibro.getAuthor());
            ps.setString(5, objlibro.getEditorial());
            ps.setInt(6, objlibro.getVolumen());
            ps.setString(7, objlibro.getTema());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_libroDELETE(?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public ArrayList<Libro> list () throws Exception{
        ArrayList<Libro> listLibro=new ArrayList<Libro>();
        try {
            Statement stmt=con.getCon().createStatement();
            ResultSet rs= stmt.executeQuery("CALL sp_listarLibro();");
            while (rs.next()){
                Libro objTmpLibro=new Libro(
                        rs.getInt(1),
                        new Categoria(rs.getInt("Id_Categoria"),"",""),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                listLibro.add(objTmpLibro);
            }
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return listLibro;
    }
}
