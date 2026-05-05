package Productos;
public class Celular extends Producto{
    // Atributos
    private String procesador;
    private int ram;
    
    // Construtores
    public Celular(){
        procesador = "";
        ram = 0;
    }
    public Celular(String marca, double precio, int ram,String procesador){
        super(marca,precio);
        this.procesador = procesador;
        this.ram = ram;
    }
    // Metodos Get y Set
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public String getProcesador(){
        return procesador;
    }
    public void setProcesador(String procesador){
        this.procesador = procesador;
    }
    
    //  La funcionalidad del metodo abstracto.
    @Override
    double calcularDescuento(){
        double descuento = getPrecio() * 0.05; 
        return descuento;
    }
    // Metodos 
    public void mostrarInformacion(){
        System.out.println("Celular");
        System.out.println("Marca: " + getMarca());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Procesador: " + getProcesador());
        System.out.println("Ram: " + getRam() + "GB" );
    }  
}
