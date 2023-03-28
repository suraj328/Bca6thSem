import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class URLClassExample {
    public static void main(String[] args) {
        try {
            URL url =  new URL("https://www.example.com/path/file.html?param1=value1&param2=value2#fragment");
            System.out.println("host of url is: - "+ url.getHost());
            System.out.println("path of url is " + url.getPath());
            System.out.println("Query string of url is " + url.getQuery());
            System.out.println("file of url is" + url.getFile());
            System.out.println("protocol of url is" + url.getProtocol());
            System.out.println("port of url is" + url.getPort());
            System.out.println("content of url is" + url.getContent());
            System.out.println("user info of url is" + url.getUserInfo());
            System.out.println("ref of url is" + url.getRef());


            //openConnection
            URL url2 =  new URL("https://www.example.com");
            URLConnection conn = url2.openConnection();

            BufferedReader reader =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String text;
            while( (text =  reader.readLine()) != null )
            {
                System.out.println(text);
            }
        } catch (Exception e) {
            
        }
    }
}
