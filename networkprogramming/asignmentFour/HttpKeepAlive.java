package asignmentFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpKeepAlive{

    public static void main(String[] args) throws IOException {
        // Create a URL object for the resource that you want to access.
        URL url = new URL("https://example.com/");

        // Open a connection to the resource.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the Connection header to keep-alive.
        connection.setRequestProperty("Connection", "keep-alive");

        // Connect to the resource.
        connection.connect();

        // Read the response from the resource.
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Disconnect from the resource.
        connection.disconnect();
    }
}
