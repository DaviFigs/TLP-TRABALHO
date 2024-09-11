/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Cirurgia;

/**
 *
 * @author davi
 */
public class CirurgiaBanco {
    
    public void adicionar(Cirurgia cirurgia)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into cirurgia values(default, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setInt(1, cirurgia.getPaciente().getId());
            statement.setInt(2, cirurgia.getMedico().getId());
            statement.setInt(3, cirurgia.getReserva().getId());
            
            statement.executeUpdate();
            
            System.out.println("Cirurgia adicionada com sucesso");
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    
}
