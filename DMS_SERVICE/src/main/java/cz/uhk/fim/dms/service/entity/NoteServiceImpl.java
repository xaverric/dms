package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.entity.NoteService;
import cz.uhk.fim.repository.dao.api.NoteDao;
import cz.uhk.fim.repository.entity.File;
import cz.uhk.fim.repository.entity.Note;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private FileService fileService;

    @Override
    public Note addNewNote(String subject, String text, Long fileID, User user) {
        File file = fileService.getFileByID(fileID);
        return noteDao.addNewNote(subject, text, file, user);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    @Override
    public List<Note> getNotesForFile(Long id) {
        return noteDao.getNotesForFile(id);
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
