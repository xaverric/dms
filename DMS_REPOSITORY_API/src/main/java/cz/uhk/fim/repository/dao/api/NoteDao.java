package cz.uhk.fim.repository.dao.api;

import cz.uhk.fim.repository.entity.File;
import cz.uhk.fim.repository.entity.Note;
import cz.uhk.fim.repository.entity.User;

import java.util.List;

public interface NoteDao {
    
    Note getNoteById(Long id);
    
    List<Note> getNotesBySubject(String subject);
    
    List<Note> getAllNotes();

    List<Note> getNotesForFile(Long id);

    Note addNewNote(String subject, String text,  File file, User user);
}
