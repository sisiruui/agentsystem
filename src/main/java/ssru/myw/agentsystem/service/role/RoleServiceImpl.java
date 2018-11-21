package ssru.myw.agentsystem.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssru.myw.agentsystem.dao.RoleMapper;
import ssru.myw.agentsystem.entity.Role;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> listRole(Role role) {
        return roleMapper.listRole(role);
    }
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    @Override
    public int saveRole(Role role) {
        return roleMapper.saveRole(role);
    }

    @Override
    public int deleteRole(Role role) {
        return roleMapper.deleteRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }
}
