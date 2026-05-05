package Productos;
public class Camisa extends Producto{
    // Atributos
    private String color;
    private String tamano;
    
    // Construtores
    public Camisa(){
        color = "";
        tamano = " ";
    }
    public Camisa(String marca, double precio,String color, String tamano){
        super(marca,precio);
        this.color = color;
        this.tamano = tamano;
    }
    // Definir la clase interna
    class Etiqueta{
        // Atributos
       private String descripcion;
       // Construtores
       public Etiqueta(){
           descripcion = "";
       }
       public Etiqueta(String descripcion){
           this.descripcion = descripcion;
       }
       // Metodos Get y Set
       public String getDescripcion(){
           return descripcion;
       }
       public void setDescripcion(String descripcion){
           this.descripcion = descripcion;
       }
       // Metodo 
       public void mostrarDescripcion(){
           System.out.println("Descripcion: " + descripcion);
       }
    }
    // Metodos Get y Set
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getTamano(){
        return tamano;
    }
    public void setTamano(String tamano){
        this.tamano = tamano;
    }
 
    //  La funcionalidad del metodo abstracto.
    @Override
    double calcularDescuento(){
        double descuento = getPrecio() * 0.2; 
        return descuento;
    }
    // Metodos   
    public void mostrarInformacion(){
        System.out.println("Camisa");
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Color: " + getColor());
        System.out.println("Talla: " + getTamano());
    }
}
