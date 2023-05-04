// /1.write a program to download a webpage using URLConnection.
package lab5;

import java.io.*;
import java.net.*;
import java.net.URLConnection;


public class Q1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection =  url.openConnection();
            InputStream input = connection.getInputStream();
            FileOutputStream output = new FileOutputStream("home.html");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            input.close();
            output.close();
            System.out.println("webpage downloaded sucessfully.");
        } catch (IOException e) {
            System.out.println("Error downloading webpage:" + e.getMessage());
        }
    }
}