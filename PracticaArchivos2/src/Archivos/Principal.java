package Archivos;

import java.util.Scanner;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Texto texto = new Texto();
        Binario binario = new Binario();

        boolean opp = true;
        int op1;
        int op2;

        while (opp) {

            System.out.println("\nEscoja una opcion");
            System.out.println("1. Archivo texto");
            System.out.println("2. Archivo binario");
            System.out.println("3. Salir");

            op1 = scanner.nextInt();
            scanner.nextLine();

            switch (op1) {
                case 1:
                    System.out.println("\nArchivo de texto");
                    System.out.println("1. Crear");
                    System.out.println("2. Leer");
                    System.out.println("3. Escribir");
                    System.out.println("4. Modificar");
                    System.out.println("5. Borrar");
                    System.out.println("6. Cerrar");

                    op2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (op2) {

                        case 1:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Contenido: ");
                                String contenido = scanner.nextLine();
                                texto.crearArchivoTexto(nombre, contenido);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                System.out.println(texto.leerArchivoTexto(nombre));
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 3:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Nuevo contenido: ");
                                String contenido = scanner.nextLine();
                                texto.escribirArchivo(nombre, contenido);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 4:
                            System.out.print("Ruta del archivo: ");
                            String ruta = scanner.nextLine();
                            System.out.print("Texto viejo: ");
                            String viejo = scanner.nextLine();
                            System.out.print("Texto nuevo: ");
                            String nuevo = scanner.nextLine();
                            Texto.modificarTexto(ruta, viejo, nuevo);
                            break;

                        case 5:
                            System.out.print("Ruta del archivo: ");
                            Texto.borrarArchivo(scanner.nextLine());
                            break;

                        case 6:
                            Texto.cerrarFlujo(scanner);
                            opp = false;
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nArchivo binario");
                    System.out.println("1. Crear");
                    System.out.println("2. Leer");
                    System.out.println("3. Escribir");
                    System.out.println("4. Modificar");
                    System.out.println("5. Borrar");
                    System.out.println("6. Cerrar");

                    op2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (op2) {

                        case 1:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                byte[] datos = {65, 66, 67};
                                binario.crearArchivoBinario(nombre, datos);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                byte[] datos = binario.leerArchivoBinario(nombre);
                                for (byte b : datos) {
                                    System.out.print(b + " ");
                                }
                                System.out.println();
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 3:
                            try {
                                System.out.print("Nombre del archivo: ");
                                String nombre = scanner.nextLine();
                                byte[] datos = {10, 20, 30};
                                binario.escribirArchivoBinario(nombre, datos);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 4:
                            byte[] original = {66};
                            byte[] nuevoB = {90};
                            System.out.print("Ruta del archivo: ");
                            String ruta = scanner.nextLine();
                            System.out.print("Ruta nueva: ");
                            String rutaNueva = scanner.nextLine();
                            Binario.modificarBinario(ruta,rutaNueva);
                            break;

                        case 5:
                            System.out.print("Ruta del archivo: ");
                            Binario.borrarArchivo(scanner.nextLine());
                            break;

                        case 6:
                            Binario.cerrarFlujo(scanner);
                            opp = false;
                            break;
                    }
                    break;

                case 3:
                    Texto.cerrarFlujo(scanner);
                    opp = false;
                    break;
            }
        }

        System.out.println("Programa finalizado.");
    }
}
