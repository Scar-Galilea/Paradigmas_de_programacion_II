/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author flore
 */
public class Principal {
    public static void main(String [] args){
        Coche coche1 = new Coche();
        
        // Asignarle valores ya preterminado a mi objeto
        Coche coche2 = new Coche("sss","www", 2021);
        
        // Asignaci{on uno por uno.
        coche1.setNumPuerta(4);
        coche1.setAnio(2023);
        coche1.setMarca("qqq");
        coche1.setTipoCombustible("www");
        
        coche1.mostrarInformacion();
        
    }
    
}
