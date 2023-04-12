import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.javatpoint.com");
            URLConnection con =  url.openConnection();
            con.setRequestProperty("User-Agent", "Mozila/5.0");
            con.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String Content;
            while((Content =  reader.readLine())!=null)
            {
                System.out.println(Content);
            }
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
