package cz.uhk.fim.rest.controller;

import cz.uhk.fim.api.rest.controller.Router;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.dms.service.userlogin.UserLoginServiceImpl;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController implements Router {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/home")
    @Override
    public ModelAndView getHomeScreen(){
        return new ModelAndView("home");
    }

    @GetMapping(value = "/login")
    @Override
    public ModelAndView getLoginScreen(){
        return new ModelAndView("login");
    }

    @GetMapping(value = "/user")
    @Override
    public ModelAndView getUserScreen() {
        User user = userService.getUserByUsername(userLoginService.findLoggedInUsername());
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        if (user.getBorn() != null){
            modelAndView.addObject("birthDate", user.getBorn());
        }
        return modelAndView;
    }
}
