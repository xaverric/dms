package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.FileType;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTypeService {

    FileType getFileTypeBySuffix(String type);

    FileType getFileTypeById(Long id);

    List<FileType> getAllFileTypes();

    FileType addFileType(String name, String suffix, String description);

    FileType updateFileTypeSuffix(Long id, String suffix);
    
    FileType updateFileTypeName(Long id, String name);
    
    FileType updateFileTypeDescription(Long id, String description);
    
}
