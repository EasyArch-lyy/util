package assembly.annotationtest;

import assembly.annotationtest.anto.controller.RoleController;
import assembly.annotationtest.anto.service.RoleService2;
import assembly.annotationtest.config.ApplicationConfig;
import assembly.annotationtest.pojo.PojoConfig;
import assembly.annotationtest.pojo.Role;
import assembly.annotationtest.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class AnnotationMain {

    public static void main(String[] args) {
        test6();
    }

    public static void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = applicationContext.getBean(Role.class);
        System.out.println(role.getId());
    }

    public static void test2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role = applicationContext.getBean(Role.class);
        RoleService roleService = applicationContext.getBean(RoleService.class);
        roleService.printRoleInfo(role);
        applicationContext.close();
    }

    public static void test3() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleService2 roleService2 = ctx.getBean(RoleService2.class);
        roleService2.printRoleInfo();
        ctx.close();
    }

    public static void test4() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleController controller = ctx.getBean(RoleController.class);
        Role role = ctx.getBean(Role.class);
        controller.printRoleInfo(role);
        ctx.close();
    }

    public static void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleController controller = context.getBean(RoleController.class);
        Role role = context.getBean(Role.class);
        controller.printRoleInfo(role);
    }

    public static void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection().getMetaData().getDatabaseProductName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
