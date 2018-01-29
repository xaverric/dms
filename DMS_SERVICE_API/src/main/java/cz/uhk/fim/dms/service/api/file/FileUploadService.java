package cz.uhk.fim.dms.service.api.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileUploadService {

     ResultInfo<Path> uploadFile(MultipartFile file);

     String getDirectoryPathByOs(String username);
}
