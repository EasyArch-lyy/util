package assembly.xmltest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {
    }

    
    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        
    }
}
