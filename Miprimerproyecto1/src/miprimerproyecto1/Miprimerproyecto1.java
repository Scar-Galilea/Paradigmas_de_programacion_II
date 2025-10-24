
package miprimerproyecto1;
import java.util.Scanner;

public class Miprimerproyecto1 {  //Mi clase 
    // Atributos encabsulados
    private String nombre;
    private int edad;
    
    // Metodos
     // Getter
    public String getNombre(){
        return nombre;
    }
    
    // Setter 
    public void setNombre(String nombre){
        this.nombre = nombre;   
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;   
    }          
            
    public void mostrarInformacion(){
        System.out.println("Hola mundo");
    }
    
    public void mostrarInformacion(String nombre){
        System.out.println("Hola al mundo de:"+nombre);
    }
    

    public static void main(String[] args) {  //Mi main
        // TODO code application logic here
        Miprimerproyecto1 proyecto_1 = new Miprimerproyecto1();
        proyecto_1.mostrarInformacion();
        
        String nombre;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        nombre = entrada.nextLine();
        proyecto_1.setNombre(nombre);
        
        String nombredelObjeto = proyecto_1.getNombre();
        System.out.println("Su nombre es: "+nombredelObjeto);
        System.out.println("Su nombre es: "+proyecto_1.getNombre());
        
        proyecto_1.mostrarInformacion(nombre);
        
    }
    
}
