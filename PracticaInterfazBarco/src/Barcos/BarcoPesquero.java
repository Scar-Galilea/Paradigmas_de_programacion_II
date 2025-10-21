/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Barcos;

public class BarcoPesquero implements Barco{
    // Definir atributos.
    private int numPeces;
      
    // Definicion de constructores.
    public BarcoPesquero(){
        this.numPeces = 0;
    }
    public BarcoPesquero(int numPeces){
        this.numPeces = numPeces;
    }

    // Metodo get y set.
    public int getNumPeces(){
        return numPeces;
    }
    public void setNumPeces(int numPeces){
        this.numPeces = numPeces;
    }

    //  Metodos.
    @Override
    public void alarma(){
        System.out.println("Alarma del barco pesquero \n");
    }
    
    @Override
    public void msgScorro(String mensaje){
        System.out.println("!!! " + mensaje + "!!! \n");
    }
    
}
