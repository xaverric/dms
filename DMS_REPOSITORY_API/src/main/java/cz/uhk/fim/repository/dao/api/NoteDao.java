package cz.uhk.fim.repository.dao.api;

import cz.uhk.fim.repository.entity.Note;
import java.util.List;

public interface NoteDao {
    
    Note getNoteById(Long id);
    
    List<Note> getNotesBySubject(String subject);
    
    List<Note> getAllNotes();
    
    Note addNewNote(String subject, String text);
    
}
