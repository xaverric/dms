package cz.uhk.fim.rest.controller;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.entity.RoleService;
import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import cz.uhk.fim.dms.service.userregistration.UserRegistrationService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.User;
import cz.uhk.fim.repository.types.api.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

@Controller
public class UserController {

    @Autowired
    private SecurityService userLoginService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public ModelAndView registerUser(@RequestParam String firstName, @RequestParam String lastName,
                                     @RequestParam String username, @RequestParam String password,
                                     @RequestParam String passwordConfirm, @RequestParam String email){
        String[] seznamParametru = new String[]{firstName, lastName, username, password, passwordConfirm, email};
        String[] jmenaParametru = new String[]{"First name", "Last name", "Username", "Password", "Password confirm", "E-mail"};
        LinkedHashMap<String, String> seznamFieldu = new LinkedHashMap<>(seznamParametru.length);
        for (int i = 0; i < seznamParametru.length; i++) {
            seznamFieldu.put(jmenaParametru[i], seznamParametru[i]);
        }

        UserDTO userDTO = new UserDTOImpl(username, password, firstName, lastName, email, Arrays.asList(roleService.getRoleByName(RoleType.USER.getName())));
        return userRegistrationService.registerUser(userDTO, passwordConfirm, seznamFieldu);
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        userLoginService.autoLogin(username, password);
        String usr = userLoginService.findLoggedInUsername();
        if (usr != null && usr.equals(username)) {
            return new ModelAndView(new RedirectView("/user"));
        }
        return new ModelAndView("/wrong-username-or-password");
    }

    @PostMapping("/logout")
    public ModelAndView logoutUser(){
        return new ModelAndView(new RedirectView("/login"));
    }

    @PostMapping("/updateUser")
    public ModelAndView updateUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
                                   @RequestParam String phoneNumber, @RequestParam String birthDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthDate);
        UserDTO userDTO = new UserDTOImpl(userLoginService.findLoggedInUsername(), null, firstName, lastName, email, Arrays.asList(roleService.getRoleByName(RoleType.USER.getName())), phoneNumber, date);
        userService.updateUser(userDTO);
        return new ModelAndView(new RedirectView("/user"));
    }

    @PostMapping("changePassword")
    public ModelAndView changePassword(@RequestParam String password, @RequestParam String passwordConfirm) {
        ResultInfo<User> result = userService.changePassword( password, passwordConfirm, userLoginService.findLoggedInUsername());
        if (result.getStatus() == ResultInfo.Status.SUCCESS){
            ModelAndView modelAndView = new ModelAndView("/logout");
            modelAndView.addObject("message", result.getMessage());
            return new ModelAndView(new RedirectView("/logout"));
        } else {
            User user = userService.getUserByUsername(userLoginService.findLoggedInUsername());
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            if (user.getBorn() != null){
                modelAndView.addObject("birthDate", user.getBorn());
            }
            modelAndView.addObject("password_message", result.getMessage());
            return modelAndView;
        }
    }
}
