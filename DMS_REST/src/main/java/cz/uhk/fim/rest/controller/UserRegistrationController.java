package cz.uhk.fim.rest.controller;


import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.dms.service.userregistration.UserRegistrationService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.types.api.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String username, @RequestParam String password,
            @RequestParam String passwordConfirm, @RequestParam String email, HttpServletResponse response) throws IOException {
        String[] seznamParametru = new String[]{firstName, lastName, username, password, passwordConfirm, email};
        String[] jmenaParametru = new String[]{"First name", "Last name", "Username", "Password", "Password confirm", "E-mail"};
        LinkedHashMap<String, String> seznamFieldu = new LinkedHashMap<>(seznamParametru.length);
        for (int i = 0; i < seznamParametru.length; i++) {
            seznamFieldu.put(jmenaParametru[i], seznamParametru[i]);
        }

        
        UserDTO userDTO = new UserDTOImpl(username, password, firstName, lastName, email, Arrays.asList(roleService.getRoleByName(RoleType.USER.getName())));
        return userRegistrationService.registerUser(userDTO, passwordConfirm, seznamFieldu);
    }
}
