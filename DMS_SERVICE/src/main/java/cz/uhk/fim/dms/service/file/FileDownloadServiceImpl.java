package cz.uhk.fim.dms.service.file;

import cz.uhk.fim.dms.service.api.file.FileDownloadService;
import cz.uhk.fim.repository.entity.File;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @Override
    public String getEncodingHeaderName(String browserTypeHeader, String fileName) {
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

        if (browserTypeHeader.contains("Firefox")) {
            return "attachment; filename*=UTF-8''" + encodedFileName;
        } else if (browserTypeHeader.contains("Chrome")){
            return "attachment; filename=" + encodedFileName;
        } else{
           return "attachment; filename*=UTF-8''" + encodedFileName;
        }
    }
}
