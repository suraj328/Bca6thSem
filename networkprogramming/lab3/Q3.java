import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Q3 {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.google.com");
            Object o = u.getContent();
            System.out.println("I got a " + o.getClass().getName());
        } 
        catch (MalformedURLException  e) 
        {
            System.err.println("is not a paraseable error");
        }
        catch (IOException  e)
        {
            System.err.println(e);
        }
    }
}

// wap to download content