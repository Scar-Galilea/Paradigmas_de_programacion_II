package Figuras;
// En una clase abstracta no gether y sether.
public abstract class Figura {
    // Atributos.
    // En una clase abstracta no gether y sether.
    private String color;
   
    // Metodos abstractos.
    abstract void dibujar();
    
    // Metodo no abstracto.
    void establecerColor(String color){
        System.out.println("Color: "+ color);
    }
    
}
