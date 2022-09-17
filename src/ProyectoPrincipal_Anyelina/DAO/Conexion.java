/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoPrincipal_Anyelina.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Angie
 */
public class Conexion {
    

    public Connection Conectar(){
            Connection con= null;
            
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ArticulosHogar_Anyelina?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Anymzr1702*");
        }catch(Exception e){
            System.err.println("Error: " + e);
        }
        return con;
    }
    
    public Conexion(){
        Conectar();
    }
    
    public static void main(String[]args){
       new Conexion();
    }
    
}
