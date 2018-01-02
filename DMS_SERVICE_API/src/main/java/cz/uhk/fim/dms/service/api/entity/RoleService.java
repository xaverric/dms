package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.Role;
import java.util.List;

public interface RoleService {
    
    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();

    Role addRole(String name, String description, Long parentId);

    Role updateRoleName(Long id, String name);

    Role updateRoleDescription(Long id, String description);

    Role updateRoleParentId(Long id, Long parentId);
}
