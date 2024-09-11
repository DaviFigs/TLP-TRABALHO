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
    
    public void listar_cirurgias(int numero_cc){
        int id_cirurgia
        
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select cirurgia.id, paciente.nome nome_paciente, medico.nome nome_medico, reserva.data_hora from centro_cirurgico \n" +
                "inner join reserva on reserva.id_centrocirurgico = centro_cirurgico.id \n" +
                "inner join cirurgia on cirurgia.id_reserva = reserva.id \n" +
                "inner join medico on medico.id = cirurgia.id_medico \n" +
                "inner join paciente on paciente.id = cirurgia.id_paciente \n" +
                "where centro_cirurgico.id = ?;";
            
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setInt(1,numero_cc);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                
                pessoa_busca.setId(rs.getInt("id"));
                pessoa_busca.setNome(rs.getString("nome_paciente"));
                pessoa_busca.setRg(rs.getString("rg"));    
                resultados.add(pessoa_busca);
            }

            
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
