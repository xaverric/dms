package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.RoleDao;
import cz.uhk.fim.repository.entity.Role;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDaoImpl extends AbstractGenericDAO<Role> implements RoleDao {

    @Override
    public Role addRole(String name, String description, Long parentId) {
        if(parentId == 0 || parentId == null){
            parentId = getMaxId();
        }
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setParentId(parentId);
        getEntityManager().persist(role);
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return getEntityManager().createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return getRole(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return getRole(name);
    }

    @Override
    public Role updateRoleDescription(Long id, String description) {
        return updateRole(id, description, false);
    }

    @Override
    public Role updateRoleName(Long id, String name) {
        return updateRole(id, name, true);
    }

    @Override
    public Role updateRoleParentId(Long id, Long parentId) {
        return updateRole(id, parentId);
    }

    private Role getRole(Object value) {
        Query sql = null;
        if (value instanceof Long) {
            sql = getEntityManager().createQuery("from role where id=:id", Role.class);
            sql.setParameter("id", value);
        } else if (value instanceof String) {
            sql = getEntityManager().createQuery("from role where name=:name", Role.class);
            sql.setParameter("name", value);
        }
        Role role = getSingleResult(sql);
        return role;
    }

    private Role updateRole(Long id, Long parentId) {
        return updateRole(id, parentId, false);
    }

    private Role updateRole(Long id, Object value, boolean name) {
        Role role = getEntityManager().find(Role.class, id);
        if (role != null) {
            role = new Role();
            if (value instanceof Long) {
                Long tmpValue = (Long) value;
                role.setParentId(tmpValue);
            } else if (value instanceof String) {
                String tmpValue = (String) value;
                if (name) {
                    role.setName(tmpValue);
                } else {
                    role.setDescription(tmpValue);
                }
            }
            getEntityManager().merge(role);
        }
        return role;
    }
    
    private Long getMaxId(){
        Long retVal = new Long(0);
        int tmp = getEntityManager().createQuery("from Role").getResultList().size();
        retVal = Long.valueOf(tmp);
        return retVal;
    }
}
