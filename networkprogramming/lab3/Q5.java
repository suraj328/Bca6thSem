import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.net.URLDecoder;

public class Q5 {
    public static void main(String[] args) {
        try {
            // simple method
            String url0 = "https://www.google.com/?q=Bard";

            // Encode the URL.
            String encodedUrl = URLEncoder.encode(url0, "UTF-8");

            System.out.println("Encoded URL: " + encodedUrl);

            // Decode the URL.
            String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");

            System.out.println("Decoded URL: " + decodedUrl);

            //by value
            String url = "https://www.google.com";
            String charset = "UTF-8";
            String param1 = "value 1";
            String param2 = "value 2";

            // Corrected format string with %s placeholders
            String query = String.format("param1=%s&param2=%s", URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset));
            System.out.println(query);

            // String dquery = String.format("param1=%s&param2=%s", URLDecoder.decode(param1, charset),
            //         URLEncoder.encode(param2, charset));
            // System.out.println(dquery);
            // HttpURLConnection connection = (HttpURLConnection) new URL(url + "?" +
            // query).openConnection();
            // connection.setRequestMethod("GET");
            // connection.setRequestProperty("Accept-Charset", charset);

            // InputStream responseStream = connection.getInputStream();
            // BufferedReader reader = new BufferedReader(new
            // InputStreamReader(responseStream));
            // String line;
            // while ((line = reader.readLine()) != null) {
            // System.out.println(line);
            // }
            // reader.close();
            // connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
