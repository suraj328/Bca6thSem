import java.net.URL;
import java.net.URI;

public class Q4 {
    public static void main(String[] args) throws Exception {
        String baseUrlString = "https://u-thinkcrazy.com";
        String relativeUriString  = "/signup";

        URL baseUrl = new URL(baseUrlString);
        URI relativeUri =  new URI(relativeUriString);

        URI resolveUri = baseUrl.toURI().resolve(relativeUri);
        String resolvedUriString =  resolveUri.toString();

        System.out.println("Resolved URI: "+ resolvedUriString);

    }
}
