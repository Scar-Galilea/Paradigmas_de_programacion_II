/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Barcos;
// Extends es para realizar la herencia de nuestra clase Padre.
public class BarcoPasaje extends TransporteAcuatico implements Barco{
    
    // Definir atributos.
    private int numCama;
    
    // Definicion de constructores.
    public BarcoPasaje(){
        this.numCama = 0;
    }
    public BarcoPasaje(int numCama){
        this.numCama = numCama;
    }
    // Metodo get y set.
    public int getNumCama(){
        return numCama;
    }
    public void setNumCama(int numCama){
        this.numCama = numCama;
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
