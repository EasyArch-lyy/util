package gc;

import java.io.IOException;

public class GcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            GcTest gcTest = new GcTest();
            System.gc();
            Runtime.getRuntime().runFinalization();
        }
        Runtime.getRuntime().gc();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finalize(){
        System.out.println("full gc running");
    }
}
