package ssru.myw.agentsystem.dao;

import ssru.myw.agentsystem.entity.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> listRole(Role role);

    int saveRole(Role role);

    int deleteRole(Role role);

    int updateRole(Role role);
}
