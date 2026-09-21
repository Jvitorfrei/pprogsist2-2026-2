import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String sql = "SELECT id, nome, preco, quantidade FROM produtos ORDER BY id";

        try (Connection conexao = ModuloConexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Lista de Produtos ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");

                System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f | Quantidade: %d%n",
                        id, nome, preco, quantidade);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou consultar o banco de dados:");
            e.printStackTrace();
        }
    }
}
