package aop.xml.service.impl;

import aop.xml.service.RoleService;
import aoptest.game.pojo.Role;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.print("id = " + role.getId()+",");
		System.out.print("role_name = " + role.getRoleName()+",");
		System.out.println("note = " + role.getNote());
	}

}
