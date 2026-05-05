package Paquetes;

public class Libro extends Producto implements Imprimible{
    // Atributos
    private String titulo;
    private String autor;
    private String editorial;
    
    // Construtores
    public Libro(){
        this.titulo = "";
        this.autor = "";
        this.editorial = "";
    }
    public Libro(String titulo, String autor, String editorial, double precioBase) throws PrecioInvalidoException{
        super(precioBase);
        this.titulo = titulo;
        this.autor =  autor;
        this.editorial = editorial;
    }
   
    // Metodos Get y Set
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getEditorial(){
        return editorial;
    }
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }
    
    // Implementacion del metodo abstracto
    @Override
    void precioFinal(){
        double iva = 0.16;
        double total = (iva * getPrecioBase()) + getPrecioBase();
        System.out.println("El precio final con el 16% de IVA es: " + total);
        
    }
     
    // Implementacion de la interfaz
    @Override
    public void imprimir(){
        System.out.println("********    Datos del libro   *********");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Editorial: " + getEditorial()); 
        System.out.println("Precio base: " + getPrecioBase());
    }
 
    
}
