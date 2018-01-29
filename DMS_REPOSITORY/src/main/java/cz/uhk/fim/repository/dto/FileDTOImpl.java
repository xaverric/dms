package cz.uhk.fim.repository.dto;

import cz.uhk.fim.repository.dto.api.FileDTO;
import cz.uhk.fim.repository.entity.Category;
import cz.uhk.fim.repository.entity.FileType;
import cz.uhk.fim.repository.entity.User;

import java.util.Date;

public class FileDTOImpl implements FileDTO {

    private Long id;
    private String name;
    private String dmsPath;
    private Date lastModified;
    private Long fileSize;
    private Integer version;
    private Boolean privateFile;
    private Long parentId;
    private User approvedBy;
    private User user;
    private FileType fileType;
    private Category category;

    public FileDTOImpl(String name, String dmsPath, Date lastModified, Long fileSize, Integer version, Boolean privateFile, Long parentId, User approvedBy, User user, FileType fileType, Category category) {
        this.name = name;
        this.dmsPath = dmsPath;
        this.lastModified = lastModified;
        this.fileSize = fileSize;
        this.version = version;
        this.privateFile = privateFile;
        this.parentId = parentId;
        this.approvedBy = approvedBy;
        this.user = user;
        this.fileType = fileType;
        this.category = category;
    }

    public FileDTOImpl(Long id, String name, String dmsPath, Integer version, Boolean privateFile, Long parentId, User approvedBy) {
        this.id = id;
        this.name = name;
        this.dmsPath = dmsPath;
        this.version = version;
        this.privateFile = privateFile;
        this.parentId = parentId;
        this.approvedBy = approvedBy;
    }

    @Override
    public User getApprovedBy() {
        return approvedBy;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String getDmsPath() {
        return dmsPath;
    }

    @Override
    public Long getFileSize() {
        return fileSize;
    }

    @Override
    public FileType getFileType() {
        return fileType;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public Boolean getPrivateFile() {
        return privateFile;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void setDmsPath(String dmsPath) {
        this.dmsPath = dmsPath;
    }

    @Override
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public void setPrivateFile(Boolean privateFile) {
        this.privateFile = privateFile;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

}
