package collects;

public class Test1 {

    public static void main(String[] args) {
        // 二进制：0100
        int i = 4;
        int n = 0;
        // 无符号右移
        // 0010
        n = i >>> 1;
        System.out.println(n); // 2
        //   | 	如果相对应位都是 0，则结果为 0，否则为 1
        // 该表达式表示： n = n | 1
        n |= 1;
        // 0010
        // 0001
        // 0011
        System.out.println(n);
    }
}
