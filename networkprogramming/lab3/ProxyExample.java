import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ProxyExample {

    public static void main(String[] args) throws IOException {
        // Create a proxy object.
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.1", 8080));

        // Create a URL object.
        URL url = new URL("https://www.google.com/");

        // Open a connection to the URL.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

        // Set the request method.
        connection.setRequestMethod("GET");

        // Send the request.
        connection.connect();

        // Read the response.
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Close the reader.
        reader.close();

        // Disconnect from the server.
        connection.disconnect();
    }
}
