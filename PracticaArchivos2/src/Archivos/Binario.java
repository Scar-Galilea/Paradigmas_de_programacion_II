package Archivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.Closeable;


public class Binario {
    public void crearArchivoBinario(String nombre, byte[] datos) throws IOException {
        Files.write(
            Path.of(nombre),    // ruta del archivo
            datos               // bytes que se guardarán
        );
    }

    // Leer archivo binario (devolver bytes crudos)
    public byte[] leerArchivoBinario(String nombre) throws IOException {
        return Files.readAllBytes(
            Path.of(nombre)     // ruta del archivo
        );
    }
    
    // Escribir archivo binario
    public void escribirArchivoBinario(String nombre, byte[] datos) throws IOException {
        Files.write(
            Path.of(nombre),   // ruta del archivo
            datos              // arreglo de bytes
        );
    }
    
    public static void modificarBinario(String rutaOriginal, String rutaNueva) {
        try {
            byte[] nuevoContenido = Files.readAllBytes(Path.of(rutaNueva));
            Files.write(Path.of(rutaOriginal), nuevoContenido);
            System.out.println("Archivo reemplazado correctamente");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void borrarArchivo(String ruta) {
        Path archivo = Paths.get(ruta);

        try {
            boolean eliminado = Files.deleteIfExists(archivo);

            if (eliminado) {
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.out.println("El archivo no existe.");
            }

        } catch (IOException e) {
            System.out.println("No se pudo eliminar el archivo: " + e.getMessage());
        }
    }
    
    // Cerrar archivos txt o bin
    public static void cerrarFlujo(Closeable archivo) {
        if (archivo != null) {
            try {
                archivo.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo: " + e.getMessage());
            }
        }
    }
}
    

