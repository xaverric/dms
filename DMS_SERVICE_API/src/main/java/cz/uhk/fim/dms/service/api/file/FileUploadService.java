package cz.uhk.fim.dms.service.api.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

     ResultInfo<MultipartFile> uploadFile(MultipartFile file);

     String getDirectoryPathByOs(String username);
}
