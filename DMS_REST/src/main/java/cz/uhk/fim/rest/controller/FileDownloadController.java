package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileDownloadService;
import cz.uhk.fim.repository.entity.File;
import cz.uhk.fim.repository.types.api.FileTypeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@Controller
public class FileDownloadController {

    @Autowired
    FileDownloadService fileDownloadService;

    @Autowired
    FileService fileService;

    @GetMapping("file/download/{id}")
    public ModelAndView downloadFile(@PathVariable("id") Long id, HttpServletResponse response){
        File file = fileService.getFileByID(id);
        java.io.File downloadedFile = fileDownloadService.downloadFile(file);
        if(downloadedFile == null) {
            ModelAndView model = new ModelAndView("files");
            model.addObject("bad_file","");
            return model;
    }
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mimeType = mimeTypesMap.getContentType(downloadedFile);
        response.setContentType(mimeType);
        response.setHeader("Content-disposition",String.format("attachment; filename=%s", file.getName()));
        try {
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(downloadedFile);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("files");
    }
}
