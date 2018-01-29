package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dao.api.UserDao;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        userDTO.setPasswordHash(passwordEncoder.encode(userDTO.getPasswordHash()));
        return userDao.addNewUser(userDTO);
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return userDao.updateUser(userDTO);
    }

    @Override
    public ResultInfo<User> changePassword(String password, String passwordConfirm, String username) {
        if (password.equals(passwordConfirm)){
            userDao.changePassword(passwordEncoder.encode(password), username);
            return new ResultInfo<>(userDao.getUserByUsername(username), "Password successfully changed", ResultInfo.Status.SUCCESS);
        }
        return new ResultInfo<>(userDao.getUserByUsername(username), "Failed to change the password, because passwords were not same.", ResultInfo.Status.ERROR);
    }
}
