package com.jinxiu.springmvc.dao;

import com.jinxiu.springmvc.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

    public Role getRole(Long id);
}
