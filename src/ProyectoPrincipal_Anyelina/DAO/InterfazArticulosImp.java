/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoPrincipal_Anyelina.DAO;

import ProyectoPrincipal_Anyelina.Articulos;
import ProyectoPrincipal_Anyelina.Interface.InterfazArticulos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Angie
 */
public class InterfazArticulosImp implements InterfazArticulos {
    
    public boolean agregarArticulo(Articulos a){
                Conexion conect = new Conexion();
        try{
            String sql = "INSERT INTO Articulos(Articulo,Precio,Cantidad) VALUES(?,?,?);";
            PreparedStatement stmt = conect.Conectar().prepareStatement(sql);
            stmt.setString(1, a.getArticulo());
            stmt.setDouble(2, a.getPrecio());
            stmt.setInt(3, a.getCant_en_Stock());
            System.out.println(stmt);
            stmt.executeUpdate();

               return true;

        }catch(Exception e){}
        return false;
    }
    
    public String eliminarArticulo (int id){
        throw new UnsupportedOperationException("Not supported");
    }
    
    public Articulos actualizarArticulos (int id, Articulos a){
        throw new UnsupportedOperationException("Not supported");
    }
    
    public boolean listarArticulos(int id){
        throw new UnsupportedOperationException("Not supported");
    }
}
