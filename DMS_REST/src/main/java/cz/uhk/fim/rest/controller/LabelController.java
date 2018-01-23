package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LabelController {
    
    @Autowired
    private LabelService labelService;
    
    @PostMapping(value = "/createLabel/{name}")
    public String createLabel(@PathVariable("name") String name){
        return labelService.addNewLabel(name).toString();
    }
    
    @GetMapping(value = "/showLabels")
    public String getAllLabels(){
        return labelService.getAllLabels().toString();
    }
}

