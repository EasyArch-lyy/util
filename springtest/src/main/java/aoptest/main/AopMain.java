package aoptest.main;

import aoptest.config.AopConfig;
import aoptest.game.pojo.Role;
import aoptest.verifier.RoleVerifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aoptest.service.RoleService;

public class AopMain {
    public static void main(String[] args) {

//        testXML();
//        testAnnotation();
        testIntroduction();
    }

    private static void testAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRole(role);
    }

    private static void testXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cfg3.xml");
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRole(role);
    }

    private static void testAopParams() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cfg3.xml");
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRole(role, 1);
    }

    private static void testIntroduction() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        if (roleVerifier.verify(role)) {
            roleService.printRole(role);
        }
    }


}
