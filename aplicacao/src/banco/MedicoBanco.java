/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Medico;

/**
 *
 * @author davi
 */
public class MedicoBanco {
    
    public void adicionar(Medico medico)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into medico values (default, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, medico.getNome());
            statement.setInt(2, medico.getNum_crm());
            statement.setString(3, medico.getEspecialidade());
            
            statement.executeUpdate();
            
            System.out.println("Médico adicionado com sucesso");
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    
    public int buscar_por_nome(String nome)
    {   
        int id_busca = 0;
        try
        {     
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select id from medico where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            statement.setString(1, nome);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                id_busca = rs.getInt("id");

            }            
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        System.out.println(id_busca);
        return id_busca;
    }
    
    public void listar()
    {        
        try
        {     
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from medico";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
            System.out.println("------Médicos------");
            while(rs.next())
            {     
                //poderíamos usar um arraylist de médico e retornar, porém como não vamos utilizar para nada, apenas para mostrar
                //vou apenas printar
                System.out.println("\nId: "+ rs.getInt("id"));
                System.out.println("Nome: "+ rs.getString("nome"));
                System.out.println("Crm: "+ rs.getInt("num_crm"));
                System.out.println("Especialidade: "+ rs.getString("especialidade"));
            }            
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
}

