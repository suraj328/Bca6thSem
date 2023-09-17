import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 2.download page
 */
public class RetrieveArbitaryHeaders {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com");
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent","Mozilla/5.0");

            int resCode =  con.getResponseCode();
            System.out.println(resCode);
            if(resCode == 200)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
               
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println(response.toString());
            reader.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}