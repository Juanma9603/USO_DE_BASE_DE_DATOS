package DAO;

import Entity.Persona;
import Entity.Ubicacion;
import Entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    Conexion con=new Conexion();

    public Usuario Consultar(int ID)throws Exception{
        Usuario objusuario=new Usuario();
        try {
            String sql="CALL sp_consultarUsuario (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                objusuario=new Usuario(
                        rs.getInt("Id_Usuario"),
                        new Persona(rs.getInt("Id_Persona"),new Ubicacion(),"","","","",0,""),
                        rs.getString("Email"),
                        rs.getString("Nickname"),
                        rs.getString("Contraseña")
                );
            }
        }catch (SQLException err) {
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return objusuario;
    }

    public void Registrar(Usuario objusuario){
        try {
            String sql="CALL sp_usuarioINSERT (?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objusuario.getobjpersona().getID());
            ps.setString(2,objusuario.getEmail());
            ps.setString(3, objusuario.getNickname());
            ps.setString(4, objusuario.getContraseña());
            ps.execute();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Modificar(Usuario objusuario){
        try {
            String sql="CALL sp_usuarioUPDATE (?,?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objusuario.getID());
            ps.setInt(2, objusuario.getobjpersona().getID());
            ps.setString(3, objusuario.getEmail());
            ps.setString(4, objusuario.getNickname());
            ps.setString(5, objusuario.getContraseña());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_usuarioDELETE (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public ArrayList<Usuario> list()throws Exception{
        ArrayList<Usuario> lisUsuario=new ArrayList<Usuario>();
        try {
            Statement stmt=con.getCon().createStatement();
            ResultSet rs= stmt.executeQuery("CALL sp_listarUsuario();");
            while (rs.next()){
                Usuario objTmpUsuario=new Usuario(
                        rs.getInt(1),
                        new Persona(rs.getInt("Id_Persona"),new Ubicacion(),"","","","",0,""),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lisUsuario.add(objTmpUsuario);
            }
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return lisUsuario;
    }
}
