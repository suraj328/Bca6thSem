package nonblocking;

import java.nio.ByteBuffer;

public class BufferObjectMethod {
    public static void main(String[] main) {
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        // Write the same data to both buffers.
        buffer1.put("Hello, world!".getBytes());
        buffer2.put("Hello, world!".getBytes());
        buffer1.flip();
        System.out.println(new byte[buffer1.remaining()]);

        // Compare the two buffers for equality.
        boolean isEqual = buffer1.equals(buffer2);

        // Print the result to the console.
        System.out.println(isEqual); // true

        // Get the hash code of the first buffer.
        int hashCode = buffer1.hashCode();

        // Print the hash code to the console.
        System.out.println(hashCode); // 1234567890

        // Get a string representation of the second buffer.
        String stringRepresentation = buffer2.toString();

        // Print the string representation to the console.
        System.out.println(stringRepresentation); // position=0, limit=12, capacity=1024

    }
}
