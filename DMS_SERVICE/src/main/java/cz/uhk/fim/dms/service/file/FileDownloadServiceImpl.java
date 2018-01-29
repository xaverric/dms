package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.file.FileDownloadService;
import cz.uhk.fim.repository.entity.File;
import org.springframework.stereotype.Service;

import java.nio.file.Files;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    @Override
    public java.io.File downloadFile(File file) {
        if(file != null){
           java.io.File downloadedFile = new java.io.File(file.getDmsPath());
           if(Files.exists(downloadedFile.toPath())){
                return downloadedFile;
           }
        }
        return null;
    }
}
