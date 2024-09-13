/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Reserva;

public class ReservaBanco {
    public void adicionar(Reserva reserva)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into paciente values (default, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setString(1, reserva.getData_hora());
            statement.setInt(1, reserva.getCc().getId());
            
            ResultSet rs = statement.executeQuery();
            
            System.out.println("Médico adicionado com sucesso");
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
            System.out.println("Erro: "+e);
        }
    }
    
    
}
