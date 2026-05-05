
package Biblioteca;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        // Probar la conexion
        //ConexionBD conn = new ConexionBD();
        //conn.conexion();
        
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        int mopc;
        ConsultaBD conn = new ConsultaBD();
        Libro db = new Libro();
        Archivo arch = new Archivo();
        String nombreArch1 = "archivoLibro.txt";
        String nombreArch2 = "ConsultaLibro.txt";
        
        while(menu){
            System.out.println("**** Biblioteca ****");
            System.out.println("Escoja una opcion");
            System.out.println("1. Captura de informacion");
            System.out.println("2. Leer e insertar la informacion");
            System.out.println("3. Realizar una consulta");
            System.out.println("4. Actualizar un dato");
            System.out.println("5. Eliminar un dato");
            System.out.println("6. Recorrimiento de archivos");
            System.out.println("7. Salir");
            
            mopc = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n"); 
            
            switch(mopc){
                case 1:
                    System.out.println("Captura de informacion");
                    System.out.println("Ingrese el ISBN:");
                    db.setISBN(scanner.nextLine());
                    System.out.println("Ingrese el titulo:");
                    db.setTitulo(scanner.nextLine());
                    System.out.println("Ingrese el autor:");
                    db.setAutor(scanner.nextLine());
                    System.out.println("Ingrese el anio:");
                    db.setAnio(scanner.nextInt());
                    scanner.nextLine();
                    
                    try{
                        arch.crearArchivoTexto(nombreArch1);
                        arch.escribirArchivo(nombreArch1, db.getISBN());
                        arch.escribirArchivo(nombreArch1, db.getTitulo());
                        arch.escribirArchivo(nombreArch1, db.getAutor());
                        arch.escribirArchivo(nombreArch1, String.valueOf(db.getAnio()));
                        arch.escribirArchivo(nombreArch1, "\n");
                    }
                    catch (IOException e) {
                            System.out.println("Error de lectura del archivo");
                        }
                    
                    break;
                case 2:
                    System.out.println("Leer registro e insertarlo");
                    try{
                        arch.leerArchivoTexto(nombreArch1);
                        conn.insertarDatos(nombreArch1);
                        System.out.println("Datos ingresado correctamente");
                    }
                    catch(FileNotFoundException | NoSuchFileException e){
                         System.out.println("El archivo no existe");
                    }
                    catch(ArchivoVacioException e){
                        System.out.println(e.getMessage());
                    }
                    catch (IOException e) {
                            System.out.println("Error de lectura del archivo");
                        }
                    
                    try{
                       arch.borrarcontenido(nombreArch1); 
                    }
                    catch (IOException e) {
                            System.out.println("Error de lectura del archivo");
                        }
                    break;

                case 3:
                    System.out.println("Consulta de datos");
                    try{
                        arch.crearArchivoTexto(nombreArch2);
                        conn.leerDatos(nombreArch2, arch);
                    }
                    catch (IOException e) {
                        System.out.println("Error al manejar el archivo");
                        }
                    break;
                case 4:
                    System.out.println("Actualizar datos del libro");
                    System.out.println("Insertar la id del libro que desea actaualizar");
                    db.setIdLibro(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Ingrese el ISBN actualizado:");
                    db.setISBN(scanner.nextLine());
                    System.out.println("Ingrese el titulo actualizado:");
                    db.setTitulo(scanner.nextLine());
                    System.out.println("Ingrese el autor actualizado:");
                    db.setAutor(scanner.nextLine());
                    System.out.println("Ingrese el anio actualizado:");
                    db.setAnio(scanner.nextInt());
                    scanner.nextLine();
                    
                    conn.actualizarDato(db);
                    break;
                case 5:
                    System.out.println("Eliminar datos:");
                    System.out.println("Ingrese su id  del libro que desea eliminar:");
                    db.setIdLibro(scanner.nextInt());
                    scanner.nextLine();
                    
                    conn.eliminarDato(db);
                    break;   
                case 6:
                    System.out.println("Recorrido de archivos:");
                    System.out.println("1. Archivo libro");
                    System.out.println("2. Consulta libro");
                    int ropt = scanner.nextInt();
                    scanner.nextLine();
                    if(ropt == 1){
                        try{
                           arch.leerArchivoTexto(nombreArch1);
                        }
                        catch(NoSuchFileException e){
                            System.out.println("El archivo no existe");
                        }
                        catch (IOException e) {
                            System.out.println("Error al manejar el archivo");
                        }
                        catch(ArchivoVacioException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(ropt == 2){
                        try{
                            arch.leerArchivoTexto(nombreArch2);
                        }
                        catch(NoSuchFileException e){
                            System.out.println("El archivo no existe");
                        }
                        catch (IOException e) {
                            System.out.println("Error al manejar el archivo");
                        }
                        catch(ArchivoVacioException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        System.out.println("Opcion incorrecta");
                    }
                    
                    break;
                case 7:
                    menu = false;
                    try{
                        arch.borrarArchivo(nombreArch1);
                        arch.borrarArchivo(nombreArch2);
                    }
                    catch (IOException e) {
                        System.out.println("Error al manejar el archivo");
                        }
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta");           
            }
        System.out.println("\n");    
        }
        
    }
    
}
