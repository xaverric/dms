package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileUploadService;
import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    private static final String HOME_FOLDER = "/opt/dms/%s/%s";

    @Autowired
    private FileService fileService;

    @Autowired
    private SecurityService securityService;

    @Override
    public ResultInfo<MultipartFile> uploadFile(MultipartFile file) {
        String username = securityService.findLoggedInUsername();

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(String.format(HOME_FOLDER, username.toLowerCase(), file.getOriginalFilename()));
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResultInfo<>(file, String.format("File %s successfully uploaded", file.getName()), ResultInfo.Status.ERROR);
    }
}
