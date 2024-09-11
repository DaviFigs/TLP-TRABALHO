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

/**
 *
 * @author davi
 */
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
            ResultSet rs = statement.executeQuery();
            
            System.out.println("Paciente adicionado com sucesso");
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
        e.printStackTrace();
        }
        return id_busca;
    }
    //função 1
   /*     
    public ArrayList<Pessoa> buscar_por_rg(Pessoa pessoa)
    {   
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        Pessoa pessoa_busca = new Pessoa();
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from pessoa where rg = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, pessoa.getRg());
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                pessoa_busca.setId(rs.getInt("id"));
                pessoa_busca.setNome(rs.getString("nome"));
                pessoa_busca.setRg(rs.getString("rg"));    
                resultados.add(pessoa_busca);
            }
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
        for(int i=0; i<resultados.size(); i++){
            System.out.println("id: " +resultados.get(i).getId());
            System.out.println("nome: "+ resultados.get(i).getNome());
            System.out.println("rg: "+ resultados.get(i).getRg());
        }
        return resultados;
    }
    
    //função 2
    
    public ArrayList<Pessoa>  buscar_pessoas()
    {   
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();//lista na qual ficarão os resultados
        
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from pessoa ";
            PreparedStatement statement = conexao.prepareStatement(sql);
            //statement.setString(1, pessoa.getRg());
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Pessoa pessoa_busca = new Pessoa();
                pessoa_busca.setId(rs.getInt("id"));
                pessoa_busca.setNome(rs.getString("nome"));
                pessoa_busca.setRg(rs.getString("rg"));    
                resultados.add(pessoa_busca);
            }
            for(int i=0; i<resultados.size(); i++)//mostra os resultados na tela, for percorre a lista de resultados e mostra um por um
            {
            System.out.println("\nid: " +resultados.get(i).getId());
            System.out.println("nome: "+ resultados.get(i).getNome());
            System.out.println("rg: "+ resultados.get(i).getRg());
            }
            
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
        return resultados;
    }
    
    //funcao 6
    public void buscar_pessoa_e_endereco(Pessoa pessoa) //não vamos retornar nada, só mostrar no bando de dados
    {   
        ArrayList<Pessoa> resultados_pessoa = new ArrayList<Pessoa>();
        ArrayList<Endereco> resultados_endereco = new ArrayList<Endereco>();

        
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from pessoa"
                    + " inner join endereco"
                    + " on pessoa.id_endereco = endereco.id"
                    + " where pessoa.rg = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, pessoa.getRg());
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Pessoa pessoa_busca = new Pessoa();
                pessoa_busca.setId(rs.getInt("id"));
                pessoa_busca.setNome(rs.getString("nome"));
                pessoa_busca.setRg(rs.getString("rg"));  
                resultados_pessoa.add(pessoa_busca);
                
                Endereco endereco_busca = new Endereco();
                endereco_busca.setId(rs.getInt("id_endereco"));
                endereco_busca.setBairro(rs.getString("bairro"));
                endereco_busca.setRua(rs.getString("rua"));
                endereco_busca.setNumero(rs.getInt("numero"));
                
                resultados_endereco.add(endereco_busca);
                
            }
            for(int i=0; i<resultados_pessoa.size(); i++){
            System.out.println("id: " +resultados_pessoa.get(i).getId());
            System.out.println("nome: "+ resultados_pessoa.get(i).getNome());
            System.out.println("rg: "+ resultados_pessoa.get(i).getRg());
            System.out.println("endereco_id: "+ resultados_endereco.get(i).getId());
            System.out.println("bairro: "+ resultados_endereco.get(i).getBairro());
            System.out.println("rua: "+ resultados_endereco.get(i).getRua());
            System.out.println("numero: "+ resultados_endereco.get(i).getNumero());
            }
            
                   
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    
    public void buscar_pessoas_e_enderecos() //não vamos retornar nada, só mostrar no bando de dados
    {   
        ArrayList<Pessoa> resultados_pessoa = new ArrayList<Pessoa>();
        ArrayList<Endereco> resultados_endereco = new ArrayList<Endereco>();

        
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from pessoa"
                    + " inner join endereco"
                    + " on pessoa.id_endereco = endereco.id";
            PreparedStatement statement = conexao.prepareStatement(sql);
            //statement.setString(1, pessoa.getRg());
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Pessoa pessoa_busca = new Pessoa();
                pessoa_busca.setId(rs.getInt("id"));
                pessoa_busca.setNome(rs.getString("nome"));
                pessoa_busca.setRg(rs.getString("rg"));  
                resultados_pessoa.add(pessoa_busca);
                
                Endereco endereco_busca = new Endereco();
                endereco_busca.setId(rs.getInt("id_endereco"));
                endereco_busca.setBairro(rs.getString("bairro"));
                endereco_busca.setRua(rs.getString("rua"));
                endereco_busca.setNumero(rs.getInt("numero"));
                
                resultados_endereco.add(endereco_busca);
                
            }
            for(int i=0; i<resultados_pessoa.size(); i++){
            System.out.println("\n\nid: " +resultados_pessoa.get(i).getId());
            System.out.println("nome: "+ resultados_pessoa.get(i).getNome());
            System.out.println("rg: "+ resultados_pessoa.get(i).getRg());
            System.out.println("endereco_id: "+ resultados_endereco.get(i).getId());
            System.out.println("bairro: "+ resultados_endereco.get(i).getBairro());
            System.out.println("rua: "+ resultados_endereco.get(i).getRua());
            System.out.println("numero: "+ resultados_endereco.get(i).getNumero());
            }
            
                   
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
        e.printStackTrace();
        }*/
    }
