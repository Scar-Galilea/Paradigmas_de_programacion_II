package ExcepcionesJava;

import java.util.MissingResourceException;

public class Principal {
    public static void main(String[] args){
        ExcepcionJava excepcion = new ExcepcionJava();
        
        // ArrayIndexOutOfBoundsException
        try{
            int[] listaNumero1 = {1,3,4,5,6,7};
            int[] listaNumero2 = {1,3};
            excepcion.accesoFueraDeRango(listaNumero1, 5);
            excepcion.accesoFueraDeRango(listaNumero2, 5); 
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Indice fuera de los limites de arreglo.\n");
        }
        
        // NullPointerException
        try{
            String texto1 = "Hola";
            String texto2 = null;
            
            excepcion.referenciaNula(texto1);
            excepcion.referenciaNula(texto2);
        }
        catch(NullPointerException e){
            System.out.println("Error: Se intento usar una referencia nula.\n");
        }
        
        // NumberFormatException
        try{
            String formato1 = "123";
            String formato2 = "abc";
            excepcion.formatoNumeroInvalido(formato1);
            excepcion.formatoNumeroInvalido(formato2);
        }
        catch(NumberFormatException e){
            System.out.println("Error: Formato de numero invalido\n");
        }
        
        // ArithmeticException
        try{
            int numerador1  = 6;
            int denominador1 = 3;
            int numerador2  = 7;
            int denominador2 = 0;
            excepcion.divisionInvalido(numerador1, denominador1);
            excepcion.divisionInvalido(numerador2, denominador2);     
        }
        catch(ArithmeticException e){
            System.out.println("Error: Operacion matematica ilegal (como division entre cero).\n");
        }
        
        // StringIndexOutOfBoundsException
        try{
            String cadena1 = "Hola";
            String cadena2 = "Hi";
            excepcion.accesoIndiceCadena(cadena1, 2);
            excepcion.accesoIndiceCadena(cadena2, 10);
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("Error: Indice fuera del rango de la cadena.\n");
        }
        
        // IllegalArgumentException
        try{
            int edad1 = 20;
            int edad2 = -5;
            excepcion.argumentoIlegal(edad1);
            excepcion.argumentoIlegal(edad2);
        }
        catch(IllegalArgumentException e){
            System.out.println("Error: Argumento ilegal.\n");
        }
        
        // ClassCastException
        try{
            Object obj1 = "Hola";
            Object obj2 = 123;
            excepcion.conversionIncompatible(obj1);
            excepcion.conversionIncompatible(obj2);
        }
        catch(ClassCastException e){
            System.out.println("Error: Conversion de tipos incompatible.\n");
        }
        
        // NegativeArraySizeException
        try{
            int tamano1 = 3;
            int tamano2 = -4;
            excepcion.tamanoNegativo(tamano1);
            excepcion.tamanoNegativo(tamano2);
        }
        catch(NegativeArraySizeException e){
            System.out.println("Error: Tamano de arreglo negativo.\n");
        }
        
        // ArrayStoreException
        try{
            excepcion.almacenamientoInvalido(); 
        }
        catch(ArrayStoreException e){
            System.out.println("Error: Tipo incorrecto en almacenamiento de arreglo.\n");
        }
        
        // IllegalStateException
        try{
            boolean estado1 = true;
            boolean estado2 = false;
            excepcion.estadoInvalido(estado1);
            excepcion.estadoInvalido(estado2);
        }
        catch(IllegalStateException e){
            System.out.println("Error: Estado ilegal del objeto.\n");
        }
        
        // UnsupportedOperationException
        try {
            excepcion.operacionNoSoportada(true); 
            excepcion.operacionNoSoportada(false); 
        } 
        catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }

        // MissingResourceException
        try {
            String recurso = "configuracion.properties";
            excepcion.recursoFaltante(recurso);
        } 
        catch (MissingResourceException e) {
            System.out.println("Error: El recurso solicitado no existe o no se pudo cargar.\n");
        }

        
        // ConcurrentModificationException
        try{
            java.util.List<String> lista = new java.util.ArrayList<>();
            lista.add("A");
            lista.add("B");
            excepcion.modificacionConcurrente(lista);
        }
        catch(java.util.ConcurrentModificationException e){
            System.out.println("Error: Modificacion concurrente detectada.\n");
        }
    }
}
