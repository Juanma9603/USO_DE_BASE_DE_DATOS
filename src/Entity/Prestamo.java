package Entity;

import java.util.ArrayList;

public class Prestamo {
    private int ID;
    private Usuario objusuario;
    private ArrayList<DetallePrestamo> listdetalle;
    private String Date_prestamo;

    public Prestamo() {
        this.ID = 0;
        this.objusuario = new Usuario();
        this.Date_prestamo = "";
        this.listdetalle= new ArrayList<>();
    }


    public Prestamo(int ID, Usuario objusuario, String date_prestamo,ArrayList<DetallePrestamo> listdetalle) {
        this.ID = ID;
        this.objusuario = objusuario;
        this.Date_prestamo = date_prestamo;
        this.listdetalle= listdetalle;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Usuario getobjusuario() {
        return objusuario;
    }

    public void setObjusuario(Usuario objusuario) {
        this.objusuario = objusuario;
    }

    public String getDate_prestamo() {
        return Date_prestamo;
    }

    public void setDate_prestamo(String date_prestamo) {
        this.Date_prestamo = date_prestamo;
    }

    public ArrayList<DetallePrestamo> getListdetalle() {
        return listdetalle;
    }

    public void setListdetalle(ArrayList<DetallePrestamo> listdetalle) {
        this.listdetalle = listdetalle;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "ID=" + ID +
                ", objusuario=" + objusuario +
                ", listdetalle=" + listdetalle +
                ", Date_prestamo='" + Date_prestamo + '\'' +
                '}';
    }
}
