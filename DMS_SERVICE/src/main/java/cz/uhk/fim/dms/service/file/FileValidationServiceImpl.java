package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.dms.service.api.file.FileValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileValidationServiceImpl implements FileValidationService {

    private final long MAX_FILE_SIZE_IN_MB = 20;

@Autowired
    private FileTypeService fileTypeService;


    @Override
    public ResultInfo<MultipartFile> checkFileBeforeUpload(MultipartFile file) {
        if (file == null || file.getOriginalFilename().isEmpty()) {
            return new ResultInfo(file, "File could not be uploaded.", ResultInfo.Status.ERROR);
        }
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        if (fileTypeService.getFileTypeBySuffix(fileSuffix) == null) {
            return new ResultInfo<>(file, String.format("File %s has unsopported format (%s)", file.getName(), fileSuffix), ResultInfo.Status.ERROR);
        }
        long fileLength = file.getSize();
        if (getFileSizeInMB(fileLength) > MAX_FILE_SIZE_IN_MB) {
            return new ResultInfo<>(file, String.format("File %s is too big for upload (%s MB). Max file size is 20 MB",
                file.getName(), getFileSizeInMB(fileLength)), ResultInfo.Status.ERROR);
        }
        return null;
    }

    private long getFileSizeInMB(long fileSizeInBytes){
        return (fileSizeInBytes / 1024) / 1024;
    }
}
