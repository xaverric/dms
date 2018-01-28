package cz.uhk.fim.rest.controller;

import cz.uhk.fim.api.rest.controller.Router;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.dms.service.userlogin.UserLoginServiceImpl;
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
        if (userLoginService.findLoggedInUsername() != null){
            return new ModelAndView("files");
        }
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
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userService.getUserByUsername(userLoginService.findLoggedInUsername()));
        return modelAndView;
    }
}
