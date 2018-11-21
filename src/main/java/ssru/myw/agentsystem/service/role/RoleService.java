package ssru.myw.agentsystem.service.role;

import ssru.myw.agentsystem.entity.Role;

import java.util.List;

public interface RoleService {


    List<Role> listRole(Role role);

    int saveRole(Role role);

    int deleteRole(Role role);

    int updateRole(Role role);
}
