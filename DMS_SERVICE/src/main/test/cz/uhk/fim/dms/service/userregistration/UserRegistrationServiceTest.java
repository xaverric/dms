package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserRegistrationServiceTest {

    private static final String PASSWORD_1 = "password1";
    private static final String PASSWORD_2 = "password2";

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    @Mock
    private UserService userService;

    private User user1;
    private User user2;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        user1 = prepareUser("testUser1", PASSWORD_1, new Date(), "test", "test");
        user2 = prepareUser("testUser2", PASSWORD_2, new Date(), "test", "test");
    }

    @Test
    public void addExistingUser(){
        when(userService.getUserByUsername(any(String.class))).thenReturn(user1);

        ResultInfo<User> result = userRegistrationService.registerUser(prepareUserDTO(user1), PASSWORD_1);
        Assert.assertEquals(ResultInfo.Status.ERROR, result.getStatus());
    }

    @Test
    public void addNewUserWithCorrectPassword(){
        when(userService.getUserByUsername(any(String.class))).thenReturn(null);
        when(userService.addNewUser(any(UserDTO.class))).thenReturn(user2);

        ResultInfo<User> result = userRegistrationService.registerUser(prepareUserDTO(user2), PASSWORD_2);
        Assert.assertEquals(ResultInfo.Status.SUCCESS, result.getStatus());
    }

    @Test
    public void addNewUserWithWrongPassword(){
        when(userService.getUserByUsername(any(String.class))).thenReturn(null);

        ResultInfo<User> result = userRegistrationService.registerUser(prepareUserDTO(user2), PASSWORD_1);
        Assert.assertEquals(ResultInfo.Status.ERROR, result.getStatus());
    }

    private UserDTO prepareUserDTO(User user){
        return new UserDTOImpl(user.getUsername(), user.getPasswordHash(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    private User prepareUser(String username, String password, Date date, String firstName, String lastName){
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(password);
        user.setBorn(date);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }
}
