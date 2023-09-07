/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipointerfaces;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author Jenny
 */
public class App {

    private static byte[] decodeBase64(String encrypted) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String ip = "";
    private String usuario = "";
    private String clave="";
    private String bd = "";
    private String key;
    private String iv="";
    private FileInputStream input;
    public App()throws Exception{
        try{
            Properties props = new Properties();
            //Cargar archivo properties
            input =new FileInputStream("recursos/appconfig.properties");
            props.load(input);
            this.key=props.getProperty("servidor.key");
            this.ip = decrypt2(this.key, props.getProperty("servidor.ip"));
            
            this.usuario = decrypt2(this.key,props.getProperty("servidor.usuario"));
            //descencriptar cuando la clave se ponga encriptada
            this.clave= props.getProperty("servidor.clave");
            this.bd=props.getProperty("servidor.bd");  
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }finally {
            //cerrar el archivo
            input.close();
        }
    } 
    
    public static String decrypt2(String llave,String encrypted) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(llave);
        // Crea una especificación de clave privada PKCS#8
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        // Obtiene un objeto KeyFactory y crea la clave privada
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        byte[] encryptedData = Base64.getDecoder().decode(encrypted);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        // Descifra los datos
        byte[] decryptedData = cipher.doFinal(encryptedData);

        return new String(decryptedData);

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
