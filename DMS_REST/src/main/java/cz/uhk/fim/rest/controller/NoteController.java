package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.entity.NoteService;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.dms.service.userlogin.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @Autowired
    private FileService fileService;

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/addNote")
    public ModelAndView createNote(@RequestParam(value="subject") String subject, @RequestParam(value = "text") String text, @RequestParam(value = "id") String id){
        noteService.addNewNote(subject, text, Long.parseLong(id), userService.getUserByUsername(userLoginService.findLoggedInUsername()));
        ModelAndView modelAndView = new ModelAndView("file");
        modelAndView.addObject("file", fileService.getFileByID(Long.parseLong(id)));
        modelAndView.addObject("notes", noteService.getNotesForFile(Long.parseLong(id)));
        return modelAndView;
    }
    
    @GetMapping(value = "/showAllNotes")
    public String getAllNotes(){
       return noteService.getAllNotes().toString();
    }
}
