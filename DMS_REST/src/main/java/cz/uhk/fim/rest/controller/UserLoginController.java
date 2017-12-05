package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.userlogin.UserLoginService;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws IOException {
        User loggedUser = userLoginService.loginUser(username, password);
        if (loggedUser != null){
            response.sendRedirect("/user/" + username);
        } else {
            response.sendRedirect("/wrong-username-or-password");
        }
    }
}
