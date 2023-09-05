/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

/**
 *
 * @author santiago
 */
public class NodoProducto {
    Producto info;
    NodoProducto atras;
    NodoProducto adelante;
    
    
    public void crearNodo(Producto producto){
        this.info = producto;
        this.adelante = null;
        this.atras = null;
    }
}
