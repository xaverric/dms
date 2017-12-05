package cz.uhk.fim.repository.dto.api;

import cz.uhk.fim.repository.entity.Role;

import java.util.List;

public interface UserDTO {

    Long getId();

    void setId(Long id);

    String getUsername();

    void setUsername(String username);

    String getPasswordHash();

    void setPasswordHash(String passwordHash);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    List<Role> getRoles();

    void setRoles(List<Role> roles);
}
