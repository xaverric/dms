package cz.uhk.fim.dms.tools;

import cz.uhk.fim.dms.service.api.entity.CategoryService;
import cz.uhk.fim.dms.service.api.entity.FileTypeService;
import cz.uhk.fim.dms.service.api.entity.LabelService;
import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.types.api.CategoryType;
import cz.uhk.fim.repository.types.api.FileTypeEnum;
import cz.uhk.fim.repository.types.api.RoleType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This dataset prepares initial data and persist them into database before application is launched
 */

//TODO Hodilo by se dodělat oveření zda přišlušný data už v databázi nenacházejí případně by mohlo stačit dát na některý atributy v entitách unique a data by se nevložily znovu - to ale neřeší problem jenom ho to obchází
//tak u enumu se ta kontrola asi delat nemusi a na label, user uz kontrola je
@Component
public class InitialDataSet {

    @Autowired
    private RoleService roleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileTypeService fileTypeService;

    @Autowired
    private LabelService labelService;

    //TODO chybí taky NoteDao a NoteService tady v initial datasetu ale asi nebude potřeba
    //na to bych se vprdnul, na to neni cas :D

    @Autowired
    private UserService userService;

    private List<Role> roles;

    public InitializingBean load() {
        createRoles();
        createCategories();
        createFileTypes();
        createDefaultLabels();
        createDefaultUsers();
        return null;
    }

    private void createRoles() {
        if (roles == null){
            roles =new ArrayList<>();
        }
        roles.add(roleService.addRole(RoleType.ADMIN.getName(), RoleType.ADMIN.getDescription(), 0L));
        roles.add(roleService.addRole(RoleType.USER.getName(), RoleType.USER.getDescription(), 1L));
    }

    private void createCategories() {
        for (CategoryType ct : CategoryType.values()) {
            categoryService.addNewCategory(ct.name());
        }      
    }

    private void createFileTypes() {
        for (FileTypeEnum fte : FileTypeEnum.values()) {
            fileTypeService.addFileType(fte.getName(), fte.getSuffix(), fte.getDesc(), fte.getCategory());
        }
    }

    private void createDefaultLabels() {
        labelService.addNewLabel("work");
        labelService.addNewLabel("accounts");
        labelService.addNewLabel("production");
        labelService.addNewLabel("machine");
        labelService.addNewLabel("facebook");
        labelService.addNewLabel("advertisement");
        labelService.addNewLabel("propagation");
        labelService.addNewLabel("vacation");
        labelService.addNewLabel("taxes");
    }

    private void createDefaultUsers() {
        createAdministrators();
        createUsers();
    }

    private void createAdministrators() {
        userService.addNewUser(new UserDTOImpl("admin", "adminpass", "Administrator", "Adminovic", "admin@admin.cz", getAdminRoles()));
    }

    private void createUsers() {
        userService.addNewUser(new UserDTOImpl("user", "userpass", "User", "Userovic", "user@user.cz", getUserRoles()));
    }

    private List<Role> getAdminRoles(){
        return roles;
    }

    private List<Role> getUserRoles(){
        return Arrays.asList(roles.stream().filter(role -> role.getName() == RoleType.USER.getName()).findFirst().get());
    }
}
