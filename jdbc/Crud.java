import java.sql.DriverManager;

/**
 * Crud
 */

public class Crud {
    public void jdbcConnection()

    {
        // String conUrl = "jdbc:mysql://localhost:3306/university,"+"anil,"+
        // "password";
        String conUrl = "jdbc:mysql://localhost:3306/pm";

        try (Connection con = DriverManager.getConnection(conUrl)) {
            if (con != null) {
                System.out.println("Database Connected");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Crud c1 = new Crud();
        c1.jdbcConnection();
    }

}