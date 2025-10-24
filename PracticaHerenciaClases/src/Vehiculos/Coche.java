/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

// Clase hija o subclase.
public class Coche extends Vehiculo{
    // Atrubutos.
    private int numPuerta;
    private String tipoCombustible;
    
    // Constructor de la clase padre o superconstuctor.
    public Coche(String marca, String modelo, int anio){
        super(marca, modelo, anio);
        
    }
    // Constructores
    public Coche(){
        this.numPuerta = 0;
        this.tipoCombustible = "";
    }
    
    public Coche(int numPuerta, String tipoCombustible){
        this.numPuerta = numPuerta;
        this.tipoCombustible = tipoCombustible;
    }
    
    // Get y set.
    public int getNumPuerta(){
        return numPuerta;
    }
    public void setNumPuerta(int numPuerta){
        this.numPuerta = numPuerta;
    }
    public String getTipoCombustible(){
        return tipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible){
        this.tipoCombustible = tipoCombustible;
    }
    
    // Metodos.
    // Sobrescritura.
    @Override
    public void mostrarInformacion(){
        System.out.println("Clase coche");
        System.out.println("Numero de puerta: " + numPuerta);
        System.out.println("Tipo de combustible: " + tipoCombustible + "\n");
    }
    
    
    
    
}
