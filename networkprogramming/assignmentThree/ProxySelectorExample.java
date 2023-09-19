import java.io.*;
import java.net.*;
import java.util.*;

public class ProxySelectorExample extends ProxySelector {
    private List<URI> failed = new ArrayList<URI>();

    public List<Proxy> select(URI uri) {
        List<Proxy> result = new ArrayList<Proxy>();
        if (failed.contains(uri) || !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    proxyAddress);
            result.add(proxy);
        }
        return result;
    }

    public void connectFailed(URI uri, SocketAddress address, IOException ex) {
        // System.setProperty("http.proxyHost", "127.0.0.1");
        // System.setProperty("http.proxyPort", "8080");
        failed.add(uri);
    }
    public static void main(String[] args) {
        ProxySelectorExample  proxySelectorExample = new ProxySelectorExample();
    }
}
// | http.proxyHost | The hostname or IP address of the HTTP proxy server. |
// | http.proxyPort | The port number of the HTTP proxy server. |
// | https.proxyHost | The hostname or IP address of the HTTPS proxy server. |
// | https.proxyPort | The port number of the HTTPS proxy server. |
// | ftp.proxyHost | The hostname or IP address of the FTP proxy server. |
// | ftp.proxyPort | The port number of the FTP proxy server. |
// | socksProxyHost | The hostname or IP address of the SOCKS proxy server. |
// | socksProxyPort | The port number of the SOCKS proxy server. |