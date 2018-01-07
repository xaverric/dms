package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.repository.dao.api.FileTypeDao;
import cz.uhk.fim.repository.entity.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTypeServiceImpl implements FileTypeService {

    @Autowired
    private FileTypeDao fileTypeDao;

    @Override
    public FileType addFileType(String name, String suffix, String description, String fileTypeCategory) {
        return fileTypeDao.addFileType(name, suffix, description, fileTypeCategory);
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

    @Override
    public FileType updateFileTypeDescription(Long id, String description) {
        return fileTypeDao.updateFileTypeDescription(id, description);
    }

    @Override
    public FileType updateFileTypeName(Long id, String name) {
        return fileTypeDao.updateFileTypeName(id, name);
    }

    @Override
    public FileType updateFileTypeSuffix(Long id, String suffix) {
        return fileTypeDao.updateFileTypeSuffix(id, suffix);
    }

}
