package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.repository.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String createRole(@RequestParam(value = "roleName") String roleName, 
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "desc") String desc){
        return roleService.addRole(roleName, desc, Long.valueOf(0)).toString();
    }
    
    @RequestMapping(value = "/showroles", method = RequestMethod.GET)
    public String getAllRoles(){
        return roleService.getAllRoles().toString();
    }
    
    @RequestMapping(value = "/updateRole/{roleId}", method = RequestMethod.GET)
    public String updateRole(@PathVariable("roleId") Long roleId, @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "desc", required = false) String desc,
            @RequestParam(value = "parentId", required = false) Long parentId){
        Role role = roleService.getRoleById(roleId);
        if(name != null){
            roleService.updateRoleName(roleId, name);
        }
        if(desc != null){
            roleService.updateRoleDescription(roleId, desc);
        }
        if(parentId != null){
            roleService.updateRoleParentId(roleId, parentId);
        }
        return role.toString();
    }

}
