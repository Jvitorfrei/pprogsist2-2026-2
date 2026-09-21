import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {

    // TODO: substitua pela URL JDBC do seu projeto no Supabase
    // (Painel do Supabase -> Connect -> aba "JDBC")
    private static final String URL = "jdbc:postgresql://SEU_HOST:5432/postgres?sslmode=require";

    // TODO: substitua pelo usuário do seu banco (geralmente "postgres")
    private static final String USUARIO = "SEU_USUARIO";

    // TODO: substitua pela senha do seu banco
    private static final String SENHA = "SUA_SENHA";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
