/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Importación de Librerías Necesarias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * 
 */
public class ClsConexion {
    //Creacion de variables para conectar con la base de datos
    final String bdd="sistema_gestion_eventos"; //variable tipo string para el nombre de la base de datos
    final String user="root";// variable tipo string para usuario de la base de datos (por defecto es root)
    String pwd="";// variable tipo string para clave de la base de datos (por defecto no tiene clave)
    String url="jdbc:mysql://localhost:3306/" + bdd;// esta variable concatena la url que nos proporciona el xampp mas el nombre de la base de datos
    Connection conexion; // Variable tipo conecction para la conexion
    
    /**Metodo para obtener la conexion con la base de datos**/
    public Connection getConexion(){
    
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion=(Connection)DriverManager.getConnection(url,user,pwd);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ClsConexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        return conexion;
    }
}
