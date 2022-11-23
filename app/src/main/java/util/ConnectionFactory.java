/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {
    
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jbc:mysql://localhost:3306/planningday"; 
    public static String USER = "root"; 
    public static String PASS = ""; 
    
    public static Connection getConnection() {
        try {
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS);
        }catch (Exception ex){
            throw new RuntimeException ("Erro na conexão com o banco de dados", ex);
        }
    }
    
    public static void CloseConnection(Connection connection){
        try {
            if (connection != null) {
            connection.close();
            }
        }catch (Exception ex){
            throw new RuntimeException ("Erro ao fechar a conexão ");
        }
    }
}
