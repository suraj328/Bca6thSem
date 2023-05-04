// Java Program to illustrate Proxy Class
// of java.net package
// importing java net package to use address and url fields
import java.net.*;
// importing the java proxy package
import java.net.Proxy;


public class ProxyClassRxample {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating socket address with port 8080
		// by creating object of SocketAddress class
		SocketAddress addr = new InetSocketAddress(
			"www.facebook.com", 443);

		// Creating proxy object of type HTTP with
		// address addr using the class constructor
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

		// Try block to check for exceptions
		

		// Printing Proxy Type
		// using type() method
		System.out.println("Proxy Type: " + proxy.type());

		// Printing Proxy Address
		// using address() method
		System.out.println("Proxy Address: "
						+ proxy.address());

		// Printing Proxy Hashcode
		// using hashCode() method
		System.out.println("Proxy HasHCode: "
						+ proxy.hashCode());

		// Printing Proxy String representation
		// using toString() method
		System.out.println("Proxy String: "
						+ proxy.toString());
	}
}
