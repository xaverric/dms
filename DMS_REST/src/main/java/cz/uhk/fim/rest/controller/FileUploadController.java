package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.file.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file){
        fileUploadService.uploadFile(file);
        return new ModelAndView("files");
    }
}
