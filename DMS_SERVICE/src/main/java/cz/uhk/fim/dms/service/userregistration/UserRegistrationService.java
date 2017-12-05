package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.api.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserService userService;

    public void registerUser(UserDTO userDTO, String passwordConfirmation){
        if (!isPasswordConfirmed(userDTO.getPasswordHash(), passwordConfirmation)){
            //TODO vrátit result o chybném hesli
        }
        if (!userExists(userDTO)){
            userService.addNewUser(userDTO);
        } else {
            //TODO vrátit result o již existujícím useru se stejným jménem
        }
    }

    private boolean userExists(UserDTO userDTO){
        return userService.getUserByUsername(userDTO.getUsername()) != null;
    }

    private boolean isPasswordConfirmed(String password, String passwordConfirmation){
        return password.equals(passwordConfirmation);
    }
}
