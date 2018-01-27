package cz.uhk.fim.api.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface Router {

    /**
     *
     * @return index ThymeLeaf template
     */
    //ModelAndView getHomeScreen();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView getHomeScreen(@RequestParam(value = "logout", required = false) String param);

    /**
     *
     * @return
     */
    String getLoginScreen();

    String getUserScreen();

    String getMainScreen();
}
