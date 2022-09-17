/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoPrincipal_Anyelina;

/**
 *
 * @author Angie
 */
public class Articulos {
    private String Articulo;
    private double Precio;
    private int Cant_en_Stock;

    public Articulos(String Articulo, double Precio, int Cant_en_Stock) {
        this.Articulo = Articulo;
        this.Precio = Precio;
        this.Cant_en_Stock = Cant_en_Stock;
    }
    
    

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCant_en_Stock() {
        return Cant_en_Stock;
    }

    public void setCant_en_Stock(int Cant_en_Stock) {
        this.Cant_en_Stock = Cant_en_Stock;
    }
    
    
}
