package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.FileType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileTypeService {

    FileType getFileTypeBySuffix(String type);

    FileType getFileTypeById(Long id);

    List<FileType> getAllFileTypes();

    FileType addFileType(String name, String suffix, String description, String fileTypeCategory);

    FileType updateFileTypeSuffix(Long id, String suffix);
    
    FileType updateFileTypeName(Long id, String name);
    
    FileType updateFileTypeDescription(Long id, String description);
    
}
