package Vehiculos;

// Superclase
public class Vehiculo {
    // Atributos.
    // Marca, modelo y año.
    private String marca;
    private String modelo;
    private int anio;
    
    // Constructor para inicializar.
    public Vehiculo(){
        this.marca = "";
        this.modelo = "";
        this.anio = 0;
    }
    
    // Otro constructor para parametos.
    public Vehiculo(String marca, String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
     
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    } 
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public void mostrarInformacion(){
        System.out.println("Clase vehiculo");
        System.out.println("Marca: "+marca);
    }
}
