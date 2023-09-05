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
public class Usuario {
    private String cedula;
    private String usuario;
    private String password;
    private String tipoUsuario;

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public boolean esUsuarioValido(String usuario){
        Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{1,10}");
        Matcher m = p.matcher(usuario);
        return m.matches();
    }
    
    public boolean esPasswordValida(String password){
        Pattern p = Pattern.compile("([\\s|\\@|\\.|\\-|\\_]*[a-zA-Z0-9\\s][\\s|\\@|\\.|\\-|\\_]*){1,10}");
        Matcher m = p.matcher(password);
        return m.matches();
    }
    
    public boolean esTipoUsuarioValido(String usuario){
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,21}");
        Matcher m = p.matcher(usuario);
        return m.matches();
    }
    
    public String validarCedula(String numCedula) {
        int ultimoDigito = Character.getNumericValue(numCedula.charAt(9));
        int sumaImpares = 0;
        int sumaPares = 0;
        for(int i=0; i<numCedula.length(); i+=2){
            int impar = Character.getNumericValue(numCedula.charAt(i));
            int imparDuplicado = impar * 2;
            int imparAUsar = 0;
            if (imparDuplicado >= 10) {
                imparAUsar = imparDuplicado - 9;
            }else{
                imparAUsar = imparDuplicado;
            }
            sumaImpares = sumaImpares + imparAUsar;
        }
        for(int j=1; j<numCedula.length()-1; j+=2){
            int par = Character.getNumericValue(numCedula.charAt(j));
            sumaPares = sumaPares + par;
        }
        int sumaTotal = sumaImpares + sumaPares;
        int verificador = (sumaTotal - (sumaTotal%10) + 10) - sumaTotal;
        int numeroAComparar;
        if (verificador == 10){
            numeroAComparar = 0;
        }else{
            numeroAComparar = verificador;
        }
        if (ultimoDigito == numeroAComparar) {
            return numCedula;
        } else {
            return numCedula = "xxxxxxxxxx";
        }
    }
    
    public boolean esCedulaValida(String cedula){
        if(cedula.equals("xxxxxxxxxx")){
            return false;
        }
        return true;
    }
    
}
