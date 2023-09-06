package prototipointerfaces;

import java.sql.*;

public class Conexion {
    
    Connection cn=null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Registra el drive de conexion para la bd
            App app = new App();
            cn = DriverManager.getConnection("jdbc:mysql://"+ app.getIp() +":3306/"+app.getBd(),app.getUsuario(),app.getClave()); // se utiliza la libreria que se impo
        // Este método crea un objeto Connection, que se utiliza para crear sentencias SQL, 
        //enviarlas a la base de datos y procesar los resultados.
                                                                                    
            System.out.println("Conexion exitosa"); // Driver es un conjunto de clase necesarias que se implementan para
                                                       // la conexion sea correcta
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cn;   
    }
    
    Statement createStatement(){
        throw new  UnsupportedOperationException("No Soportado");
    }
    
    public PreparedStatement prepareStatement(String insert_into) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}

