package assembly.annotationtest.anto.controller;

import assembly.annotationtest.pojo.Role;
import assembly.annotationtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Qualifier 解决Spring 加载bean的歧义性
 */
@Component
public class RoleController {

    @Autowired
    @Qualifier("roleService3")
    private RoleService roleService;

    public void printRoleInfo(Role role) {
        roleService.printRoleInfo(role);
    }
}
