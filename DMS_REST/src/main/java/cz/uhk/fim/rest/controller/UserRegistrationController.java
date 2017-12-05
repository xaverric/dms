package cz.uhk.fim.rest.controller;


import cz.uhk.fim.dms.service.userlogin.UserLoginService;
import cz.uhk.fim.dms.service.userregistration.UserRegistrationService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.dto.api.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registerUser(@RequestParam String firstName, @RequestParam String lastName,
                             @RequestParam String username, @RequestParam String password,
                             @RequestParam String passwordConfirm, @RequestParam String email, HttpServletResponse response) throws IOException {
        UserDTO userDTO = new UserDTOImpl(username, password, firstName, lastName, email);
        userRegistrationService.registerUser(userDTO, passwordConfirm);
        response.sendRedirect("/success-login");
    }
}
