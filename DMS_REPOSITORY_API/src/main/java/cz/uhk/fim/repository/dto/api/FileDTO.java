package cz.uhk.fim.repository.dto.api;

import cz.uhk.fim.repository.entity.Category;
import cz.uhk.fim.repository.entity.FileType;
import cz.uhk.fim.repository.entity.User;

import java.util.Date;

public interface FileDTO {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getDmsPath();

    void setDmsPath(String dmsPath);

    Date getLastModified();

    void setLastModified(Date lastModified);

    Long getFileSize();

    void setFileSize(Long fileSize);

    Integer getVersion();

    void setVersion(Integer version);

    Boolean getPrivateFile();

    void setPrivateFile(Boolean privateFile);

    Long getParentId();

    void setParentId(Long parentId);

    User getApprovedBy();

    void setApprovedBy(User approvedBy);

    User getUser();

    void setUser(User user);

    FileType getFileType();

    void setFileType(FileType fileType);

    Category getCategory();

    void setCategory(Category category);
}
