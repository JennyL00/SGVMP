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
public class Factura {
    String numFactura;
    String fecha;
    String cedulaCliente;
    String numDetalle;
    String anulado;
    double precioFinal;
    
    
    boolean esNumeroFacturaValido(String numFac){
        Pattern p = Pattern.compile("[0-9]{7}");
        Matcher m = p.matcher(numFac);
        return m.matches();
    }
    
    void resetear(){
        this.numFactura = "";
        this.fecha = "";
        this.cedulaCliente = "";
        this.numDetalle = "";
        this.anulado = "";
        this.precioFinal = 0;
    }
}
