package cz.uhk.fim.dms.tools;

import cz.uhk.fim.dms.service.api.entity.*;
import cz.uhk.fim.repository.dto.FileDTOImpl;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.entity.Category;
import cz.uhk.fim.repository.entity.FileType;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;
import cz.uhk.fim.repository.types.api.CategoryType;
import cz.uhk.fim.repository.types.api.FileTypeEnum;
import cz.uhk.fim.repository.types.api.RoleType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * This dataset prepares initial data and persist them into database before application is launched
 */

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

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    private List<Role> roles;
    private List<User> users;
    private List<FileType> fileTypes;
    private List<Category> categories;

    public InitializingBean load() {
        createRoles();
        createCategories();
        createFileTypes();
        createDefaultLabels();
        createDefaultUsers();
        createTestFileMetadata();
        return null;
    }

    private void createRoles() {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(roleService.addRole(RoleType.ADMIN.getName(), RoleType.ADMIN.getDescription(), 0L));
        roles.add(roleService.addRole(RoleType.USER.getName(), RoleType.USER.getDescription(), 1L));
    }

    private void createCategories() {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        for (CategoryType ct : CategoryType.values()) {
            categories.add(categoryService.addNewCategory(ct.name()));
        }
    }

    private void createFileTypes() {
        if (fileTypes == null) {
            fileTypes = new ArrayList<>();
        }
        for (FileTypeEnum fte : FileTypeEnum.values()) {
            fileTypes.add(fileTypeService.addFileType(fte.getName(), fte.getSuffix(), fte.getDesc(), fte.getCategory()));
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
        if (users == null) {
            users = new ArrayList<>();
        }
        createAdministrators();
        createUsers();
    }

    private void createAdministrators() {
        users.add(userService.addNewUser(new UserDTOImpl("admin", "adminpass", "Administrator", "Adminovic", "admin@admin.cz", getAdminRoles())));
    }

    private void createUsers() {
        users.add(userService.addNewUser(new UserDTOImpl("user", "userpass", "User", "Userovic", "user@user.cz", getUserRoles())));
    }

    private List<Role> getAdminRoles() {
        return roles;
    }

    private List<Role> getUserRoles() {
        return Arrays.asList(roles.stream().filter(role -> role.getName() == RoleType.USER.getName()).findFirst().get());
    }

    private void createTestFileMetadata() {
        for (int i = 0; i < 40; i++) {
            fileService.addFile(new FileDTOImpl("file_" + i, "/root/xxxx/file_" + i, new Date(), 10L, 1, false, null, userService.getUserById(1L), userService.getUserById(0L), fileTypes.get(0), categories.get(0)));
        }
    }
}
