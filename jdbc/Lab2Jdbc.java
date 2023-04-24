package jdbc;
import java.sql.*;
public class Lab2Jdbc {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uthinkcrazy", "root", "uthinkcrazy");

            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM courses");
            
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }

            
        } catch (Exception e) {
            System.out.println("error :-" +  e);
        }
    }
    
}