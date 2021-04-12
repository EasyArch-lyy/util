package assembly.annotationtest.anto.service.impl;

import assembly.annotationtest.anto.service.RoleService2;
import assembly.annotationtest.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roleService2")
public class RoleService2Impl2 implements RoleService2 {

    @Autowired
    private Role role = null;

    public Role getRole() {
        return role;
    }

    @Autowired
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void printRoleInfo() {
        System.out.println("id=" + role.getId());
        System.out.println("roleName=" + role.getRoleName());
        System.out.println("note=" + role.getNote());
    }
}
