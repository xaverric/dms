package cz.uhk.fim.repository.dto;

import cz.uhk.fim.repository.dto.api.UserDTO;
import cz.uhk.fim.repository.entity.Role;

import java.util.Date;
import java.util.List;

public class UserDTOImpl implements UserDTO {

    private Long id;
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
    private String phoneNumber;
    private Date birthDate;

    public UserDTOImpl(Long id, String username, String passwordHash, String firstName, String lastName, String email, List<Role> roles, String phoneNumber, Date birthDate) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public UserDTOImpl(String username, String passwordHash, String firstName, String lastName, String email, List<Role> roles, String phoneNumber, Date birthDate) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public UserDTOImpl(Long id, String username, String passwordHash, String firstName, String lastName, String email, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public UserDTOImpl(String username, String passwordHash, String firstName, String lastName, String email, List<Role> roles) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public UserDTOImpl(Long id, String username, String passwordHash, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTOImpl(String username, String passwordHash, String firstName, String lastName, String email) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPasswordHash() {
        return passwordHash;
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
