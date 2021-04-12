package aoptest.service;

import aoptest.game.pojo.Role;

public interface RoleService {
	
	public void printRole(Role role);
	
	public void printRole(Role role, int sort);
}
