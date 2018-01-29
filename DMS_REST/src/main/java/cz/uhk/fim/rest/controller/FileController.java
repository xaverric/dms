package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.entity.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/files")
    public ModelAndView getFiles(){
        ModelAndView modelAndView = new ModelAndView("files");
        modelAndView.addObject("filesMetadata", fileService.findAllFiles());
        return modelAndView;
    }

    @GetMapping("/file/{id}")
    public ModelAndView getFile(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("file");
        modelAndView.addObject("file", fileService.getFileByID(Long.parseLong(id)));
        modelAndView.addObject("notes", noteService.getNotesForFile(Long.parseLong(id)));
        return modelAndView;
    }
}
