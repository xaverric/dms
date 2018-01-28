package cz.uhk.fim.dms.service.userlogin;

import cz.uhk.fim.dms.service.api.entity.UserService;
import cz.uhk.fim.repository.entity.Role;
import cz.uhk.fim.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user == null){
            return null;
        }
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(), grantedAuthoritySet);
    }
}
