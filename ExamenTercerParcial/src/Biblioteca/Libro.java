
package Biblioteca;

public class Libro {
    // Atributos
    private int idLibro;
    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    
    // Constructores
    public Libro(){
        this.idLibro = 0;
        this.ISBN = "0";
        this.titulo = "";
        this.autor = "";
        this.anio = 0000;
    }
    public Libro(int idLibro, String ISBN, String titulo, String autor, int anio){
        this.idLibro = idLibro;
        this.ISBN =  ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;  
    }
    
    // Metodos Get y Set
    public int getIdLibro(){
        return idLibro;
    }
    public void setIdLibro(int idLibro){
        this.idLibro = idLibro;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
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
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    
    
}
