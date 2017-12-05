package cz.uhk.fim.rest.controller;


import cz.uhk.fim.dms.service.userregistration.UserRegistrationService;
import cz.uhk.fim.repository.dto.UserDTOImpl;
import cz.uhk.fim.repository.dto.api.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestParam String firstName, @RequestParam String lastName,
                                       @RequestParam String username, @RequestParam String password,
                                       @RequestParam String passwordConfirm, @RequestParam String email, UriComponentsBuilder ucBuilder) {
        UserDTO userDTO = new UserDTOImpl(username, password, firstName, lastName, email);
        userRegistrationService.registerUser(userDTO, passwordConfirm);

        //TODO nefunguje přesměrování
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{username}").buildAndExpand(userDTO.getUsername()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
