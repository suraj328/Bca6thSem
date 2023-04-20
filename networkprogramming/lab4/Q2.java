package lab4;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
// import java.util.*;

//wap to implement cookie handler
public class Q2 {
    public static void main(String[] args) {
        try {
            CookieManager cookies = new CookieManager();
            CookieHandler.setDefault(cookies);

            URL url = new URL("http://www.oracle.com");

            HttpURLConnection connection =  (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            Map<String,List<String>> headerFields =  connection.getHeaderFields();
            List<String> cookiesHeader = headerFields.get("Set-Cookie");
            if(cookiesHeader!=null)
            {
                for(String cookie : cookiesHeader){
                    cookies.getCookieStore().add(null,HttpCookie.parse(cookie).get(0));
                }

            }
            System.out.println("Cookies: +"+cookies.getCookieStore().getCookies());
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
}
