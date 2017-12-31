package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String getUser(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        return "user";
    }
}
