package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserLoginController {

    @Autowired
    private SecurityService userLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws IOException {
        userLoginService.autoLogin(username, password);
        String usr = userLoginService.findLoggedInUsername();
        if (usr.equals(username)) {
            return new ModelAndView(new RedirectView("/user"));
        }
        return new ModelAndView("/wrong-username-or-password");
    }
}
