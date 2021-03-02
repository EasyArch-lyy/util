package annotation;

import java.lang.annotation.*;
/**
 * 使用自定义注解修饰方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Testable{

}


public class MyTest {

    @Testable
    public void info(){
        System.out.println("info方法...");
    }
}
