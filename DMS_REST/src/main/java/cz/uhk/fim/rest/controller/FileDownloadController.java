package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileDownloadService;
import cz.uhk.fim.repository.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileDownloadController {

    @Autowired
    FileDownloadService fileDownloadService;

    @Autowired
    FileService fileService;

    @GetMapping("file/download/{id}")
    public StreamingResponseBody downloadFile(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        File file = fileService.getFileByID(id);
        java.io.File downloadedFile = fileDownloadService.downloadFile(file);
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mimeType = mimeTypesMap.getContentType(downloadedFile);
        response.setContentType(mimeType);
        response.setHeader("Content-disposition", String.format("attachment; filename=%s", file.getName()));
        FileInputStream in = new FileInputStream(downloadedFile);
        OutputStream out = response.getOutputStream();
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = in.read(data, 0, data.length)) != -1) {
                out.write(data, 0, nRead);
            }
            in.close();
        };
    }
}
