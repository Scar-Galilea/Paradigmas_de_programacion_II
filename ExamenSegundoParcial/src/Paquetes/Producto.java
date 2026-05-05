package Paquetes;
public abstract class Producto{
    // Atrubutos
    private double precioBase;
    
    // Constructores
    public Producto(){
        this.precioBase = 0.0;
    }
    public Producto(double precioBase) throws PrecioInvalidoException{
       validarPrecio(precioBase);
       this.precioBase = precioBase; 
    }
    
    // Metodo get y set
    public double getPrecioBase(){
        return precioBase;
    }
    public  void setPrecioBase(double precioBase) throws PrecioInvalidoException{
        validarPrecio(precioBase);
        this.precioBase = precioBase;
    }
    
    // Metodos
    // Metodo abstracto
    abstract void precioFinal();
    
    // Metodo exception
    // Metodo que valida 
    public static  void validarPrecio(double precioBase) throws PrecioInvalidoException{
        if(precioBase < 0){
            throw new PrecioInvalidoException("Precio base invalido");
        }
        else{
            System.out.println("Precio Validado");
        }
    }
}
