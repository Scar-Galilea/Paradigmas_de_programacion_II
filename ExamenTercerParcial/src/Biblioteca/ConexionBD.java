package Biblioteca;
import java.sql.*;

public class ConexionBD{
    
    //Definir la ruta de nuestrabase de datos
    private static String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static String user = "ADMIN";
    private static String pass = "root";
    
    // Metodos Get y Set
    public static String getUrl(){
        return url;
    }
    public static void setUrl(String url){
        ConexionBD.url = url;
    }
    public static String getUser(){
        return user;
    }
    public static void setUser(String user){
        ConexionBD.user = user;
    }
    public static String getPass(){
        return pass;
    }
    public void setPass(String pass){
        ConexionBD.pass = pass;
    }
    // Se define un metodo conexion de tipo Connection
    public static Connection conexion(){
        Connection con = null;
        try{
            con =DriverManager.getConnection(getUrl(),getUser(),getPass());
            System.out.println("Conexion exitosa");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }  
    
}