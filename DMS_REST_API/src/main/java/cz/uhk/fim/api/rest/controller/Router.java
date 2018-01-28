package cz.uhk.fim.api.rest.controller;

import org.springframework.web.servlet.ModelAndView;

public interface Router {

    /**
     *
     * @return index ThymeLeaf template
     */
    ModelAndView getHomeScreen();

    /**
     *
     * @return
     */
    ModelAndView getLoginScreen();

    ModelAndView getUserScreen();
}
