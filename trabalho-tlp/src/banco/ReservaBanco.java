
package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trabalho.tlp.Reserva;

public class ReservaBanco {
    //função que não serve pra efetivamente nada, mas vamos deixá-la aqui pq nao quero ver vazio
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
            
            System.out.println("Reserva adicionado com sucesso");
            statement.close();
            conexao.close();


        }
        catch(Exception e)
        {
            System.out.println("Erro: "+e);
        }
    }
    
    
}
