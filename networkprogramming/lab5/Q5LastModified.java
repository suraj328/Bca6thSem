package lab5;
// wap to get the time when a url was last changed
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

public class Q5LastModified {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.example.com");
        URLConnection con = url.openConnection();
        long lastModified = con.getLastModified();
        Date date = new Date(lastModified);
        System.out.println("Last modified date is: "+date);
    }
}
