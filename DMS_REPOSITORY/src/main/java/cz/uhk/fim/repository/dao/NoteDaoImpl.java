package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.NoteDao;
import cz.uhk.fim.repository.entity.File;
import cz.uhk.fim.repository.entity.Note;
import cz.uhk.fim.repository.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class NoteDaoImpl extends AbstractGenericDAO<Note> implements NoteDao{

    @Override
    public Note addNewNote(String subject, String text, File file, User user) {
        Note note = new Note();
        note.setSubject(subject);
        note.setText(text);
        note.setLastModified(new Date());
        note.setFile(file);
        note.setUser(user);
        getEntityManager().persist(note);
        return note;
    }

    @Override
    public List<Note> getAllNotes() {
        return getEntityManager().createQuery("from Note", Note.class).getResultList();
    }

    @Override
    public List<Note> getNotesForFile(Long id) {
        Query query = getEntityManager().createQuery("from Note where file_id = :fileid", Note.class);
        query.setParameter("fileid", id);
        return query.getResultList();
    }

    @Override
    public Note getNoteById(Long id) {
        return getEntityManager().find(Note.class, id);
    }

    @Override
    public List<Note> getNotesBySubject(String subject) {
        Query query = getEntityManager().createQuery("from Note where subject = :subject", Note.class);
        query.setParameter("subject", subject);
        return query.getResultList();
    }


}
