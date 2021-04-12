package aoptest.service.impl;

import aoptest.game.pojo.Role;
import aoptest.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println("{id: " + role.getId() + ","
                + "role_name: " + role.getRoleName() + ","
                + "note: " + role.getNote() + "}");
    }

    @Override
    public void printRole(Role role, int sort) {
        System.out.println("{id: " + role.getId() + ","
                + "role_name:" + role.getRoleName() + ","
                + "note:" + role.getNote() + "}");
        System.out.println(sort);
    }
}
