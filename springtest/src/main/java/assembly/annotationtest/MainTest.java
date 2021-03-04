package assembly.annotationtest;

import assembly.annotationtest.pojo.PojoConfig;
import injection.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = applicationContext.getBean(Role.class);
        System.out.println(role.getId());
    }
}
