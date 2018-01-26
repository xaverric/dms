package cz.uhk.fim.rest.controller;

import cz.uhk.fim.api.rest.controller.Router;
import cz.uhk.fim.dms.service.userlogin.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController implements Router {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @Override
    public String getHomeScreen(){
        //TODO pokud user details service ze spring security vratí usera nebude se vracet index ale jeho domovská stránka
        //userLoginService.findLoggedInUsername()
        String username = userLoginService.findLoggedInUsername();
        if(username != null && !username.isEmpty()){
            return "user";
        }else{
        return "home";
    }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @Override
    public String getLoginScreen(){
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @Override
    public String getUserScreen() {
        return "user";
    }

    @Override
    public String getMainScreen() {
        return null;
    }
}
