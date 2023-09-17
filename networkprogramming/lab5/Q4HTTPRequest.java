package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

public class Q4HTTPRequest {
    public static void main(String[] args)  throws Exception {
        URL url = new URL("http://fakestoreapi.com/products");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("response code: "+ responseCode);
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine())!= null){
            response.append(inputLine);
        }
        System.out.println(response.toString());
        in.close();
    }
}
