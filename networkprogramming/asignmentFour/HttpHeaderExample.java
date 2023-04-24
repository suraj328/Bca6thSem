
/**
 * HttpHeaderExample
 */
import java.net.URL;
import java.net.HttpURLConnection;

public class HttpHeaderExample {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int i = 0;
            while (true) {
                String key = conn.getHeaderFieldKey(i);
                String value = conn.getHeaderField(i);

                if (key == null && value == null) {
                    break;
                }
                System.out.println("key = "+key + ": value = " + value);
                i++;
            }
        } catch (Exception e) {
            System.out.println("error :-" + e);
        }
    }
}