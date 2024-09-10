/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author davi
 */
public class ConectaBanco {
    private static String url, usuario, senha;
    private static Connection con;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/teste";//modifique aqui
        usuario = "postgres";//modifique aqui
        senha = "postgres";//modifique aqui
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }   
}
