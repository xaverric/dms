package cz.uhk.fim.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String text;

    @Column(name="last_modified", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;

    @ManyToOne
    private User user;

    @ManyToOne
    private File file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", subject=" + subject + 
                ", text=" + text + ", lastModified=" 
                + lastModified + ", user=" + user + '}';
    }

    

}
