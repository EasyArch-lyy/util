package annotation;
/**
 * @Deprecated 标记过时的方法或类，在调用时方法和类上划过时横线
 */
@Deprecated
class Apple{
    @Deprecated
    public void info(){
        System.out.println("aaaa");
    }

    @Deprecated
    private String str;
}

public class DeprecatedTest {
    public static void main(String[] args) {
        new Apple().info();
    }
}
