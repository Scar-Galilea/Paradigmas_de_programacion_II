package Figuras;
public class Rectangulo extends Figura{
    // Atributos.
    private double base;
    private double altura; 
    // Constructor
    public Rectangulo(){
        this.base = 0.0;
        this.altura = 0.0;
    }   
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    // Metodos get y set.
    public double getBase(){
        return base;
    }
    public void setBase(double base){
        this.base = base;
    }
    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    //  La funcionalidad del metodo abstracto.
    @Override
    void dibujar(){
        System.out.println("Dbujando un rectangulo");
    }
}




