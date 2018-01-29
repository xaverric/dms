package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.repository.dao.api.FileDao;
import cz.uhk.fim.repository.dto.api.FileDTO;
import cz.uhk.fim.repository.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public File getFileByID(Long id) {return fileDao.getFileByID(id);}

    @Override
    public File getFileByNameUsername(String fileName, String username) {
        return fileDao.getFileByNameUsername(fileName,username);
    }

    @Override
    public File getFileByUsername() {
        return fileDao.getFileByUsername();
    }

    @Override
    public File addFile(FileDTO fileDto) {
        return fileDao.addFile(fileDto);
    }

    @Override
    public File deleteFileVersion(FileDTO fileDto, Long version) {
        return fileDao.deleteFileVersion(fileDto, version);
    }

    @Override
    public List<File> findAllFiles() {
        return fileDao.findAllFiles();
    }
}
