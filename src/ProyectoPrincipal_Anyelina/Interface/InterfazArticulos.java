/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoPrincipal_Anyelina.Interface;

import ProyectoPrincipal_Anyelina.Articulos;

/**
 *
 * @author Angie
 */
public interface InterfazArticulos {
    public boolean agregarArticulo(Articulos a);
    public String eliminarArticulo (int id);
    public Articulos actualizarArticulos (int id, Articulos a);
    public boolean listarArticulos(int id);
}
