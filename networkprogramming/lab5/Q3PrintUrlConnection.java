package lab5;
// wap to print the URL of a URlConnection
import java.net.URL;
import java.net.URLConnection;

public class Q3PrintUrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            System.out.println("URL of connection:"+ connection.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
