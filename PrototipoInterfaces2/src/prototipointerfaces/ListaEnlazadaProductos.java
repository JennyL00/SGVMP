/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author santiago
 */
public class ListaEnlazadaProductos {
    private NodoProducto cabecera; // Este es el nodo inicial de la lista

    public ListaEnlazadaProductos() {
        this.cabecera = null;
    }

    public NodoProducto getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoProducto cabecera) {
        this.cabecera = cabecera;
    }

    public String mostrar() {
        String texto = "";
        if (this.cabecera == null) {
            return null;
        }
        NodoProducto actual = this.cabecera;
        while (actual.adelante != null) {
            texto += actual.info;
            actual = actual.adelante;
        }
        texto += actual.info;
        return texto;
    }

    public void insertarOrdenado(Producto producto) {
        NodoProducto insertObject = new NodoProducto();
        insertObject.crearNodo(producto);
        if (this.cabecera == null) {
            this.cabecera = insertObject;
            this.cabecera.atras = null;
            this.cabecera.adelante = null;
        } else {
            NodoProducto temp = this.cabecera;
            if (producto.codigo.compareTo(temp.info.codigo) < 0) {
                insertObject.adelante = temp;
                temp.atras = insertObject;
                insertObject.atras = null;
                this.cabecera = insertObject;
            } else {
                NodoProducto tempIzq = temp;
                NodoProducto tempDer = temp.adelante;
                while (tempIzq.adelante != null) {
                    if (producto.codigo.compareTo(tempDer.info.codigo) < 0) {
                        insertObject.adelante = tempDer;
                        insertObject.atras = tempIzq;
                        tempIzq.adelante = insertObject;
                        tempDer.atras = insertObject;
                        break;
                    } else {
                        tempIzq = tempIzq.adelante;
                        tempDer = tempDer.adelante;
                    }
                }
                if (tempIzq.adelante == null) { // Insertar al final de la lista
                    insertObject.atras = tempIzq;
                    tempIzq.adelante = insertObject;
                    insertObject.adelante = null;
                }
            }
        }
    }
    
    public boolean estaEnLista(NodoProducto nodo){
        NodoProducto nodoActual = this.cabecera;
        int bandera = 0;
        while (bandera == 0){
            if (nodoActual.adelante != null){
                if (!nodo.equals(nodoActual)){
                    nodoActual = nodoActual.adelante;
                }else{
                    return true;
                }
            }else{
                if (!nodo.equals(nodoActual)){
                    bandera = 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    
    public NodoProducto buscar(String nombre){
        NodoProducto actual = this.cabecera;
        int j = 0;
        while (j == 0){
            if (actual.adelante != null){
                if (actual.info.nombre.equals(nombre)){
                    return actual;
                }else{
                    actual = actual.adelante;
                }
            }else{
                if (actual.info.nombre.equals(nombre)){
                    return actual;
                }else{
                    j = 1;
                }
            }   
        }
        return null;
        
    }
    
    public void eliminarNodo(NodoProducto nodoAEliminar){
        if (this.cabecera == null) {
            JOptionPane.showMessageDialog(null, "No hay productos en lista");
        } else {
            if (nodoAEliminar.atras == null){ //Si es el primer nodo
                NodoProducto siguiente = nodoAEliminar.adelante;
                this.cabecera = siguiente;
                //nodo = null;
            } else {
                if(nodoAEliminar.adelante == null){ //Si es el último nodo
                    NodoProducto anterior = nodoAEliminar.atras;
                    anterior.adelante = null;
                    //nodo = null;
                }else{
                    NodoProducto nodoIzq = nodoAEliminar.atras;
                    NodoProducto nodoDer = nodoAEliminar.adelante;
                    nodoIzq.adelante = nodoDer;
                    nodoDer.atras = nodoIzq;
                    //nodo = null;
                }
            }
        }
            
    }
    
    public void resetear(){
        this.cabecera = null;
    }
    /*
    public String obtenerEmpleado(String codigo) {
        String empleado = "";
        NodoEmpleadoLista actual = this.cabecera;
        while (!actual.getInfo().getCodigo().equals(codigo)) {
            actual = actual.getAdelante();
        }
        empleado += actual.getInfo().getNombres();
        empleado += " " + actual.getInfo().getApellidos();
        return empleado;
    }
*/
}
