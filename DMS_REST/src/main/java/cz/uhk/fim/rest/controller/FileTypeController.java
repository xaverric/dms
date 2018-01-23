package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.repository.entity.FileType;
import cz.uhk.fim.repository.types.api.FileTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileTypeController {
    
    @Autowired
    private FileTypeService fileTypeService;
    
    @GetMapping(value = "/createFileType")
    public String createFileType(@RequestParam(value="fileType") String fileType, @RequestParam(value = "suffix") String suffix, @RequestParam(value = "desc") String description){
        return fileTypeService.addFileType(fileType, suffix, description, FileTypeEnum.getCategoryBySuffix(fileType)).toString();
    }
    
    @GetMapping(value = "/showFileTypes")
    public String getFileTypes(){
        return fileTypeService.getAllFileTypes().toString();
    }
    
    @GetMapping(value = "/updateFileType/{id}")
    public String updateFileType(@PathVariable("id") Long id, @RequestParam(value="name", required = false) String name, @RequestParam(value = "suffix",required = false) String suffix, @RequestParam(value = "desc", required = false) String description){
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
