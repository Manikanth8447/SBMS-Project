package com.mani.service;

import com.mani.entity.Role;

import java.util.List;

public interface RoleService {
   
	String createRole(Role role);

    List<Role> getAllRoles();
}
