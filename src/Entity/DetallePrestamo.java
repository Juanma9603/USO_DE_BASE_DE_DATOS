package Entity;

public class DetallePrestamo {
    private int ID;
    private Libro objlibro;
    private Prestamo objprestamo;

    public DetallePrestamo() {
        this.ID = ID;
        this.objlibro = new Libro();
        this.objprestamo = new Prestamo();
    }


    public DetallePrestamo(int ID, Libro objlibro, Prestamo objprestamo) {
        this.ID = ID;
        this.objlibro = objlibro;
        this.objprestamo = objprestamo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Libro getObjlibro() {
        return objlibro;
    }

    public void setObjlibro(Libro objlibro) {
        this.objlibro = objlibro;
    }

    public Prestamo getObjprestamo() {
        return objprestamo;
    }

    public void setObjprestamo(Prestamo objprestamo) {
        this.objprestamo = objprestamo;
    }

    @Override
    public String toString() {
        return "DetallePrestamo{" +
                "ID=" + ID +
                ", objlibro=" + objlibro +
                ", objprestamo=" + objprestamo +
                '}';
    }
}
