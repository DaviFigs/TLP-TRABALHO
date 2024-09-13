/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Cc;

/**
 *
 * @author davi
 */
public class CcBanco {
    public void adicionar(Cc cc)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into paciente values (default)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            System.out.println("Centro Cirurgico Adicionado adicionado com sucesso");
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
}
