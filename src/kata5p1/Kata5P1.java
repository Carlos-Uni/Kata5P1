package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        createNewTable("jdbc:sqlite:Kata5.db", "EMAIL");
    }   

public static void createNewTable(String url, String table) {
        // Instrucción SQL para crear nueva tabla
        String sql= "CREATE TABLE IF NOT EXISTS " + table + " (\n"
            + "id integer PRIMARY KEY AUTOINCREMENT,\n"
            + "mail text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
