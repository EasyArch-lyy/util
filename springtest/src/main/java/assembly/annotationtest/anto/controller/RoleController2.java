package assembly.annotationtest.anto.controller;

import assembly.annotationtest.anto.service.RoleService2;
import org.springframework.stereotype.Component;

@Component
public class RoleController2 {

    private RoleService2 roleService2 = null;

    public RoleController2(RoleService2 roleService2) {
        this.roleService2 = roleService2;
    }
}
