/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santiago
 */
public class Producto {
    String codigo;
    String nombre;
    String tipo;
    int stock;
    double precioUnitario;
    double precioDistribuidor;
    String proveedor;
    String sucursal;
    
    
    public boolean esCodigoValido(String codigo){
        Pattern p = Pattern.compile("[A-Z]{3}[0-9]{3}");
        Matcher m = p.matcher(codigo);
        return m.matches();
    }
    
    public boolean esNombreValido(String nombre){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,50}");
        Matcher m = p.matcher(nombre);
        return m.matches();
    }
    
    public boolean esTipoValido (String tipo){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,40}");
        Matcher m = p.matcher(tipo);
        return m.matches();
    }
    
    public boolean esStockValido (String stock){
        Pattern p = Pattern.compile("^[0-9]+");
        Matcher m = p.matcher(stock);
        return m.matches();
    }
    
    public boolean esPrecioUnitarioValido (String stock){
        Pattern p = Pattern.compile("^[0-9]+\\.[0-9]{1,2}");
        Matcher m = p.matcher(stock);
        return m.matches();
    }
    
    public boolean esPrecioDistribuidorValido (String stock){
        Pattern p = Pattern.compile("^[0-9]+\\.[0-9]{1,2}");
        Matcher m = p.matcher(stock);
        return m.matches();
    }
    
    public boolean esProveedorValido (String proveedor){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,40}");
        Matcher m = p.matcher(proveedor);
        return m.matches();
    }
    
    public boolean esSucursalValida(String sucursal){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,40}");
        Matcher m = p.matcher(sucursal);
        return m.matches();
    }
    
    public void resetearProducto(){
        this.codigo = "";
        this.nombre = "";
        this.tipo = "";
        this.stock = 0;
        this.precioUnitario = 0;
        this.precioDistribuidor = 0;
        this.proveedor = "";
        this.sucursal = "";
    }

    @Override
    public String toString() {
        return codigo + 
               "\t" + nombre +
               "\t\t" + tipo +
               "\t" + stock +
               "\t" + precioUnitario + "\n";
    }
    
    
    
}
