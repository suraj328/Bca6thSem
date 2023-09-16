import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class UrlPasswordAuthenication {

    public static void main(String[] args) throws IOException {
        // Prompt the user for their username and password.
        String username = System.console().readLine("Username: ");
        char[] password = System.console().readPassword("Password: ");

        // Create a PasswordAuthentication object with the user's username and password.
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(username, password);

        // Set the Authenticator class to use the PasswordAuthentication object.
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });

        // Create a URL object for the password-protected site that you want to access.
        URL url = new URL("https://example.com/protected");

        // Open a connection to the URL.
        URLConnection connection = url.openConnection();

        // The connection will be authenticated using the PasswordAuthentication object.

        // Read the response from the server.
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
