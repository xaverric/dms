package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.repository.dao.api.NoteDao;
import cz.uhk.fim.repository.entity.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.uhk.fim.dms.service.api.entity.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
    
    @Autowired
    private NoteDao noteDao;

    @Override
    public Note addNewNote(String subject, String text) {
       return noteDao.addNewNote(subject, text);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteDao.getNoteById(id);
    }

    @Override
    public List<Note> getNotesBySubject(String subject) {
        return noteDao.getNotesBySubject(subject);
    }
    
    
}
