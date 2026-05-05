package Productos;
public abstract class Producto implements Vendible{
    // Atributos
    private String marca;
    private double precio;
    
   // Construtores
    public Producto(){
        marca = "";
        precio = 0.0;
    }
    public Producto(String marca, double precio){
        this.precio = precio;
        this.marca = marca;     
    }

    // Metodos gether y sether.
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    // Metodos abstractos.
    abstract double calcularDescuento();  
    
    // Implementacion de la interfaz
    @Override
    public void precioFinal(){
        double descuento = calcularDescuento();
        double precioFinal = getPrecio() - descuento;
        System.out.println("El precio final es: $" + precioFinal + "\n");
    }
}
