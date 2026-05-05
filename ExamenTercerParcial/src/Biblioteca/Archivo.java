
package Biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.NoSuchFileException;

public class Archivo {

     // Crear archivo de texto
    public void crearArchivoTexto(String nombre) throws IOException {
        File archivo = new File(nombre);
        
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
                System.out.println(archivo.getName() + " creado con exito");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // Leer archivo de texto
    public void leerArchivoTexto(String nombre) throws IOException, ArchivoVacioException{
        FileReader archivo1 = null;
        BufferedReader lector = null;
        File archivo = new File(nombre);

        if(!archivo.exists()){
            throw new NoSuchFileException("No existe el archivo");
        }
        validarContenido(nombre);   
        
        try {
            archivo1 = new FileReader(archivo);
            lector = new BufferedReader(archivo1);

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } finally {
            if (lector != null) {
                lector.close();
            }
            if (archivo1 != null) {
                archivo1.close();
            }
        }
        
    }
    
    // Escribir en archivo de texto
    public void escribirArchivo(String nombre, String dato) throws IOException {
        FileWriter archivo1 = null;
        BufferedWriter escritor = null;
        File archivo = new File(nombre);

        try {
            archivo1 = new FileWriter(archivo, true); // true = agregar
            escritor = new BufferedWriter(archivo1);

            escritor.write(dato);
            escritor.newLine();

        } finally {
            if (escritor != null) {
                escritor.close();
            }
            if (archivo1 != null) {
                archivo1.close();
            }
        }
    }
    
    public void borrarcontenido(String nombre) throws IOException {
        FileWriter archivo1 = null;
        BufferedWriter escritor = null;
        File archivo = new File(nombre);

        try {
            archivo1 = new FileWriter(archivo);
            escritor = new BufferedWriter(archivo1);

            escritor.write(""); // deja el archivo vacío

        } finally {
            if (escritor != null) {
                escritor.close();
            }
            if (archivo1 != null) {
                archivo1.close();
            }
        }
    }
    
    public void borrarArchivo(String nombre) throws IOException {
        File archivo = new File(nombre);

        if (archivo.exists()) {
            archivo.delete();
            }
        }
    
    // Metodo de exception
    public void validarContenido(String nombre) throws ArchivoVacioException{
        File archivo = new File(nombre);
        
        if (archivo.length() == 0) {
            throw new ArchivoVacioException("El archivo existe pero no tiene datos.");
        }   
    }
}
