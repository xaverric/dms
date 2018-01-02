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
        Long tmpParentId = parentId;
        if(tmpParentId == 0 || tmpParentId == null){
            tmpParentId = getMaxId();
        }
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setParentId(tmpParentId);
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
        Role role = getRole(id);
        if (role != null) {
            role.setDescription(description);
        }
        return role;
    }

    @Override
    public Role updateRoleName(Long id, String name) {
        Role role = getRole(id);
        if(role!= null){
            role.setName(name);
        }
        return role;
    }

    @Override
    public Role updateRoleParentId(Long id, Long parentId) {
        Role role = getRole(id);
        if(role != null){
            role.setParentId(parentId);
        }
        return role;
    }

    private Role getRole(Object value) {
        if (value instanceof Long) {
            return getEntityManager().find(Role.class, value);
        } else if (value instanceof String) {
            Query sql = getEntityManager().createQuery("from Role where name=:name", Role.class);
            sql.setParameter("name", value);
            return getSingleResult(sql);
        }
        return null;
    }

    private Long getMaxId(){
        int tmp = getEntityManager().createQuery("from Role").getResultList().size();
        Long retVal = Long.valueOf(tmp);
        return retVal;
    }
}
