package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.NoteDao;
import cz.uhk.fim.repository.entity.Note;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class NoteDaoImpl extends AbstractGenericDAO<Note> implements NoteDao{

    @Override
    public Note addNewNote(String subject, String text) {
        Note note = new Note();
        note.setSubject(subject);
        note.setText(text);
        note.setLastModified(new Date());
        getEntityManager().persist(note);
        return note;
    }
    

    @Override
    public List<Note> getAllNotes() {
        return getEntityManager().createQuery("from Note", Note.class).getResultList();
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
