
package Archivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.Closeable;


public class Texto {
     // Crear archivo de texto
    public void crearArchivoTexto(String nombre, String contenido) throws IOException {
        Files.writeString(
            Path.of(nombre),        // nombre del archivo convertido a ruta
            contenido,              // texto que se guardará
            StandardCharsets.UTF_8  // asegura que los acentos y ñ se guarden bien
        );
    }

    // Leer archivo de texto
    public String leerArchivoTexto(String nombre) throws IOException {
        return Files.readString(
            Path.of(nombre),        // ruta del archivo
            StandardCharsets.UTF_8  // leer el archivo con la misma codificación
        );
    }
    
    // Escribir en archivo de texto
    public void escribirArchivo(String nombre, String contenido) throws IOException {
        Files.writeString(
            Path.of(nombre),
            contenido,
            StandardCharsets.UTF_8
        );
    }

    
    public static void modificarTexto(String ruta, String textoViejo, String textoNuevo) {
        try {
            // Leer todo el contenido
            String contenido = new String(Files.readAllBytes(Paths.get(ruta)));

            // Reemplazar el texto
            String nuevoContenido = contenido.replace(textoViejo, textoNuevo);

            // Escribir de vuelta
            Files.write(Paths.get(ruta), nuevoContenido.getBytes());
            System.out.println("Texto reemplazado correctamente");
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
