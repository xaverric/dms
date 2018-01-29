package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.file.FileUploadService;
import cz.uhk.fim.dms.service.api.file.FileValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FileValidationService fileValidationService;

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
        ResultInfo<MultipartFile> resultInfo = fileValidationService.checkFileBeforeUpload(file);
        if(resultInfo == null){
            resultInfo = fileUploadService.uploadFile(file);
        }
        ModelAndView modelAndView = new ModelAndView("files");
        modelAndView.addObject("uploadMessage", resultInfo.getMessage());
        return modelAndView;
    }
}
