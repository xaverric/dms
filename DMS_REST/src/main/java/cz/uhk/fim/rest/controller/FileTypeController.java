package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.repository.entity.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileTypeController {
    
    @Autowired
    private FileTypeService fileTypeService;
    
    @RequestMapping(value = "/createFileType", method = RequestMethod.GET)
    public String createFileType(@RequestParam(value="fileType") String fileType,
            @RequestParam(value = "suffix") String suffix,
            @RequestParam(value = "desc") String description){       
        return fileTypeService.addFileType(fileType, suffix, description).toString();
    }
    
    @RequestMapping(value = "/showFileTypes", method = RequestMethod.GET)
    public String getFileTypes(){
        return fileTypeService.getAllFileTypes().toString();
    }
    
    @RequestMapping(value = "/updateFileType/{id}", method = RequestMethod.GET)
    public String updateFileType(@PathVariable("id") Long id, @RequestParam(value="name", required = false) String name,
            @RequestParam(value = "suffix",required = false) String suffix,
            @RequestParam(value = "desc", required = false) String description){
        FileType ft = fileTypeService.getFileTypeById(id);
        if(name != null){
            fileTypeService.updateFileTypeName(id, name);
        }
        if(suffix != null){
            fileTypeService.updateFileTypeSuffix(id, suffix);
        }
        if(description != null){
            fileTypeService.updateFileTypeDescription(id, description);
        }
        return ft.toString();
    }
    
}
