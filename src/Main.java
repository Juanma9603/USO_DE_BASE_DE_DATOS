import DAO.*;
import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Categoria objCategoria = new Categoria();
        Scanner scanner = new Scanner(System.in);
        CategoriaDAO CategoriaDAO;
        Ubicacion objubicacion = new Ubicacion();
        UbicacionDAO UbicacionDAO;
        Libro objlibro = new Libro();
        LibroDAO LibroDAO;
        Persona objpersona = new Persona();
        PersonaDAO PersonaDAO;
        Prestamo objprestamo = new Prestamo();
        PrestamoDAO PrestamoDAO;
        Usuario objusuario = new Usuario();
        UsuarioDAO UsuarioDAO;
        Conexion Conexion = new Conexion();
        boolean iniciar = true;



        while (iniciar) {
            System.out.println("Bienvenido a Biblioteca");
            System.out.println("1.Iniciar");
            System.out.println("2.Salir");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Elige un destino");
                    System.out.println("1.Categoria");
                    System.out.println("2.Ubicacion");
                    System.out.println("3.Libro");
                    System.out.println("4.Persona");
                    System.out.println("5.Detalle Prestamo");
                    System.out.println("6.Prestamo");
                    System.out.println("7.Usuario");

                    int option1 = scanner.nextInt();
                    switch (option1) {
                        case 1:
                            System.out.println("Categoria");
                            System.out.println("1.Consultar Categoria");
                            System.out.println("2.Registrar Categoria");
                            System.out.println("3.Modificar Categoria");
                            System.out.println("4.Eliminar Categoria");
                            System.out.println("5.Listar Categorias");

                            CategoriaDAO = new CategoriaDAO();
                            int option2 = scanner.nextInt();

                            switch (option2) {
                                case 1:
                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indica el ID de la Categoria a consultar");
                                        Categoria objCategoriaRes = CategoriaDAO.Consultar(scanner.nextInt());
                                        System.out.println(objCategoriaRes.toString());
                                    } catch (Exception e) {
                                        System.out.println("Error " + e);
                                    }

                                    break;
                                case 2:
                                    objCategoria = new Categoria();
                                    System.out.println("Registrar");
                                    System.out.println("Indica el Nombre");
                                    objCategoria.setNombre(scanner.next());
                                    System.out.println("Indica el Tipo");
                                    objCategoria.setTipo(scanner.next());

                                    CategoriaDAO.Registrar(objCategoria);

                                    break;
                                case 3:
                                    objCategoria = new Categoria();
                                    System.out.println("Modificar");
                                    System.out.println("Indica el ID");
                                    objCategoria.setID(scanner.nextInt());
                                    System.out.println("Indica el Nombre");
                                    objCategoria.setNombre(scanner.next());
                                    System.out.println("Indica el Tipo");
                                    objCategoria.setTipo(scanner.next());

                                    CategoriaDAO.Modificar(objCategoria);

                                    break;
                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        CategoriaDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }
                                    break;
                                case 5:
                                    try{
                                        System.out.println("Lista de Categorias");
                                        System.out.println("=============================");
                                        ArrayList<Categoria> listCategoria = CategoriaDAO.list();
                                        for (int i=0; i<listCategoria.size();i++){
                                            System.out.println(listCategoria.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("Error: "+ e);
                                    }
                            }


                            break;
                        case 2:
                            System.out.println("Ubicacion");
                            System.out.println("1.Consultar Ubicacion");
                            System.out.println("2.Registrar Ubicacion");
                            System.out.println("3.Modificar Ubicacion");
                            System.out.println("4.Eliminar Ubicacion");
                            System.out.println("5.Listar Ubicaciones");
                            UbicacionDAO = new UbicacionDAO();
                            int option3 = scanner.nextInt();
                            switch (option3) {
                                case 1:

                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indica el ID a Consultar");
                                        Ubicacion objUbicacionCon= UbicacionDAO.Consultar(scanner.nextInt());
                                        System.out.println(objUbicacionCon.toString());
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }

                                    break;

                                case 2:
                                    try {
                                        objubicacion = new Ubicacion();
                                        System.out.println("Registrar");
                                        System.out.println("Indique el Pais");
                                        objubicacion.setPais(scanner.next());
                                        System.out.println("Indique la Region");
                                        objubicacion.setRegion(scanner.next());
                                        System.out.println("Indique la Ciudad");
                                        objubicacion.setCiudad(scanner.next());
                                        UbicacionDAO.Registrar(objubicacion);
                                    }catch (Exception err){
                                        System.out.println("ERROR"+ err);
                                    }

                                    break;

                                case 3:
                                    objubicacion = new Ubicacion();
                                    System.out.println("Modificar");
                                    System.out.println("Indique el ID");
                                    objubicacion.setID(scanner.nextInt());
                                    System.out.println("Indique el Pais");
                                    objubicacion.setPais(scanner.next());
                                    System.out.println("Indique la Region");
                                    objubicacion.setRegion(scanner.next());
                                    System.out.println("Indique la Ciudad");
                                    objubicacion.setCiudad(scanner.next());

                                    UbicacionDAO.Modificar(objubicacion);
                                    break;

                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        UbicacionDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }

                                    break;
                                case 5:
                                    try{
                                        System.out.println("Lista de Ubicaciones");
                                        ArrayList<Ubicacion> listUbicacion = UbicacionDAO.list();
                                        for (int i=0; i<listUbicacion.size();i++){
                                            System.out.println(listUbicacion.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+ e);
                                    }
                                    break;
                            }

                            break;
                        case 3:
                            System.out.println("Libro");
                            System.out.println("1.Consultar Libro");
                            System.out.println("2.Registrar Libro");
                            System.out.println("3.Modificar Libro");
                            System.out.println("4.Eliminar Libro");
                            System.out.println("5.Listar Libros");
                            LibroDAO =new LibroDAO();

                            int option4 = scanner.nextInt();

                            switch (option4) {
                                case 1:
                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indique el ID del Libro a Consultar");
                                        Libro objLibroCon= LibroDAO.Consultar(scanner.nextInt());
                                        System.out.println(objLibroCon.toString());
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }
                                    break;

                                case 2:
                                    objlibro = new Libro();
                                    System.out.println("Registar");
                                    System.out.println("Indica el ID Categoria del Libro");
                                    objlibro.setID_Categoria(scanner.nextInt());
                                    System.out.println("Indica el Titulo del Libro");
                                    objlibro.setTitle(scanner.next());
                                    System.out.println("Indica el Autor del Libro");
                                    objlibro.setAuthor(scanner.next());
                                    System.out.println("Indica la editorial del Libro");
                                    objlibro.setEditorial(scanner.next());
                                    System.out.println("Indica el Volumen del Libro");
                                    objlibro.setVolumen(scanner.nextInt());
                                    System.out.println("Indica el Tema del Libro");
                                    objlibro.setTema(scanner.next());

                                    LibroDAO.Registrar(objlibro);
                                    break;

                                case 3:
                                    objlibro = new Libro();
                                    System.out.println("Registar");
                                    System.out.println("Indica el ID");
                                    objlibro.setID(scanner.nextInt());
                                    System.out.println("Indica el ID Categoria del Libro");
                                    objlibro.setID_Categoria(scanner.nextInt());
                                    System.out.println("Indica el Titulo del Libro");
                                    objlibro.setTitle(scanner.next());
                                    System.out.println("Indica el Autor del Libro");
                                    objlibro.setAuthor(scanner.next());
                                    System.out.println("Indica la editorial del Libro");
                                    objlibro.setEditorial(scanner.next());
                                    System.out.println("Indica el Volumen del Libro");
                                    objlibro.setVolumen(scanner.nextInt());
                                    System.out.println("Indica el Tema del Libro");
                                    objlibro.setTema(scanner.next());

                                    LibroDAO.Modificar(objlibro);
                                    break;

                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        LibroDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }
                                    break;
                                case 5:
                                    try {
                                        System.out.println("Listar de Libros");
                                        ArrayList<Libro> listLibro=new LibroDAO().list();
                                        for (int i=0; i<listLibro.size();i++){
                                            System.out.println(listLibro.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("Persona");
                            System.out.println("1.Consultar Persona");
                            System.out.println("2.Registrar Persona");
                            System.out.println("3.Modificar Persona");
                            System.out.println("4.Eliminar Persona");
                            System.out.println("5.Listar Personas");
                            PersonaDAO =new PersonaDAO();

                            int option5 = scanner.nextInt();

                            switch (option5) {
                                case 1:
                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indique el ID del Persona a Consultar");
                                        Persona objPersonaCon=PersonaDAO.Consultar(scanner.nextInt());
                                        System.out.println(objPersonaCon.toString());
                                    }catch (Exception e)
                                    {
                                        System.out.println("ERROR: "+e);
                                    }

                                    break;

                                case 2:
                                    objpersona = new Persona();
                                    System.out.println("Registar");
                                    System.out.println("Indica el ID Ubicacion de la Persona");
                                    objpersona.setId_Ubicacion(scanner.nextInt());
                                    System.out.println("Indica el Nombre de la Persona");
                                    objpersona.setFirstname(scanner.next());
                                    System.out.println("Indica el Apellido de la Persona");
                                    objpersona.setLastname(scanner.next());
                                    System.out.println("Indica la fecha de nacimiento '2020-01-01'");
                                    objpersona.setBirthday(scanner.next());
                                    System.out.println("Indica la Carrera de la Persona");
                                    objpersona.setCarrera(scanner.next());
                                    System.out.println("Indica el Ciclo de la Persona");
                                    objpersona.setCiclo(scanner.nextInt());

                                    PersonaDAO.Registrar(objpersona);
                                    break;

                                case 3:
                                    objpersona = new Persona();
                                    System.out.println("Registar");
                                    objpersona.setID(scanner.nextInt());
                                    System.out.println("Indica el ID de la Persona");
                                    objpersona.setID(scanner.nextInt());
                                    System.out.println("Indica el ID Ubicacion de la Persona");
                                    objpersona.setId_Ubicacion(scanner.nextInt());
                                    System.out.println("Indica el Nombre de la Persona");
                                    objpersona.setFirstname(scanner.next());
                                    System.out.println("Indica el Apellido de la Persona");
                                    objpersona.setLastname(scanner.next());
                                    System.out.println("Indica la fecha de nacimiento '2020-01-01'");
                                    objpersona.setBirthday(scanner.next());
                                    System.out.println("Indica la Carrera de la Persona");
                                    objpersona.setCarrera(scanner.next());
                                    System.out.println("Indica el Ciclo de la Persona");
                                    objpersona.setCiclo(scanner.nextInt());

                                    PersonaDAO.Modificar(objpersona);
                                    break;

                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        PersonaDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }
                                    break;
                                case 5:
                                    try {
                                        System.out.println("Listar Personas");
                                        ArrayList<Persona> listpersona= PersonaDAO.list();
                                        for (int i=0;i< listpersona.size();i++){
                                            System.out.println(listpersona.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("Detalle Prestamo");
                            break;

                        case 6:
                            System.out.println("Prestamo");
                            System.out.println("1.Consultar Prestamo");
                            System.out.println("2.Registrar Prestamo");
                            System.out.println("3.Modificar Prestamo");
                            System.out.println("4.Eliminar Prestamo");
                            System.out.println("5.Listar Prestamo");
                            PrestamoDAO =new PrestamoDAO();


                            int option6 = scanner.nextInt();

                            switch (option6) {
                                case 1:
                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indica el ID a consultar");
                                        Prestamo objPrestamoCon= PrestamoDAO.Consultar(scanner.nextInt());
                                        System.out.println(objPrestamoCon.toString());
                                    } catch (Exception e) {
                                        System.out.println("Error " + e);
                                    }

                                    break;
                                case 2:
                                    objprestamo = new Prestamo();
                                    System.out.println("Registrar");
                                    System.out.println("Indica el ID del Usuario");
                                    objprestamo.setId_Usuario(scanner.nextInt());


                                    PrestamoDAO.Registrar(objprestamo);

                                    break;
                                case 3:
                                    objprestamo = new Prestamo();
                                    System.out.println("Modificar");
                                    System.out.println("Indica el ID");
                                    objprestamo.setID(scanner.nextInt());
                                    System.out.println("Indica el ID del Usuario");
                                    objprestamo.setId_Usuario(scanner.nextInt());

                                    PrestamoDAO.Modificar(objprestamo);

                                    break;
                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        PrestamoDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }
                                    break;
                                case 5:
                                    try {
                                        System.out.println("Listar Prestamos");
                                        ArrayList<Prestamo> listprestamo= PrestamoDAO.list();
                                        for (int i=0;i< listprestamo.size();i++){
                                            System.out.println(listprestamo.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }
                                    break;
                            }
                            break;
                        case 7:
                            System.out.println("Usuario");
                            System.out.println("1.Consultar Usuario");
                            System.out.println("2.Registrar Usuario");
                            System.out.println("3.Modificar Usuario");
                            System.out.println("4.Eliminar Usuario");
                            System.out.println("5.Listar Usuarios");
                            UsuarioDAO =new UsuarioDAO();

                            int option7 = scanner.nextInt();

                            switch (option7) {
                                case 1:
                                    try {
                                        System.out.println("Consultar");
                                        System.out.println("Indique el ID del Usuario a Consultar");
                                        Usuario objUsuarioCon= UsuarioDAO.Consultar(scanner.nextInt());
                                        System.out.println(objUsuarioCon.toString());
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }

                                    break;

                                case 2:
                                    objusuario = new Usuario();
                                    System.out.println("Registar");
                                    System.out.println("Indica el ID Persona del Usuario");
                                    objusuario.setId_Persona(scanner.nextInt());
                                    System.out.println("Indica el Email de la Usuario");
                                    objusuario.setEmail(scanner.next());
                                    System.out.println("Indica el Nickname del Usuario");
                                    objusuario.setNickname(scanner.next());
                                    System.out.println("Indica la Contraseña del Usuario");
                                    objusuario.setContraseña(scanner.next());

                                    UsuarioDAO.Registrar(objusuario);

                                    break;

                                case 3:
                                    objusuario = new Usuario();
                                    System.out.println("Registar");
                                    System.out.println("Indica el ID del Usuario");
                                    objusuario.setID(scanner.nextInt());
                                    System.out.println("Indica el ID Persona del Usuario");
                                    objusuario.setId_Persona(scanner.nextInt());
                                    System.out.println("Indica el Email de la Usuario");
                                    objusuario.setEmail(scanner.next());
                                    System.out.println("Indica el Nickname del Usuario");
                                    objusuario.setNickname(scanner.next());
                                    System.out.println("Indica la Contraseña del Usuario");
                                    objusuario.setContraseña(scanner.next());

                                    UsuarioDAO.Modificar(objusuario);
                                    break;

                                case 4:
                                    try {
                                        System.out.println("Eliminar");
                                        System.out.println("Indica el ID a eliminar");
                                        UsuarioDAO.Eliminar(scanner.nextInt());
                                    } catch (Exception e) {
                                        System.out.println("ERROR" + e);
                                    }
                                    break;
                                case 5:
                                    try {
                                        System.out.println("Listar Usuarios");
                                        ArrayList<Usuario> listUsuario= UsuarioDAO.list();
                                        for (int i=0;i< listUsuario.size();i++){
                                            System.out.println(listUsuario.get(i).toString());
                                        }
                                    }catch (Exception e){
                                        System.out.println("ERROR: "+e);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
                        case 2:
                            System.out.println("Saliste");
                            iniciar = false;
                            break;
                        default:
                            System.out.println("Solo usa las opciones");
                            break;
                    }


            }
        }
    }


