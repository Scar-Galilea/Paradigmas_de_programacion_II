package Figuras;
public class Principal {
    public static void main(String[] args){
        Circulo fig1 = new Circulo(22); // UpCasting.
        Rectangulo fig2 = new Rectangulo();
               
        // Llamando un metodo no abstracto.
        fig1.establecerColor("Rojo");
        
       // Llamando un metodo abstracto con la implementacion del circulo.
       fig1.dibujar();
       
       // Llamando un metodo abstracto con la implementacion del rectangulo.
       fig2.dibujar();
       
       // Llamando a las interfaces.
       fig1.nombreFigura();
       fig1.radio();
    }  
}                                                                   

