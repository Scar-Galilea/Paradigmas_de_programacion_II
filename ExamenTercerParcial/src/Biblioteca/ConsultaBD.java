package Biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ConsultaBD {
    
    public void insertarDatos(String nombre) throws FileNotFoundException{
        
        // Definir la setencia
        String sql = "INSERT INTO libro(ISBN, titulo, autor, anio) VALUES(?,?,?,?)";
        Scanner lector;
        try{
            lector = new Scanner(new File(nombre));
            
            Connection con = ConexionBD.conexion();
            // Preparar nuestra sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            
            while(lector.hasNext()){
                ps.setString(1,lector.next());
                ps.setString(2,lector.next());
                ps.setString(3,lector.next());
                int idLibro = lector.nextInt();
                ps.setInt(4,idLibro);
                ps.executeUpdate();
            }
            System.out.println("Dato Insertado");
            lector.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void leerDatos(String nombre, Archivo arch) throws IOException{
        // Definir sentencia
        String  sql = "select * from libro";
        
        try{
            Connection con = ConexionBD.conexion();
            // Preparar nuestra sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            System.out.println("Seleccionado");
            
            while(rs.next()){
                // Recibir toda la informacion
                int id = rs.getInt("id_libro");
                String ISBN = rs.getString("ISBN");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = rs.getInt("anio");
                
                System.out.println("Id: " + id);    
                System.out.println("ISBN: " + ISBN);
                System.out.println("Titulo: " + titulo);
                System.out.println("Autor: " + autor); 
                System.out.println("Anio: " + anio); 
                
                 // Guardar en el archivo 
                arch.escribirArchivo(nombre, String.valueOf(id));
                arch.escribirArchivo(nombre, ISBN);
                arch.escribirArchivo(nombre, titulo);
                arch.escribirArchivo(nombre, autor);
                arch.escribirArchivo(nombre, String.valueOf(anio));
                arch.escribirArchivo(nombre, "\n");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
    public void actualizarDato(Libro db){
        // Preparar nuestra sentencia
        String  sql = "update libro set ISBN = ?, titulo = ?, autor = ?, anio = ? where id_libro = ?";
        
        try{
            Connection con = ConexionBD.conexion();
            // Preparar nuestra sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, db.getISBN());
            ps.setString(2, db.getTitulo());
            ps.setString(3, db.getAutor());
            ps.setInt(4, db.getAnio());
            ps.setInt(5, db.getIdLibro());
            ps.executeUpdate();
            System.out.println("Dato actualizado");
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
    }
    
    public void eliminarDato(Libro db){
        // Definir la sentencia
        String sql = "delete from libro where id_libro = ?";
        
        try{
            Connection con = ConexionBD.conexion();
            // Prepararnuestra sentencia
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, db.getIdLibro());
            ps.executeUpdate();
            System.out.println("Dato eliminado");
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
}
