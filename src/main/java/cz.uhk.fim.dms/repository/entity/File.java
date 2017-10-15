package cz.uhk.fim.dms.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="file")
public class File {

    //TODO třída není kompletní, hodil by se např číselník na kategorie

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String dmsPath;

    private User author;

    @Column(name="last_modified")
    private Date lastModified;

    private Integer version;

    @Column(name ="parent_id")
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDmsPath() {
        return dmsPath;
    }

    public void setDmsPath(String dmsPath) {
        this.dmsPath = dmsPath;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dmsPath='" + dmsPath + '\'' +
                ", author=" + author +
                ", lastModified=" + lastModified +
                ", version=" + version +
                ", parentId=" + parentId +
                '}';
    }
}
