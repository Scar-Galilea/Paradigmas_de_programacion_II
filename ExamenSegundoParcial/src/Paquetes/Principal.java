package Paquetes;
import java.util.Scanner;


public class Principal{
    public static void main(String[] args){
        // Objeto scanner que nos ayuda a lee datos del teclado
        Scanner scanner = new Scanner(System.in);
        
        // Creacion de objetos
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        CuentaAhorro c1 = new CuentaAhorro();
        CuentaAhorro c2 = new CuentaAhorro();
        Libro  pd1 = new Libro();
        
        // Datos del obejeto 1
        System.out.println("********    Llenar datos de la persona 1    ********");
        System.out.println("Ingrese su nombre: ");
        p1.setNombre(scanner.nextLine());
        
        try{
            System.out.println("Ingrese su edad: ");
            p1.setEdad(scanner.nextInt());  
        }
        catch(EdadInvalidaException e){
                System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine(); 
        try{
            System.out.println("Ingrese su correo electronico: ");
            p1.setCorreoElectronico(scanner.nextLine());
        }
        catch(CorreoInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        // Datos del obejeto 2
        System.out.println("\n********  Llenar datos de la persona 2    ********");
        System.out.println("Ingrese su nombre: ");
        p2.setNombre(scanner.nextLine());
        
        try{
            System.out.println("Ingrese su edad: ");
            p2.setEdad(scanner.nextInt());  
        }
        catch(EdadInvalidaException e){
                System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine(); 
        try{
            System.out.println("Ingrese su correo electronico: ");
            p2.setCorreoElectronico(scanner.nextLine());
        }
        catch(CorreoInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        
        // Datos del obejeto 3
        System.out.println("\n********  Llenar datos de la cuenta de ahorro 1   ********");
        System.out.println("Nombre del ahorro: ");
        c1.setNombreAhorro(scanner.nextLine());
        System.out.println("Periodo del ahorro: ");
        c1.setPeriodo(scanner.nextLine());
        System.out.println("Ingrese el estado del periodo: ");
        c1.setEstadoPeriodo(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("Ingrese el numero de cuenta: ");
        c1.setNumeroCuenta(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese el saldo: ");
        c1.setSaldo(scanner.nextDouble());
        scanner.nextLine();
        
        System.out.println("\n********  Depositar   ********");
        System.out.println("Ingrese el saldo a depositar: ");
        c1.depositar(scanner.nextDouble());
        scanner.nextLine();

        try{
            System.out.println("\n********  Retirar ********");
            System.out.println("Ingrese el saldo a retirar: ");
            c1.retirar(scanner.nextDouble());
        }
        catch(FondoInsuficienteException | RetiroAnticipadoException e){
            System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine();
        
        // Datos del obejeto 4
        System.out.println("\n********  Llenar datos de la cuenta de ahorro 2   ********");
        System.out.println("Nombre del ahorro: ");
        c2.setNombreAhorro(scanner.nextLine());
        System.out.println("Periodo del ahorro: ");
        c2.setPeriodo(scanner.nextLine());
        System.out.println("Ingrese el estado del periodo: ");
        c2.setEstadoPeriodo(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("Ingrese el numero de cuenta: ");
        c2.setNumeroCuenta(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese el saldo: ");
        c2.setSaldo(scanner.nextDouble());
        scanner.nextLine();
        
        System.out.println("\n********  Depositar   ********");
        System.out.println("Ingrese el saldo a depositar: ");
        c2.depositar(scanner.nextDouble());
        scanner.nextLine();

        try{
            System.out.println("\n********  Retirar ********");
            System.out.println("Ingrese el saldo a retirar: ");
            c2.retirar(scanner.nextDouble());
        }
        catch(FondoInsuficienteException | RetiroAnticipadoException e){
            System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine();
        
        // Datos del obejeto 3
        System.out.println("\n********  Llenar datos del libro 1    ********");
        System.out.println("Ingrese el titulo: ");
        pd1.setTitulo(scanner.nextLine());
        System.out.println("Ingrese el autor: ");
        pd1.setAutor(scanner.nextLine());
        System.out.println("Ingrese la editorial: ");
        pd1.setEditorial(scanner.nextLine());
        
        try{
            System.out.println("Ingrese el precio base: ");
            pd1.setPrecioBase(scanner.nextInt());
        }
        catch(PrecioInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine();
        
        System.out.print("\n");
        p1.imprimir();
        p2.imprimir();
        c1.imprimir();
        c2.imprimir();
        pd1.imprimir();
        pd1.precioFinal();
        
    }
    
}
