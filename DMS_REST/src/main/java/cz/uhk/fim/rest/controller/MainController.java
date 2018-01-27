package cz.uhk.fim.rest.controller;

import cz.uhk.fim.api.rest.controller.Router;
import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController implements Router {

    @Autowired
    private SecurityService userLoginService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @Override
    public ModelAndView getHomeScreen(@RequestParam(value = "logout", required = false) String param){
        if(param != null && !param.isEmpty()){
            userLoginService.logoutUser();
        }
        String username = userLoginService.findLoggedInUsername();
        if(username != null && !username.isEmpty()){
            return new ModelAndView("/user");
        }else {
            return new ModelAndView("/home");
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
