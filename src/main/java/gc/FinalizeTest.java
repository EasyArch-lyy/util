package gc;

import java.io.IOException;
/**
 * finalize()方法用于重新将待回收的对象连接到root上
 */
public class FinalizeTest {
    public FinalizeTest(){

    }

    private static FinalizeTest ft = null;

    public void info(){
        System.out.println("xxxxx");
    }

    public static void main(String[] args) throws IOException {
        FinalizeTest t = new FinalizeTest();
        t = null;
        // 通知虚拟机进行一次垃圾回收，回收时机取决于虚拟机
        System.gc();

        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        System.runFinalization();
        System.in.read();
        ft.info();
    }

    public void finalize(){
        System.out.println("ok");
        ft = new FinalizeTest();
    }
}
