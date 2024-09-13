/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import trabalho.tlp.Paciente;

public class PacienteBanco 
{
    
    public void adicionar(Paciente paciente)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into paciente values (default, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, paciente.getNome());
            statement.setInt(2, paciente.getCod_sus());
            statement.setString(3, paciente.getCpf());
            
            statement.executeUpdate();
            
            System.out.println("Médico adicionado com sucesso");
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
            System.out.println("Erro: "+e);
        }
    }
    
    public int buscar_por_nome(String nome)
    {   
        int id_busca = 0;
        try
        {
            
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select id from paciente where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setString(1, nome);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                id_busca = rs.getInt("id");

            }          
            System.out.println(id_busca);
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
            System.out.println("Erro: "+e);
        }
        return id_busca;
    }
    
    
    public void listar()
    {        
        try
        {     
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from paciente";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            System.out.println("____________Pacientes____________");
            while(rs.next())
            {     
                System.out.println("\nId: "+ rs.getInt("id"));
                System.out.println("Nome: "+ rs.getString("nome"));
                System.out.println("Código SUS: "+ rs.getInt("cod_sus"));
                System.out.println("CPF: "+ rs.getString("cpf"));
            }            
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
            System.out.println("Erro: "+e);
        }
    }
}
