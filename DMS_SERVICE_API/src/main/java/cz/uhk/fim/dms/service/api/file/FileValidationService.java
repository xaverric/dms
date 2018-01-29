package cz.uhk.fim.dms.service.api.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileValidationService {

    ResultInfo<MultipartFile> checkFileBeforeUpload(MultipartFile file);

    long getFileSizeInMB(long fileSizeInBytes);

    long getConvertMBToB(long sizeInMB);
}
