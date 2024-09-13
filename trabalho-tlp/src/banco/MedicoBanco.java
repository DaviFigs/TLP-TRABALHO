
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Medico;


public class MedicoBanco {
    
    public void adicionar(Medico medico)
    {   
        try
        {
            Connection conexao = ConectaBanco.getConnection();//abre conexão
            String sql = "insert into medico values (default, ?, ?, ?)";//sql que irá pro banco
            PreparedStatement statement = conexao.prepareStatement(sql);//preparando o comando sql
            statement.setString(1, medico.getNome());//pega o nome do médico e coloca no primeiro ?
            statement.setInt(2, medico.getNum_crm());//pega o crm do médico e coloca no segundo ?
            statement.setString(3, medico.getEspecialidade());//entendeste
            
            statement.executeUpdate();//executa o sql no banco de dados
            
            System.out.println("Médico adicionado com sucesso");
            statement.close();//fecha comandos
            conexao.close();//fecha conexão


        }
        catch(Exception e)//pega a excessã́o/erro
        {
            System.out.println("\nErro: "+e);//printa o erro na tela, o qual foi é um objeto desta classe Exception
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
            
            ResultSet rs = statement.executeQuery();//guarda as informações da nossa busca nesse objeto rs
            
            while(rs.next())//enquanto houver buscas, percorra
            {
                id_busca = rs.getInt("id");//id_busca recebe o id buscado pela query

            }            
            statement.close();
            conexao.close();

        }
        catch(Exception e)
        {
            System.out.println("\nErro: "+e);
        }
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
            
            System.out.println("____________Médicos____________");
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
           System.out.println("\nErro: "+e);
        }
    }
    
}

