package kata5p1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        selectAll("jdbc:sqlite:Kata5.db");
    }   

    public static void selectAll(String url){ 
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = connect(url); 
                Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(sql)){

                while (rs.next()) { 
                    System.out.println(rs.getInt("id") +  "\t" + 
                                        rs.getString("Name") + "\t" + 
                                        rs.getString("Surname") + "\t" + 
                                        rs.getString("Depto") + "\t"); 
                } 
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect(String url) {
    
        Connection conn= null;
        try {
            conn= DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
