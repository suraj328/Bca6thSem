package lab5;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;

public class GuessMimeTYpe {

    public static void main(String[] args) throws IOException {
        // Create a File object for the file whose MIME media type you want to guess.
        File file = new File("/path/to/file.txt");

        // Create a URLConnection object for the file.
        URLConnection connection = file.toURL().openConnection();

        // Get the MIME media type of the file.
        String mimeType = connection.getContentType();

        // Print the MIME media type to the console.
        System.out.println(mimeType);
    }
}
