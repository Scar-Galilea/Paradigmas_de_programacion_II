
package Cursos;

import java.util.ArrayList;

public class Curso {
    // Definir atributos.
    private String nombre;
    private String profesor;
    private ArrayList<Estudiante> listaEstudiante;
    
    // Definicion de constructores.
    public Curso(){
        this.nombre = "";
        this.profesor = "";
    }
    public Curso(String nombre, String profesor){
        this.nombre = nombre;
        this.profesor = profesor;
    }
    // Metodo get y set.
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    public String getProfesor(){
        return profesor;
    }
    public void setProfesor(String profesor){
        this.profesor = profesor;
    }
    
    // Metodo para agregar estudiante usando la clase interna
    public void agregarEstudiante(String nombre, int edad){
        Estudiante e = new Estudiante(nombre, edad);
        listaEstudiante.add(e);
    }
   
    // Definir la clase interna;
    class Estudiante{
        private String nombre;
        private int edad;
        
        // Definicion de constructores.
        public Estudiante(){
            this.nombre = "";
            this.edad = 0;
        }
        public Estudiante(String nombre, int edad){
            this.nombre = nombre;
            this.edad = edad;
        }     
        // Metodo get y set.
        public String getNombre(){
            return nombre;
        }
        public void setNombre(String nombre){
            this.nombre = nombre; 
        }
        public int getEdad(){
            return edad;
        }
        public void setEdad(int edad){
            this.edad = edad;
        }
        
        // Implementacion de metodos con funcionalidad especifica.
        public void mostrarDatos(){
            System.out.println("Curso: " + nombre + "\n");
        }
    }
 
    //  Metodos.
    public void mostrarInformacion(){
        System.out.println("Curso: " + nombre);
        System.out.println("Profesor: " + profesor);
        System.out.println("Estudiante \n");
        for (Estudiante e: listaEstudiante){
            e.mostrarDatos();
        }
    }
   
}

