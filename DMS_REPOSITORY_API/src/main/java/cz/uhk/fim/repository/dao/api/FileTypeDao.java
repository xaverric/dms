package cz.uhk.fim.repository.dao.api;

import cz.uhk.fim.repository.entity.FileType;
import java.util.List;

public interface FileTypeDao {
    
    FileType getFileTypeBySuffix(String type);

    FileType getFileTypeById(Long id);
    
    List<FileType> getAllFileTypes();
    
    FileType addFileType(String name, String suffix, String description);
}
