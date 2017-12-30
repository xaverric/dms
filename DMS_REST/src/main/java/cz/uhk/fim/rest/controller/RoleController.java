package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = "/createRole/{roleName}/{id}/{desc}", method = RequestMethod.GET)
    public String createRole(@PathVariable("roleName") String roleName, @PathVariable("id") Long id, @PathVariable("desc") String desc){
        return roleService.addRole(roleName, desc, Long.valueOf(0)).toString();
    }
    
    @RequestMapping(value = "/showroles", method = RequestMethod.GET)
    public String getAllRoles(){
        return roleService.getAllRoles().toString();
    }

}
