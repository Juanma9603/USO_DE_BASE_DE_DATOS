package DAO;

import Entity.Libro;
import Entity.Persona;
import Entity.Ubicacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonaDAO {
    Conexion con=new Conexion();

    public Persona Consultar(int ID) throws Exception{
        Persona objpersona=new Persona();
        try {
            String sql="CALL sp_consultarPersona(?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                objpersona =new Persona(
                        rs.getInt("Id_Persona"),
                        new Ubicacion(rs.getInt("Id_Ubicacion"),"","",""),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Birthday"),
                        rs.getString("Carrera"),
                        rs.getInt("Ciclo"),
                        rs.getString("Register_date")
                );
            }
        }catch (SQLException er){
            System.out.println("SQL ERROR: "+er);
        }
        return objpersona;
    }



    public Persona Registrar(Persona objpersona){
        Persona objtmppersona=new Persona();
        try {
            String sql="CALL sp_registrar (?,?,?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objpersona.getobjubicacion().getID());
            ps.setString(2,objpersona.getFirstname());
            ps.setString(3, objpersona.getLastname());
            ps.setString(4,objpersona.getBirthday());
            ps.setString(5,objpersona.getCarrera());
            ps.setInt(6, objpersona.getCiclo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                objtmppersona =new Persona(
                        rs.getInt("Id_Persona"),new Ubicacion(),"","","","",0,""
                );
            }
            }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
        return objtmppersona;


    }

    public void Modificar(Persona objpersona){
        try {
            String sql="CALL sp_personaUPDATE(?,?,?,?,?,?,?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,objpersona.getID());
            ps.setInt(2,objpersona.getobjubicacion().getID());
            ps.setString(3,objpersona.getFirstname());
            ps.setString(4, objpersona.getLastname());
            ps.setString(5,objpersona.getBirthday());
            ps.setString(6,objpersona.getCarrera());
            ps.setInt(7, objpersona.getCiclo());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public void Eliminar(int ID){
        try {
            String sql="CALL sp_personaDELETE (?);";
            PreparedStatement ps=con.getCon().prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL ERROR"+e);
        }
    }

    public ArrayList<Persona> list() throws Exception{
        ArrayList<Persona> listPersona=new ArrayList<Persona>();
        try {
            Statement stmt=con.getCon().createStatement();
            ResultSet rs= stmt.executeQuery("CALL sp_listarPersona();");
            while (rs.next()){
                Persona objTmpPersona=new Persona(
                        rs.getInt(1),
                        new Ubicacion(rs.getInt("Id_Ubicacion"),"","",""),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)
                );
                listPersona.add(objTmpPersona);
            }
        }catch (SQLException err){
            System.out.println("SQL ERROR: "+err);
        }finally {
            con.getCon().close();
        }
        return listPersona;
    }
}
