package demo.spring.securitybasic.config.security;

import demo.spring.securitybasic.entity.Role;
import demo.spring.securitybasic.entity.User;
import demo.spring.securitybasic.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CustormUserdetailServices implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
       for (Role role : user.getRoles()) {
           authorities.add(new SimpleGrantedAuthority(role.getName()));
       }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
