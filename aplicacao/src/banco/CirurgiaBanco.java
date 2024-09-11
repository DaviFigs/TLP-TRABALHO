/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Cc;
import trabalho.tlp.Medico;
import trabalho.tlp.Paciente;
import trabalho.tlp.Reserva;

/**
 *
 * @author davi
 */
public class CirurgiaBanco {
    public void adicionar(Medico medico, Paciente paciente,Reserva reserva)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into cirurgia values (default, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setInt(1, medico.getId());
            statement.setInt(2, paciente.getId());
            statement.setInt(3, reserva.getId());
            ResultSet rs = statement.executeQuery();
            
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
