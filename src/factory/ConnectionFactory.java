/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import java.sql.Connection; //conexao SQL para Java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.SQLException; //classe para tratameto de exceções
/**
 *
 * @author vinia
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Alunos","root","1234");
    }
        catch(SQLException execao){
        throw new RuntimeException(execao);
    }
    }
}
