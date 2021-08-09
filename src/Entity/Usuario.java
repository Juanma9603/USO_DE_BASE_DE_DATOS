package Entity;

public class Usuario {
    private int ID;
    private Persona objpersona;
    private String Email;
    private String Nickname;
    private String Contraseña;

    public Usuario() {
        this.ID = 0;
        objpersona = new Persona();
        Email = "";
        Nickname = "";
        Contraseña = "";
    }

    public Usuario(int ID, Persona objpersona, String email, String nickname, String contraseña) {
        this.ID = ID;
        this.objpersona = objpersona;
        this.Email = email;
        this.Nickname = nickname;
        this.Contraseña = contraseña;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Persona getobjpersona() {
        return objpersona;
    }

    public void setObjpersona(Persona objpersona) {
        this.objpersona = objpersona;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        this.Contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", " + objpersona +
                ", Email='" + Email + '\'' +
                ", Nickname='" + Nickname + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }
}
