import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogFile {
    public static void main(String[] args) {
        // Read the log file and process entries
        try (BufferedReader br = new BufferedReader(new FileReader("Weblog.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLogEntry(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processLogEntry(String logEntry) {
        // Split the log entry into components
        String[] parts = logEntry.split(" ");
        String ipAddress = parts[0];
        String dateTime = parts[3] + " " + parts[4];
        String requestMethod = parts[5];
        String requestURL = parts[6];
        int responseCode = Integer.parseInt(parts[8]);

        // Process or analyze the extracted data (e.g., print it)
        System.out.println("IP: " + ipAddress);
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Method: " + requestMethod);
        System.out.println("URL: " + requestURL);
        System.out.println("Response Code: " + responseCode);
        System.out.println();
    }
}
