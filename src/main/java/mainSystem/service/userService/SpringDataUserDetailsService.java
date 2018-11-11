package mainSystem.service.userService;

import mainSystem.model.userInitModels.User;
import mainSystem.model.userInitModels.UserAuthRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(s);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(UserAuthRoleEnum.ADMIN.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),roles
        );

        return userDetails;
    }
}
