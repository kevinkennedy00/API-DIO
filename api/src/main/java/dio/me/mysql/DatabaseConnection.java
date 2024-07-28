package dio.me.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // URL de conexão fornecida pela Railway
        String url = "jdbc:mysql://roundhouse.proxy.rlwy.net:12350/railway";
        String user = "root"; // Substitua pelo seu usuário
        String password = "maioral747@A"; // Substitua pela sua senha

        try {
            // Conectando ao banco de dados MySQL
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao banco de dados.");
            // Sua lógica de banco de dados aqui
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
