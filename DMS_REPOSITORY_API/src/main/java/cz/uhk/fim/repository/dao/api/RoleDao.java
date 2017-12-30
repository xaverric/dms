package cz.uhk.fim.repository.dao.api;

import cz.uhk.fim.repository.entity.Role;
import java.util.List;

public interface RoleDao {
    
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    
    List<Role> getAllRoles();
    
    Role addRole(String name, String description, Long parentId);
    
    Role updateRoleName(Long id, String name);
    Role updateRoleDescription(Long id, String description);
    Role updateRoleParentId(Long id, Long parentId);
}
