package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/files")
    public ModelAndView getFiles(){
        ModelAndView modelAndView = new ModelAndView("files");
        modelAndView.addObject("filesMetadata", fileService.findAllFiles());
        return modelAndView;
    }
}
