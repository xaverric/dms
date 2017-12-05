package cz.uhk.fim.dms.service.userlogin;

import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserService userService;

    public User loginUser(String username, String password) {
        User user = userService.getUserByUsername(username);
        if (canLogin(user, password)) {
            return user;
        }
        return null;
    }

    private boolean canLogin(User user, String password) {
        return user != null && isPasswordCorrect(user, password);
    }

    private boolean isPasswordCorrect(User user, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password).equals(user.getPasswordHash());
    }

}
