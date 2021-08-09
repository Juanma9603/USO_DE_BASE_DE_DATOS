package DAO;

import Entity.Categoria;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaDAO {
    Conexion con=new Conexion();

    public ArrayList<Categoria> list () throws Exception{
        ArrayList<Categoria> listCategoria = new ArrayList<Categoria>();
        try{
            Statement statement = con.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery("CALL sp_listarCategoria();");
            while (resultSet.next()){
                Categoria objTmpCategoria = new Categoria(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                listCategoria.add(objTmpCategoria);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        finally {
            con.getCon().close();
        }
        return listCategoria;
    }
    public Categoria Consultar (int ID) throws Exception{
        Categoria objcategoria = new Categoria();

        try {
            String sql= "CALL sp_consultarCategoria (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()) {
                objcategoria = new Categoria(
                        rs.getInt("Id_Categoria"),
                        rs.getString("Nombre"),
                        rs.getString("Tipo")
                );
            }
        }catch (SQLException e){

            System.out.println("SQL ERROR" +e);
        }finally {
            con.getCon().close();
        }
        return objcategoria;
    }

    public void Registrar(Categoria objcategoria){
        try {
            String sql="CALL sp_categoriaINSERT (?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setString(1,objcategoria.getNombre());
            ps.setString(2, objcategoria.getTipo());
            ps.execute();

        }catch (SQLException e) {
            System.out.println("SQL ERROR" + e);
        }
    }

    public void Modificar(Categoria objcategoria){
        try {
            String sql="CALL sp_categoriaUPDATE (?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objcategoria.getID());
            ps.setString(2,objcategoria.getNombre());
            ps.setString(3, objcategoria.getTipo());
            ps.execute();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }

    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_categoriaDELETE (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.execute();
        }catch (SQLException er){
            System.out.println("SQL ERROR"+er);
        }

    }
}
