// wpa to print entire headers
package lab5;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.u-thinkcrazy.com");
            URLConnection connection =  url.openConnection();
            // Get Header files
            Map<String,List<String>> headers = connection.getHeaderFields();
            // print the header files
            for(Map.Entry<String,List<String>> entry: headers.entrySet()){
                String key = entry.getKey();
                List<String> values =  entry.getValue();
                for(String value :values){
                    System.out.println(key+":"+value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
