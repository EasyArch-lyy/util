package aoptest.verifier.impl;

import aoptest.game.pojo.Role;
import aoptest.verifier.RoleVerifier;

public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public boolean verify(Role role) {
        System.out.println("引入检测角色是否为空");
        return role != null;
    }
}
