package lab5;

import java.net.URL;
import java.net.MalformedURLException;

public class ProtectedBooleanUrl {
    // List of allowed URLs
    private static final String[] allowedURLs = {
        "https://example.com/page1",
        "https://example.com/page2"
    };

    // Check if a URL is allowed
    private static boolean isURLAllowed(String url) {
        for (String allowedURL : allowedURLs) {
            if (url.equals(allowedURL)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            // Creating a URL object
            URL url = new URL("https://example.com/page1");

            // Check if the URL is allowed
            if (isURLAllowed(url.toString())) {
                System.out.println("Access allowed to URL: " + url.toString());
            } else {
                System.out.println("Access denied to URL: " + url.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

