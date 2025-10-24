package Figuras;
public class Circulo extends Figura implements Datos, geometria{
    // Atributos.
    private double diametro; 
    // Constructor.
    public Circulo(){
        this.diametro = 0.0;
    }
    public Circulo(double diametro){
        this.diametro = diametro;
    }
    // Metodos get y set.\
    public double getDiametro(){
        return diametro;      
    }
    public void setDiametro(double diametro){
        this.diametro = diametro;
    }
    //  La funcionalidad del metodo abstracto.
    @Override
    void dibujar(){
        System.out.println("Dbujando un circulo");
    }
    @Override
    public void nombreFigura(){
        System.out.println("El nombre de la figura es circulo");       
    }
    @Override
    public void descripcion(){
        System.out.println("Es una figura geométrica plana y bidimensional formada por una circunferencia");
    }
    @Override
    public void radio(){
        double radio = diametro / 2;
        System.out.println("El radio es: " + radio);
    }
    @Override
    public void circunferencia(){
        double circunferencia = diametro * 3.1416;
        System.out.println("La circunferencia es: " + circunferencia);  
    }
}





