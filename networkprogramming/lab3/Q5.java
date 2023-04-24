import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;


public class Q5 {
    public static void main(String[] args) 
    {
        try{
        String url = "https://www.google.com";
        String charset =  "UTF-8";
        String param1 =  "value1";
        String param2 = "value2";

        String query = String.format("param1=%s&param2=%s");
            URLEncoder.encode(param1,charset);
            URLEncoder.encode(param2,charset);

            HttpURLConnection connection =  (HttpURLConnection) new URL(url+"?"+query).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset",charset);

            InputStream responseStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            String line;
            while((line =reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
            connection.disconnect();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
