package aoptest.game.service.impl;

import aoptest.game.pojo.Role;
import aoptest.game.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Override
	public void printRole(Role role) {
		System.out.println(
				"{id =" + role.getId() + ", roleName=" + role.getRoleName() + ", note=" + role.getNote() + "}");
	}
}