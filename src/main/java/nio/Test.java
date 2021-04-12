package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

    public static void main(String[] args) {
        method2();
    }

    public static void method1() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src/test.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void method2() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("src/test.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int byteRead = fileChannel.read(buf);
            System.out.println(byteRead);
            while (byteRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.compact();
                byteRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (aFile != null) {
                try {
                    aFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
