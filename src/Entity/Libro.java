package Entity;

public class Libro {
    private int ID;
    private Categoria objcategoria;
    private String Title;
    private String Author;
    private String Editorial;
    private int Volumen;
    private String Tema;

    public Libro(){
        this.ID=0;
        this.objcategoria=new Categoria();
        this.Title="";
        this.Author="";
        this.Editorial="";
        this.Volumen=0;
        this.Tema="";
    }

    public Libro(int ID,Categoria objcategoria,String Title,String Author,String Editorial,int Volumen,String Tema){
        this.ID=ID;
        this.objcategoria=objcategoria;
        this.Title=Title;
        this.Author=Author;
        this.Editorial=Editorial;
        this.Volumen=Volumen;
        this.Volumen=Volumen;
        this.Tema=Tema;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Categoria getobjcategoria() {
        return objcategoria;
    }

    public void setObjcategoria(Categoria objcategoria) {
        this.objcategoria = objcategoria;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        this.Editorial = editorial;
    }

    public int getVolumen() {
        return Volumen;
    }

    public void setVolumen(int volumen) {
        this.Volumen = volumen;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        this.Tema = tema;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ID=" + ID +
                "," + objcategoria +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Editorial='" + Editorial + '\'' +
                ", Volumen=" + Volumen +
                ", Tema='" + Tema + '\'' +
                '}';
    }
}

