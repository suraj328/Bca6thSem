package lab8;

import javax.net.ssl.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStore;

public class SecureClient {
    public static void main(String[] args) {
        String serverHostname = "example.com"; // Replace with the server's hostname
        int serverPort = 443; // The secure port (typically 443 for HTTPS)

        try {
            // Load the keystore with your SSL/TLS client certificates and private key
            char[] keystorePassword = "your_keystore_password".toCharArray();
            KeyStore keystore = KeyStore.getInstance("JKS"); // Use "PKCS12" for PKCS12 keystores
            keystore.load(new FileInputStream("your_client_keystore.jks"), keystorePassword);

            // Create and initialize an SSLContext with the keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keystore, keystorePassword);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create a secure socket
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverHostname, serverPort);

            // Optionally, enable hostname verification
            // sslSocket.setHostnameVerifier(new StrictHostnameVerifier());

            // Connect to the server
            sslSocket.startHandshake();
            
            // Send data securely (e.g., HTTP request)
            OutputStream outputStream = sslSocket.getOutputStream();
            String requestData = "GET / HTTP/1.1\r\nHost: " + serverHostname + "\r\n\r\n";
            outputStream.write(requestData.getBytes());
            outputStream.flush();

            // Receive and process data from the server
            // You can use sslSocket's input stream for reading server responses

            // Close the SSL/TLS connection
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
