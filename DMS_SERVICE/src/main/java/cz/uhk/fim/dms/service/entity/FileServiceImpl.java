package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.repository.entity.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<File> findAllFiles() {
        return null;
    }
}
