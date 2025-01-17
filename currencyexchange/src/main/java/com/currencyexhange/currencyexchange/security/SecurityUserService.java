package com.currencyexhange.currencyexchange.security;

import com.currencyexhange.currencyexchange.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    com.currencyexhange.currencyexchange.service.user.UserService userService;

    private final String GRANTED_AUTHORITY_READ = "READ";
    private final String GRANTED_AUTHORITY_WRITE = "WRITE";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userService.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in the database with email: " + username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //TODO: Map to the user role or User Group of the employee and accordingly
        grantedAuthorities.add(new SimpleGrantedAuthority(GRANTED_AUTHORITY_READ));
        grantedAuthorities.add(new SimpleGrantedAuthority(GRANTED_AUTHORITY_WRITE));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}