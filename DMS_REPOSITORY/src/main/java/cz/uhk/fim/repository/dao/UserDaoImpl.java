package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.UserDao;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl extends AbstractGenericDAO<User> implements UserDao {

    @Override
    public User getUserById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = getEntityManager().createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        return getSingleResult(query);
    }

    @Override
    public List<User> getUsersByName(String name) {
        Query query = getEntityManager().createQuery("from User where first_name = :first_name", User.class);
        query.setParameter("first_name", name);
        return query.getResultList();
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        Query query = getEntityManager().createQuery("select u from User u join Role r where r.id = :roleId", User.class);
        query.setParameter("roleId", role.getId());
        return query.getResultList();
    }

    @Override
    public User addNewUser(UserDTO userDTO) {
        User user = new User();
        setUserValues(user, userDTO);
        getEntityManager().merge(user);
        return user;
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        User user = getUserByUsername(userDTO.getUsername());
        setUserValues(user, userDTO);
        getEntityManager().merge(user);
        return user;
    }

    @Override
    public User changePassword(String password, String username) {
        User user = getUserByUsername(username);
        user.setPasswordHash(password);
        getEntityManager().merge(user);
        return user;
    }

    private void setUserValues(User user, UserDTO userDTO){
        user.setUsername(userDTO.getUsername());
        if (userDTO.getPasswordHash() != null && !userDTO.getPasswordHash().isEmpty()){
            user.setPasswordHash(userDTO.getPasswordHash());
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        if (userDTO.getPhoneNumber() != null && !userDTO.getPhoneNumber().isEmpty()){
            user.setPhoneNumber(Long.parseLong(userDTO.getPhoneNumber()));
        }
        user.setBorn(userDTO.getBirthDate());
    }
}
