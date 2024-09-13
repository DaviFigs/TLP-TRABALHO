package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trabalho.tlp.Cirurgia;
import trabalho.tlp.Medico;

public class CirurgiaBanco {

    public void adicionar(Cirurgia cirurgia) {
        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into cirurgia values(default, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, cirurgia.getPaciente().getId());
            statement.setInt(2, cirurgia.getMedico().getId());
            statement.setInt(3, cirurgia.getReserva().getId());

            statement.executeUpdate();

            System.out.println("\nCirurgia adicionada com sucesso!");
            statement.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro: "+e);
        }
    }

    public void listar_cirurgias(int numero_cc) {

        try {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select cirurgia.id, paciente.nome nome_paciente, medico.nome nome_medico, reserva.data_hora from centro_cirurgico \n"
                    +
                    "inner join reserva on reserva.id_centrocirurgico = centro_cirurgico.id \n" +
                    "inner join cirurgia on cirurgia.id_reserva = reserva.id \n" +
                    "inner join medico on medico.id = cirurgia.id_medico \n" +
                    "inner join paciente on paciente.id = cirurgia.id_paciente \n" +
                    "where centro_cirurgico.id = ?;";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, numero_cc);

            ResultSet rs = statement.executeQuery();
            
            System.out.println("_______________Cirurgias________________");
            while (rs.next()) {
                System.out.println("\nId Cirurgia: " + rs.getInt("id"));
                System.out.println("Nome Paciente: " + rs.getString("nome_paciente"));
                System.out.println("Nome Médico: " + rs.getString("nome_medico"));
                System.out.println("Data: " + rs.getString("data_hora"));

            }
            statement.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro: "+e);
        }
    }

    public void alterar_medico(Cirurgia cirurgia, Medico medico) {
        try {
            // Buscar o ID do médico pelo nome
            Connection conexao = ConectaBanco.getConnection();
          
            MedicoBanco mb = new MedicoBanco();
            int id_medico_atual = mb.buscar_por_nome(medico.getNome());
            int id_medico_passado = cirurgia.getId();
            

            // Atualizar o médico na cirurgia
            String sql = "UPDATE cirurgia SET id_medico = ? WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id_medico_atual);
            statement.setInt(2, cirurgia.getId());

            // Executa
            statement.executeUpdate();
            statement.close();
            System.out.println("\nMédico Alterado!");
            System.out.println("Cirurgia :"+cirurgia.getId()+"\nID Médico passado: "+id_medico_passado+ "\t|\t" +"ID Medico atual: "+id_medico_atual);
            

        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
    }
    
    
    public int get_id_medico(int id_cirurgia)
    {
        int id_medico =0;
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select id_medico from cirugia where id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, id_cirurgia);
            ResultSet rs = statement.executeQuery();

            id_medico = rs.getInt("id_medico");
            statement.close();
            conexao.close();
            
        }
    catch (Exception e) {
            System.out.println("Erro: "+e);
        }
        System.out.println(id_medico);
        return id_medico;
    }

}
