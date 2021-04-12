package assembly.annotationtest.anto.service.impl;

import assembly.annotationtest.pojo.Role;
import assembly.annotationtest.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary 存在多个实现类是优先注入
 */
@Component("roleService3")
@Primary
public class RoleServiceImpl3 implements RoleService {


    @Override
    public void printRoleInfo(Role role) {
        System.out.println("id=" + role.getId());
        System.out.println("roleName=" + role.getRoleName());
        System.out.println("note=" + role.getNote());
    }
}
