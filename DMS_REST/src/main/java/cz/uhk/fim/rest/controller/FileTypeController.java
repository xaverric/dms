package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileTypeController {
    
    @Autowired
    private FileTypeService fileTypeService;
    
    @RequestMapping(value = "/createFileType/{fileType}/{suffix}/{desc}", method = RequestMethod.GET)
    public String createFileType(@PathVariable("fileType") String fileType, @PathVariable("suffix") String suffix, @PathVariable("desc") String description){       
        return fileTypeService.addFileType(fileType, suffix, description).toString();
    }
    
    @RequestMapping(value = "/showFileTypes", method = RequestMethod.GET)
    public String getFileTypes(){
        return fileTypeService.getAllFileTypes().toString();
    }
}
