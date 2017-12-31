package cz.uhk.fim.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
}
