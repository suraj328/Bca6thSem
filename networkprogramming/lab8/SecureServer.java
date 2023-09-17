package lab8;

import javax.net.ssl.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;

public class SecureServer {
    public static void main(String[] args) {
        int port = 443; // The secure port (typically 443 for HTTPS)

        try {
            // Load the keystore with your SSL/TLS certificates and private key
            char[] keystorePassword = "your_keystore_password".toCharArray();
            KeyStore keystore = KeyStore.getInstance("JKS"); // Use "PKCS12" for PKCS12 keystores
            keystore.load(new FileInputStream("your_keystore_file.jks"), keystorePassword);

            // Create and initialize an SSLContext with the keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keystore, keystorePassword);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create a secure ServerSocket
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            // Configure additional settings if needed, e.g., client authentication

            System.out.println("Secure server is listening on port " + port);

            while (true) {
                // Accept incoming SSL/TLS connections
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                sslSocket.setEnableSessionCreation(true);
                String[] supported = sslSocket.getSupportedCipherSuites();
                sslSocket.setEnabledCipherSuites(supported);
                // session
                SSLSession sslSession = sslSocket.getSession();
                System.out.println("Session ID: " + sslSession.getId());
                System.out.println("Session Creation Time: " + sslSession.getCreationTime());
                System.out.println("Session Last Accessed Time: " + sslSession.getLastAccessedTime());
                // Handle SSL/TLS communication on sslSocket
                // You can read from and write to sslSocket's input and output streams securely

                // Close the SSL/TLS connection
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
