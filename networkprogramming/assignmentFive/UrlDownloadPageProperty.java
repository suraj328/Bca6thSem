import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * UrlDownloadPageProperty
 */
public class UrlDownloadPageProperty {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            HttpURLConnection httpConn =  (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");

            // provide response or status which you are trying to request from url
            int responseCode =  httpConn.getResponseCode();
            System.out.println("Response Code = "+responseCode);
            // provide content length which you are trying to request from url
            System.out.println("Content Length =  "+httpConn.getContentLength());
            // provide conetnet type  which you are trying to request for url
            System.out.println("Content Type =  "+httpConn.getContentType());
            // provide last modified which you are trying to request for url
            System.out.println("Last modified =  "+httpConn.getLastModified());

            //read the conetent of url
            BufferedReader reader =  new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            httpConn.disconnect();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}