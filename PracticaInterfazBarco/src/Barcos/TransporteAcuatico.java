package Barcos;

public class TransporteAcuatico{
    // Definir atributos.
    private int capacidadCarga;
    private double velocidad;
    
    // Definicion de constructores.
    public TransporteAcuatico(){
        this.capacidadCarga = 0;
        this.velocidad = 0.0;
    }
    public TransporteAcuatico(int capacidadCarga, double velocidad){
        this.capacidadCarga = capacidadCarga;
        this.velocidad = velocidad;
    }
    
    // Metodo get y set.
    public int getCapacidadCarga(){
        return capacidadCarga;
    }
    public void setCapacidadCarga(int capacidadCarga){
        this.capacidadCarga = capacidadCarga;
    }
    public double getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(double velocidad){
        this.velocidad = velocidad;
    }
    
    //  Metodos funcionales.
    public void mostrarMensaje(){
        System.out.println("Soy un transporte acuatico. \n");
    }

}
