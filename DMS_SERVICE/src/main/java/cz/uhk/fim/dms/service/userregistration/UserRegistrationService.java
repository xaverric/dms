package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserService userService;

    public ResultInfo<User> registerUser(UserDTO userDTO, String passwordConfirmation){
        if (userExists(userDTO)){
            return new ResultInfo<>(userService.getUserByUsername(userDTO.getUsername()), "User already exists", ResultInfo.Status.ERROR);
        }
        if (isPasswordConfirmed(userDTO.getPasswordHash(), passwordConfirmation)){
            User user = userService.addNewUser(userDTO);
            return new ResultInfo<>(user, "User created", ResultInfo.Status.SUCCESS);
        }
        return new ResultInfo<>(userService.getUserByUsername(userDTO.getUsername()), "Incorrect password", ResultInfo.Status.ERROR);
    }

    private boolean userExists(UserDTO userDTO){
        return userService.getUserByUsername(userDTO.getUsername()) != null;
    }

    private boolean isPasswordConfirmed(String password, String passwordConfirmation){
        return password.equals(passwordConfirmation);
    }
}
