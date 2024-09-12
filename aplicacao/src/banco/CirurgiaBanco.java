package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trabalho.tlp.Cirurgia;
import trabalho.tlp.Medico;

/**
 *
 * @author davi
 */
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

            System.out.println("Cirurgia adicionada com sucesso");
            statement.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
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

            while (rs.next()) {
                System.out.println("\nId Cirurgia: " + rs.getInt("id"));
                System.out.println("Nome Paciente: " + rs.getString("nome_paciente"));
                System.out.println("Nome Médico: " + rs.getString("nome_medico"));
                System.out.println("Data: " + rs.getString("data_hora"));

            }
            statement.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AlterarMedico(Cirurgia cirurgia, Medico medico) {
        try {
            // 1. Buscar o ID do médico pelo nome
            Connection conexao = ConectaBanco.getConnection();
            String sql = "SELECT id FROM Medico WHERE nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, medico.getNome());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int IdMedico = rs.getInt("id");

                // 2. Atualizar o médico na cirurgia
                String sql = "UPDATE Cirurgia SET id_medico = ? WHERE id = ?";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setInt(1, IdMedico);
                statement.setInt(2, cirurgia.getId());

                // Executa a atualização
                statement.executeUpdate();

                // Fechamento dos recursos
                statement.close();
            }

            // Fechamento dos recursos
            statement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
