import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Remover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do produto a remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conexao = ModuloConexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Registro removido com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover o registro:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
