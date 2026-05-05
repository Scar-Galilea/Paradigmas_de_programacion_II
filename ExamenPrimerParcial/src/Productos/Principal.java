
package Productos;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
         // Instanciación de objetos usando constructores
         
         // Creación de un objeto Laptop usando constructor con parámetros
         Laptop p1 = new Laptop("Lenovo",10000,512,16);
         
         // Creación de un objeto Camisa usando constructor con parámetros
         Camisa p2 = new Camisa("Hockerty",150.0,"M","Azul");
         // Instancia la clase interna 
         Camisa.Etiqueta etiquetap2 = p2.new Etiqueta("Camisa deportiva de algodón");
         
         // Creación de un objeto Celular usando constructor con parámetros
         Celular p3 = new Celular("Motorola",4500.0,12,"Snapdragon 8+ Gen 1");
         
         // Instanciación de objetos vacíos para llenarlos mediante setters
         Laptop p4 = new Laptop();
         Camisa p5 = new Camisa();
         Celular p6 = new Celular();
         
        Scanner scanner = new Scanner(System.in); // Scanner para recibir datos del usuario
        
        // Solicitar datos al usuario para el objeto Laptop p4
        System.out.println("Datos de la laptop");
        System.out.println("Marca:");
        p4.setMarca(scanner.nextLine());
        System.out.println("Precio:");
        p4.setPrecio(scanner.nextDouble());
        scanner.nextLine(); 
        System.out.println("Ram:");
        p4.setRam(scanner.nextInt());
        scanner.nextLine(); 
        System.out.println("Almacenamiento:");
        p4.setAlmacenamiento(scanner.nextInt());
        scanner.nextLine(); 
        System.out.println("\n");
        
        // Solicitad datos al usuario para el objeto Camisa p5
        System.out.println("Datos de la camisa");
        System.out.println("Marca:");
        p5.setMarca(scanner.nextLine());
        System.out.println("Precio:");
        p5.setPrecio(scanner.nextDouble());
        scanner.nextLine(); 
        System.out.println("Talla:");
        p5.setTamano(scanner.nextLine());
        System.out.println("Color:");
        p5.setColor(scanner.nextLine());
        
        System.out.println("Descripcion: ");
        // Instancia la clase interna 
        Camisa.Etiqueta etiquetap5 = p5.new Etiqueta(scanner.nextLine());
        System.out.println("\n");
        
        // Solicitar de datos al usuario para el objeto Celular p6
        System.out.println("Datos del celular");
        System.out.println("Marca:");
        p6.setMarca(scanner.nextLine());
        System.out.println("Precio:");
        p6.setPrecio(scanner.nextDouble());
        scanner.nextLine(); 
        System.out.println("Procesador:");
        p6.setProcesador(scanner.nextLine());
        System.out.println("Ram:");
        p6.setRam(scanner.nextInt());
        scanner.nextLine();
        
        // Mostrar información de todos los objetos creados y calcular descuentos
        // Laptop p1
        p1.mostrarInformacion();
        System.out.println("Descuento aplicado: $" + p1.calcularDescuento());
        p1.precioFinal();
        System.out.println("\n");
        
        // Camisa p2
        p2.mostrarInformacion();
        etiquetap2.mostrarDescripcion();
        System.out.println("Descuento aplicado: $" + p2.calcularDescuento());
        p2.precioFinal();
        System.out.println("\n");
        
        // Celular p3
        p3.mostrarInformacion();
        System.out.println("Descuento aplicado: $" + p3.calcularDescuento());
        p3.precioFinal();
        System.out.println("\n");
        
        // Laptop p4
        p4.mostrarInformacion();
        System.out.println("Descuento aplicado: $" + p4.calcularDescuento());
        p4.precioFinal();
        System.out.println("\n");
        
        // Camisa p5
        p5.mostrarInformacion();
        etiquetap5.mostrarDescripcion();
        System.out.println("Descuento aplicado: $" + p5.calcularDescuento());
        p5.precioFinal();
        System.out.println("\n");
        
        // Celular p6
        p6.mostrarInformacion();
        System.out.println("Descuento aplicado: $" + p6.calcularDescuento());
        p6.precioFinal();
        System.out.println("\n");

    }
    
}
