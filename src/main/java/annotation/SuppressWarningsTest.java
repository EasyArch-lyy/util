package annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 关闭整个类中的编译器警告
 */
@SuppressWarnings(value = "unchecked")
public class SuppressWarningsTest {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
    }
}
