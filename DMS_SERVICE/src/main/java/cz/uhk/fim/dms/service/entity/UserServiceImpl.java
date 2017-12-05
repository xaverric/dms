package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dao.api.UserDao;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userDao.getUsersByRole(role);
    }

    @Override
    public User addNewUser(UserDTO userDTO) {
        return userDao.addNewUser(userDTO);
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return userDao.updateUser(userDTO);
    }
}
