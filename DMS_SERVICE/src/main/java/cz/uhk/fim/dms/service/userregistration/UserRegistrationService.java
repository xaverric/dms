package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.api.UserDTO;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserRegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public ModelAndView registerUser(UserDTO userDTO, String passwordConfirmation, LinkedHashMap<String, String> seznamFieldu){
        ModelAndView model = new ModelAndView("/home");
        if(!checkFields(seznamFieldu, model)){
            return model;
        }
        //model = new ModelAndView("/home");
        if (!isPasswordConfirmed(userDTO.getPasswordHash(), passwordConfirmation)){          
            model.addObject("registration_error", "Passwords mismatch");
            return model;
        }
        if (!userExists(userDTO)){
            userService.addNewUser(userDTO);
        } else {
            model.addObject("registration_error", String.format("User '%s' already exist", userDTO.getUsername()));
            model.addObject("username", "");
            return model;
        }
        return new ModelAndView("/login");
    }

    private boolean userExists(UserDTO userDTO){
        return userService.getUserByUsername(userDTO.getUsername()) != null;
    }

    private boolean isPasswordConfirmed(String password, String passwordConfirmation){
        return password.equals(passwordConfirmation);
    }
    
    private boolean checkFields(LinkedHashMap<String, String> seznamFieldu, ModelAndView model){
        boolean retVal = true;
        StringBuilder errorMessage = new StringBuilder();
        for (Map.Entry<String, String> entry : seznamFieldu.entrySet()) {
            String parametr = entry.getValue();
            String jmeno = entry.getKey();
            if (parametr.isEmpty()) {
                retVal = false;
                errorMessage.append(jmeno);
                errorMessage.append(", ");
            } else {
                model.addObject(jmeno.replace(" ", "").replace("-", "").toLowerCase(), parametr);
            }
        }
        if (!retVal) {
            errorMessage.setLength(errorMessage.length() - 2);
            errorMessage.append(errorMessage.toString().contains(",") ? " are" : " is");
            errorMessage.append(" empty!");
            model.addObject("registration_error", errorMessage.toString());
        }
        return retVal;
    }

}
