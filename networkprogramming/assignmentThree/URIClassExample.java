import java.net.URI;
import java.net.URISyntaxException;

/**
 * URIClassExample
 */
public class URIClassExample {

    public static void main(String[] args) {
        try {
            URI uri =  new URI("https://username:password@example.com:8080/path/to/resource?key=value#fragment");
            // getAuthority inclueds username ,password including with host name as well port to return
            System.out.println("Authority from given uri is "+uri.getAuthority());
            // getHost provides the host name from url like domian name
            System.out.println("Host name from given uri is"+uri.getHost());
            //retrive the port information from given uri
            System.out.println("port from given uri is "+uri.getPort());
            // getPath  returns resources path from uri ,it will identify from where resoucrse is locating
             System.out.println("Path of resoucres from given uri is is "+ uri.getPath());
             //getQuery methods return Query from uri
             System.out.println("query recived from given uri is"+uri.getQuery());
             //getScheme methods return scheme from uri as like http,https
             System.out.println("Scheme recived from given uri is "+uri.getScheme());

        } catch (URISyntaxException e) {

            e.printStackTrace();
        }
    }
}