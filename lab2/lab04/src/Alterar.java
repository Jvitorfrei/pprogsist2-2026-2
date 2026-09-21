import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Alterar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do produto a alterar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Nova quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?";

        try (Connection conexao = ModuloConexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.setInt(4, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o registro:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
