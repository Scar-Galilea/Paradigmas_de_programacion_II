/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import java.sql.*;
/**
 *
 * @author patri
 */
public class Conexion_BD {
    //Definir la ruta de nuestra base de datos
    private static String url="jdbc:mysql://localhost:3306/sistema_tutorias";
    private static String user = "ADMIN";
    private static String pass = "root";
    
    //se define un metodo conexion de tipo Connection
    public static Connection conexion(){
        Connection con= null;
        try{
            con=DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}

