package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * UrlAllowedInteraction
 */
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.sql.Date;



public class UrlAllowedInteraction {

    public static void main(String[] args) throws Exception {
        // Create a URL object for the URL that you want to open a connection to.
        URL url = new URL("https://example.com/");

        // Open a connection to the URL.
        URLConnection connection = url.openConnection();
        long lastModifiedDate = connection.getLastModified();
        connection.setIfModifiedSince(lastModifiedDate);
        connection.setAllowUserInteraction(true);
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.setReadTimeout(1000);
        connection.setConnectTimeout(1000);
        connection.connect();
        // ... Use the connection ...
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        // Close the connection.
    }
}

