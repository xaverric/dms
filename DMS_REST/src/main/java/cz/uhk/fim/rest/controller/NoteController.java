package cz.uhk.fim.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import cz.uhk.fim.dms.service.api.entity.NoteService;
import cz.uhk.fim.repository.entity.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    
    @Autowired
    private NoteService noteService;
    
    @PostMapping(value = "/createNote")
    public String createNote(@RequestParam(value="subject") String subject,
            @RequestParam(value = "text") String text){
        Note note = noteService.addNewNote(subject, text);
        if(note != null){
            //prechod na novou stranku 
            return "";
        }else{
            //vraceni
            return "";
        }
    }
    
    @GetMapping(value = "/showAllNotes")
    public String getAllNotes(){
       return noteService.getAllNotes().toString();
    }
}
