package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileDownloadService;
import cz.uhk.fim.repository.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class FileDownloadController {

    @Autowired
    FileDownloadService fileDownloadService;

    @Autowired
    FileService fileService;

    @GetMapping("file/download/{id}")
    public ModelAndView downloadFile(@PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request){
        File file = fileService.getFileByID(id);
        java.io.File downloadedFile = fileDownloadService.downloadFile(file);
        if(downloadedFile == null) {
            ModelAndView model = new ModelAndView("files");
            model.addObject("uploadMessage","The file is broken. It can not be downloaded.");
            model.addObject("filesMetadata", fileService.findAllFiles());
            return model;
    }
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String mimeType = mimeTypesMap.getContentType(downloadedFile);
        response.setContentType(String.format("%s; charset=UTF-8",mimeType));
        response.setCharacterEncoding("UTF-8");
        String encodingHeaderName = fileDownloadService.getEncodingHeaderName(request.getHeader("User-Agent"), file.getName());
        if(encodingHeaderName.isEmpty()){
            ModelAndView model = new ModelAndView("files");
            model.addObject("uploadMessage","Unsopported format of the file");
            model.addObject("filesMetadata", fileService.findAllFiles());
            return model;
        }
        response.setHeader("Content-disposition", encodingHeaderName);

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
