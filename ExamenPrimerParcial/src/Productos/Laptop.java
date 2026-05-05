package Productos;

public class Laptop extends Producto{
    // Atributos
    private int ram;
    private int almacenamiento;
    
    // Construtores
    public Laptop(){
        this.ram = 0;
        this.almacenamiento = 0;
    }
    public Laptop(String marca, double precio,int ram, int almacenamiento){
        super(marca,precio);
        this.ram = ram;
        this.almacenamiento = almacenamiento;
    }    
    // Metodos Get y Set
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public int getAlmacenamiento(){
        return almacenamiento;
    }
    public void setAlmacenamiento(int almacenamiento){
        this.almacenamiento = almacenamiento;
    }
    //  La funcionalidad del metodo abstracto.
    @Override
    public double calcularDescuento(){
        double descuento = getPrecio() * 0.1; 
        return descuento;
    }
    // Metodos
    public void mostrarInformacion(){
        System.out.println("Laptop");
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Almacenamiento: " + getAlmacenamiento() + "GB");
        System.out.println("Ram: " + getRam() + "GB" );
    }  
}
