
package banco;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConectaBanco {
    
    private static String url, usuario, senha;
    private static Connection con;

    public static Connection getConnection() {
        url = "jdbc:postgresql://localhost:5432/trabalho-tlp";//modifique aqui
        usuario = "postgres";//modifique aqui
        senha = "postgres";//modifique aqui
        try{
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e)
        {
            System.out.println("Erro: "+e);
        }
        return con;
    }   
}
