package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.Note;
import java.util.List;

public interface NoteService {

    Note getNoteById(Long id);

    List<Note> getNotesBySubject(String subject);

    List<Note> getAllNotes();

    Note addNewNote(String subject, String text);
}
