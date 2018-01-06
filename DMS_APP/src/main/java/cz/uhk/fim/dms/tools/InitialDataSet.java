package cz.uhk.fim.dms.tools;

import cz.uhk.fim.dms.service.api.entity.CategoryService;
import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.types.api.RoleType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataSet {

    @Autowired
    private RoleService roleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileTypeService fileTypeService;

    //TODO private LabelService labelService;

    @Autowired
    private UserService userService;

    public InitializingBean load(){
        List<Role> roles = createRoles();
        createCategories();
        createFileTypes();
        createDefaultLables();
        createDefaultUsers(roles);
        return null;
    }

    private List<Role> createRoles(){
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleService.addRole(RoleType.ADMIN.getName(), RoleType.ADMIN.getDescription(), 1L));
        roles.add(roleService.addRole(RoleType.USER.getName(), RoleType.USER.getDescription(), 1L));
        return roles;
    }

    private void createCategories(){
        //TODO
    }

    private void createFileTypes(){
        //TODO
    }

    private void createDefaultLables(){
        //TODO
    }

    private void createDefaultUsers(List<Role> roles){
        userService.addNewUser(new UserDTOImpl("admin","adminpass","Administrator", "Adminovic", "admin@admin.cz", roles));
    }
}
