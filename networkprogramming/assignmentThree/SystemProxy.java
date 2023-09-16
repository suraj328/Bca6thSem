import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class SystemProxy {

    public static void main(String[] args) throws IOException {
        // Set the proxy system properties.
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8080");

        // Create a URL and open a connection to it.
        URL url = new URL("http://www.example.com");
        URLConnection connection = url.openConnection();

        // The connection will be made through the proxy server.
    }
}
