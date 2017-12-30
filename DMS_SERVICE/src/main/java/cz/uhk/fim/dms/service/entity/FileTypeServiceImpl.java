package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.repository.dao.api.FileTypeDao;
import cz.uhk.fim.repository.entity.FileType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileTypeServiceImpl implements FileTypeService{

    @Autowired
    private FileTypeDao fileTypeDao;
    
    @Override
    public FileType addFileType(String name, String suffix, String description) {
        return fileTypeDao.addFileType(name, suffix, description);
    }

    @Override
    public List<FileType> getAllFileTypes() {
        return fileTypeDao.getAllFileTypes();
    }

    @Override
    public FileType getFileTypeById(Long id) {
        return fileTypeDao.getFileTypeById(id);
    }

    @Override
    public FileType getFileTypeBySuffix(String type) {
        return fileTypeDao.getFileTypeBySuffix(type);
    }
    
}
