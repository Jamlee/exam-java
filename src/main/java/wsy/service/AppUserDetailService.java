package wsy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wsy.model.Authority;
import wsy.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.loadUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Authority authorization : user.getAuthorities()){

            authorities.add(new SimpleGrantedAuthority("ROLE_"+ authorization.getName()));
        }

        return authorities;
    }
}
