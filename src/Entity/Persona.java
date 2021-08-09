package Entity;

public class Persona {
    private int ID;
    private Ubicacion objubicacion;
    private String Firstname;
    private String Lastname;
    private String Birthday;
    private String Carrera;
    private int Ciclo;
    private String Register_date;

    public Persona() {
        this.ID = 0;
        this.objubicacion = new Ubicacion();
        this.Firstname = "";
        this.Lastname = "";
        this.Birthday = "";
        this.Carrera = "";
        this.Ciclo = 0;
        this.Register_date = "";
    }

    public Persona(int ID, Ubicacion objubicacion, String firstname, String lastname, String birthday,
                   String carrera, int ciclo, String register_date) {
        this.ID = ID;
        this.objubicacion = objubicacion;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Birthday = birthday;
        this.Carrera = carrera;
        this.Ciclo = ciclo;
        this.Register_date = register_date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Ubicacion getobjubicacion() {
        return objubicacion;
    }

    public void setObjubicacion(Ubicacion objubicacion) {
        this.objubicacion = objubicacion;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        this.Birthday = birthday;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        this.Carrera = carrera;
    }

    public int getCiclo() {
        return Ciclo;
    }

    public void setCiclo(int ciclo) {
        this.Ciclo = ciclo;
    }

    public String getRegister_date() {
        return Register_date;
    }

    public void setRegister_date(String register_date) {
        this.Register_date = register_date;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                "," + objubicacion +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", Carrera='" + Carrera + '\'' +
                ", Ciclo=" + Ciclo +
                ", Register_date='" + Register_date + '\'' +
                '}';
    }
}