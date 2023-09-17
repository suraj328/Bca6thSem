package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class WebCache {

    private static final HashMap<URL, String> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Create a URL object for the URL that you want to read data from.
        URL url = new URL("https://example.com/");

        // Check if the data for the given URL is cached.
        String data = cache.get(url);
        // If the data is not cached, fetch it from the server.
        if (!cache.containsKey(url)) {
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();

            data = builder.toString();
            // Cache the data for future use.
            cache.put(url, data);
        } else {
            System.out.println("web cache exist no need to fetch data");
        }
        // Print the data to the console.
        System.out.println(data);
    }
}
