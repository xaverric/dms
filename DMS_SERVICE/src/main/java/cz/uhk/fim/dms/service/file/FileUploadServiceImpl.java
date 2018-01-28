package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileUploadService;
import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    private static final String HOME_FOLDER = "C:\\Users\\prikr\\Dokumenty\\%s\\%s";

    @Autowired
    private FileService fileService;

    @Autowired
    private SecurityService securityService;

    @Override
    public ResultInfo<MultipartFile> uploadFile(MultipartFile file) {
        String username = securityService.findLoggedInUsername();

        try {
            byte[] bytes = file.getBytes();
            String directoryPath = getDirectoryPathByOs(username.toLowerCase());
            if(directoryPath.isEmpty()){
               return new ResultInfo<>(null, "OS not supported", ResultInfo.Status.ERROR);
            }
            File directory = new File(String.format(directoryPath, username.toLowerCase()));
            if(!directory.exists()){
                directory.mkdir();
            }
            if(directory.getAbsolutePath().contains("\\")){
                directoryPath = String.format("%s\\%s", directory.getAbsolutePath(), file.getOriginalFilename());
            }else{
                directoryPath = String.format("%s/%s", directory.getAbsolutePath(), file.getOriginalFilename());
            }
            Path path = Paths.get(directoryPath);
            Files.write(path, bytes);
        } catch (IOException e) {
            return new ResultInfo<>(file, String.format("File %s was not uploaded, %s", file.getName(), e.getMessage()), ResultInfo.Status.ERROR);
        }

        return new ResultInfo<>(file, String.format("File %s successfully uploaded", file.getName()), ResultInfo.Status.SUCCESS);
    }

    @Override
    public String getDirectoryPathByOs(String username) {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return String.format("C:\\Windows\\Temp\\%s\\", username);
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            return String.format("/opt/dms/%s/", username);
        } else {
            return "";
        }
    }
}
