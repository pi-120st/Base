package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BaseService baseService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
            SignUp signUp = baseService.findByLogin(login);
            if (signUp == null)
                throw new UsernameNotFoundException(login + " not found");

            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority(signUp.getRole()));

            return new User(signUp.getEmail(), signUp.getPassword(), roles);
    }
}
