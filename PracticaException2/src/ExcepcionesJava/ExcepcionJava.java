package ExcepcionesJava;

public class ExcepcionJava {
    // Atributos
    // Constructor
    // Metodo
    
    // Metodo que provoca y maneja una ArrayIndexOutfBoundsException
    public void accesoFueraDeRango(int[] numeros, int indice){
        System.out.println("Contenido delindice seleccionado de la lista: " + numeros[indice]); // Indice fuera de rango
    }
    
    // Metodo que provoca y maneja una NullPointerException
    public void referenciaNula(String texto){
        System.out.println("Numero de logitud de la cadena: " + texto.length()); // Objeto nulo
    }
    
    // Metodo que provoca y maneja una NumberFormatException
    public void formatoNumeroInvalido(String numero){
        int valor = Integer.parseInt(numero); //Conversion invalido
        System.out.println("Valor convertido: " + valor);
    }
    
    // Metodo que provoca y maneja una ArithmeticException
    public void divisionInvalido(int numerador, int dominador){
        System.out.println("Resultado de la division: " + numerador / dominador);
    }
    
    // Metodo que provoca y maneja una StringIndexOutOfBoundsException
    public void accesoIndiceCadena(String texto, int indice){
        System.out.println("Caracter seleccionado: " + texto.charAt(indice)); // Índice inválido en cadena
    }

    // Metodo que provoca y maneja una IllegalArgumentException
    public void argumentoIlegal(int edad){
        if(edad < 0){
            throw new IllegalArgumentException("Edad no puede ser negativa"); // Argumento inválido
        }
        System.out.println("Edad válida: " + edad);
    }
    
    // Metodo que provoca y maneja una ClassCastException
    public void conversionIncompatible(Object obj){
        String texto = (String) obj; // Conversión incompatible
        System.out.println("Texto convertido: " + texto);
    }
    
    // Metodo que provoca y maneja una NegativeArraySizeException
    public void tamanoNegativo(int tamano){
        int[] arreglo = new int[tamano]; // Tamaño negativo del arreglo
        System.out.println("Arreglo creado.");
    }
    
    // Metodo que provoca y maneja una ArrayStoreException
    public void almacenamientoInvalido(){
        Object[] lista = new Integer[2];
        lista[0] = "Hola"; // Tipo incorrecto
    }
    
    // Metodo que provoca y maneja una IllegalStateException
    public void estadoInvalido(boolean activo){
        if(!activo){
            throw new IllegalStateException("Estado incorrecto"); // Estado ilegal
        }
        System.out.println("Estado válido.");
    }

    // Metodo que provoca y maneja una UnsupportedOperationException
    public void operacionNoSoportada(boolean soportada){
        if (!soportada) {
            throw new UnsupportedOperationException("Operación no permitida\n");
        } else {
            System.out.println("Operación soportada correctamente.");
        }
    }

    
    // Metodo que provoca y maneja una MissingResourceException// Metodo que provoca y maneja una MissingResourceException
    public void recursoFaltante(String recurso) {
        java.util.ResourceBundle.getBundle(recurso); 
    }


    
    // Metodo que provoca y maneja una ConcurrentModificationException
    public void modificacionConcurrente(java.util.List<String> lista){
        for(String s : lista){
            lista.add("Nuevo"); // Modificación durante iteración
        }
    }
}


 

