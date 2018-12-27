package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        String table = "EMAIL";
        List<String> listMails = new MailListReader().read("C:\\Users\\charl\\Documents\\NetBeansProjects\\Kata5\\emails.txt");
        String sql = "INSERT INTO " + table + "(mail)" + " VALUES(?)";
        
        try (Connection conn= connect();
            PreparedStatement pstmt= conn.prepareStatement(sql)) {
            for (String email : listMails) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   

    public static Connection connect() {
        Connection conn= null;
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:Kata5.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
