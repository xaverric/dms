package cz.uhk.fim.dms.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "dms_path")
    private String dmsPath;

    @Column(name = "last_modified")
    private Date lastModified;

    @Column(name = "file_size")
    private Long fileSize;

    private Integer version;

    @Column(name = "private_file")
    private Boolean privateFile;

    @Column(name = "parent_id")
    private Long parentId;

    private Long approvedBy;

    @ManyToOne
    private User author;

    @Column(name = "file_type")
    @ManyToOne
    private FileType fileType;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "id")
    private Note note;

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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getPrivateFile() {
        return privateFile;
    }

    public void setPrivateFile(Boolean privateFile) {
        this.privateFile = privateFile;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
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
