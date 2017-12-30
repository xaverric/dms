package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.repository.dao.api.RoleDao;
import cz.uhk.fim.repository.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    
    @Override
    public Role addRole(String name, String description, Long parentId) {
        return roleDao.addRole(name, description, parentId);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Role updateRoleDescription(Long id, String description) {
        return roleDao.updateRoleDescription(id, description);
    }

    @Override
    public Role updateRoleName(Long id, String name) {
        return roleDao.updateRoleName(id, name);
    }

    @Override
    public Role updateRoleParentId(Long id, Long parentId) {
        return roleDao.updateRoleParentId(id, parentId);
    }
}
