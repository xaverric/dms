package cz.uhk.fim.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 1024, nullable = false)
    private String name;

    @Column(name = "dms_path", length = 1024, nullable = false)
    private String dmsPath;

    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(nullable = false)
    private Integer version;

    @Column(name = "private_file")
    private Boolean privateFile;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "approved_by")
    private Long approvedBy;

    @ManyToOne
    private User user;

    @ManyToOne
    private FileType fileType;

    @ManyToOne
    private Category category;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "File{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dmsPath='" + dmsPath + '\'' +
            ", lastModified=" + lastModified +
            ", fileSize=" + fileSize +
            ", version=" + version +
            ", privateFile=" + privateFile +
            ", parentId=" + parentId +
            ", approvedBy=" + approvedBy +
            ", user=" + user +
            ", fileType=" + fileType +
            ", category=" + category +
            '}';
    }
}
