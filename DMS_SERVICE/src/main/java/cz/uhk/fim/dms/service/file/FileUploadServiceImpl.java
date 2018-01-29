package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.ResultInfo;
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

    @Autowired
    private SecurityService securityService;

    @Override
    public ResultInfo<Path> uploadFile(MultipartFile file) {
        String username = securityService.findLoggedInUsername();
        Path path = null;
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
            directoryPath = String.format("%s%s%s", directory.getAbsolutePath(), File.separator, file.getOriginalFilename());
            path = Paths.get(directoryPath);
            Files.write(path, bytes);
        } catch (IOException e) {
            return new ResultInfo<>(path, String.format("File %s was not uploaded, %s", file.getOriginalFilename(), e.getMessage()), ResultInfo.Status.ERROR);
        }
        return new ResultInfo<>(path, String.format("File %s successfully uploaded", file.getOriginalFilename()), ResultInfo.Status.SUCCESS);
    }

    @Override
    public String getDirectoryPathByOs(String username) {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return "C:" + File.separator + "Windows" + File.separator + "Temp" + File.separator + username;
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            return File.separator + "opt" + File.separator + "dms" + File.separator + username;
        } else {
            return "";
        }
    }
}
