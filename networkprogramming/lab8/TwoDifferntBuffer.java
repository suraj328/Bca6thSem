package lab8;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TwoDifferntBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        buffer.put((byte) 4);

        System.out.println("filled buffer: " + buffer);

        // drain the byffer
        while (buffer.hasRemaining()) {
            byte value = buffer.get();
            System.out.println("Drained value: " + buffer);
            ByteBuffer originaBuffer = ByteBuffer.allocate(10);
            buffer.put((byte) 1);
            originaBuffer.put((byte) 2);
            originaBuffer.put((byte) 3);
            originaBuffer.put((byte) 4);
            // DUplicate the buffer
            ByteBuffer duplicateBuffer = originaBuffer.duplicate();
            System.out.println("Original buffer: " + originaBuffer);
            System.out.println("Duplicate buffer: " + duplicateBuffer);

            //slice the buffer
            duplicateBuffer.position(2);
            duplicateBuffer.limit(4);
            ByteBuffer slicedBuffer = duplicateBuffer.slice();
            System.out.println("sliced buffer: "+slicedBuffer);
            // compact the buffer
            slicedBuffer.compact();
            System.out.println("compacted buffer: "+slicedBuffer);
        }
    }
}
