package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.FileService;
import cz.uhk.fim.dms.service.api.file.FileUploadService;
import cz.uhk.fim.dms.service.api.file.FileValidationService;
import cz.uhk.fim.dms.service.userlogin.UserLoginServiceImpl;
import cz.uhk.fim.repository.dto.FileDTOImpl;
import cz.uhk.fim.repository.dto.api.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.util.Date;

@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FileValidationService fileValidationService;

    @Autowired
    private FileService fileService;

    @Autowired
    private UserLoginServiceImpl securityService;

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
        ResultInfo<MultipartFile> resultInfo = fileValidationService.checkFileBeforeUpload(file);
        if (resultInfo.getStatus() == ResultInfo.Status.SUCCESS) {
            ResultInfo<Path> result = fileUploadService.uploadFile(file);
            fileService.addFile(buildFileDTO(file, result));
            if(result.getStatus() == ResultInfo.Status.SUCCESS){
                resultInfo.setMessage(result.getMessage());
            }
        }
        ModelAndView modelAndView = new ModelAndView("files");
        modelAndView.addObject("uploadMessage", resultInfo.getMessage());
        modelAndView.addObject("filesMetadata", fileService.findAllFiles());
        return modelAndView;
    }

    private FileDTO buildFileDTO(MultipartFile file, ResultInfo<Path> resultInfo) {
        FileDTO fileDTO = new FileDTOImpl();
        fileDTO.setName(file.getOriginalFilename());
        fileDTO.setDmsPath(resultInfo.getObject().toAbsolutePath().toString());
        fileDTO.setLastModified(new Date());
        fileDTO.setFileSize(file.getSize());
        //Integer version = fileService.getFileByNameUsername(file.getName(), securityService.findLoggedInUsername()).getVersion();
        //if (version != null) {
        //    fileDTO.setVersion(++version);
        //} else {
            fileDTO.setVersion(1);
        // }
        fileDTO.setPrivateFile(false);
        return fileDTO;
    }
}
