package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    User getUserByUsername(String username);

    List<User> getUsersByName(String name);

    List<User> getUsersByRole(Role role);

    User addNewUser(UserDTO userDTO);

    User updateUser(UserDTO userDTO);
}
