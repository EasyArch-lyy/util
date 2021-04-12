package assembly.annotationtest.service.impl;

import assembly.annotationtest.pojo.Role;
import assembly.annotationtest.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRoleInfo(Role role) {
        System.out.println("id="+role.getId());
        System.out.println("roleName="+role.getRoleName());
        System.out.println("note="+role.getNote());
    }
}
