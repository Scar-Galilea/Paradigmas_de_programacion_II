
package Paquetes;
public class Persona implements Imprimible{
    // Atributos
    private String nombre;
    private int edad;
    private String correoElectronico;
    
    // Construtores
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.correoElectronico = "";
    }
    
    public Persona(String nombre, int edad, String correoElectronico) throws EdadInvalidaException, CorreoInvalidoException{
        validarEdad(edad);
        validarCorreoElectronico(correoElectronico);
        this.nombre = nombre;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }
    
    // Metodos Get y Set
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getEdad(){
        return edad;
    }
     public void setEdad(int edad) throws EdadInvalidaException{
        validarEdad(edad);
        this.edad = edad;
    }
     
    public String getCorreoElectronico(){
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) throws CorreoInvalidoException{
        validarCorreoElectronico(correoElectronico);
        this.correoElectronico = correoElectronico;
    }
    
    // Implementacion de la interfaz
    @Override
    public void imprimir(){
        System.out.println("*********   Datos   *********");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Correo electronico: " + getCorreoElectronico() + "\n");
    }
    
    // Metodos estatico para las excepciones
    // Validar edad
    public static void validarEdad(int edad) throws EdadInvalidaException{
        if(edad < 0){
            throw new EdadInvalidaException("La edad no puede ser negativa");
        }
        else if(edad > 99){
            throw new EdadInvalidaException("La edad excede el limite logico");
        }
        else{
            System.out.println("Edad valida");
        }  
    }
    
    // Varlidar correo electronico
    public static void validarCorreoElectronico(String correoElectronico) throws CorreoInvalidoException{
        char arroba = '@';
        int cont = 0;
        
        // Lo que realiza este for es ir caracater a  caracter comparando si tiene un '@'
        // Ademas, cuenta cuantos arrobas tiene
        for(char c: correoElectronico.toCharArray()){
            if(c == arroba){
                cont += 1;
            }
        }
        
        if(cont != 1){
            throw new CorreoInvalidoException("El correo es invalido");
        }
        else if(! correoElectronico.contains("gmail.com")){
            throw new CorreoInvalidoException("El correo es invalido");
        }
        else{
            System.out.println("Correo validado");
        }
    }  
}
