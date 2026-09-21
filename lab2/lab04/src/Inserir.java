import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inserir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantidade em estoque: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection conexao = ModuloConexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println(linhasAfetadas + " registro(s) inserido(s) com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir o registro:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
