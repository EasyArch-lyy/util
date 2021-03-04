package passive.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import passive.pojo.JuiceMaker2;

public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        ctx.close();
    }
}
