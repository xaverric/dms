package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.entity.UserServiceImpl;
import cz.uhk.fim.repository.dao.api.UserDao;
import cz.uhk.fim.repository.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private static final String PASSWORD_1 = "password1";
    private static final String PASSWORD_2 = "password2";
    private static final String USERNAME = "testUser";
    private static final String PASSWORD_HASH = "jlkdhadsfá879FDH077ýdS8D7087dé7Sdý0žé";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        when(userDao.changePassword(any(String.class),any(String.class))).thenReturn(prepareUser());
        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn(PASSWORD_HASH);
    }

    @Test
    public void testUserChangeCorrectPassword(){
        ResultInfo.Status status = userService.changePassword(PASSWORD_1, PASSWORD_1, USERNAME).getStatus();
        Assert.assertEquals(ResultInfo.Status.SUCCESS, status);
    }

    @Test
    public void testUserChangeIncorerectPasswords(){
        ResultInfo.Status status = userService.changePassword(PASSWORD_1, PASSWORD_2, USERNAME).getStatus();
        Assert.assertEquals(ResultInfo.Status.ERROR, status);
    }

    private User prepareUser(){
        User user = new User();
        user.setUsername("testUser");
        user.setPasswordHash("passwd");
        user.setBorn(new Date());
        user.setFirstName("user");
        return user;
    }
}
