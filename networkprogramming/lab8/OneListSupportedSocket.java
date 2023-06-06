package lab8;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketOption;
import java.nio.channels.NetworkChannel;
import java.nio.channels.*;

//Wap to list all supported socket options for the differnt types of network channels
public class OneListSupportedSocket {
    public static void main(String[] args) throws IOException {
        printOptions(SocketChannel.open());
        printOptions(ServerSocketChannel.open());
        printOptions(AsynchronousSocketChannel.open());
        printOptions(AsynchronousServerSocketChannel.open());
        printOptions(DatagramChannel.open());
    }

    private  static void printOptions(NetworkChannel channel)throws IOException {
        System.out.println(channel.getClass().getSimpleName()+"supports:");
        for(SocketOption<?> option : channel.supportedOptions()){
            System.out.println();
            channel.close();
        }
    }
}