package com.extrawest.usermicroservice.security;

import com.extrawest.usermicroservice.exception.ApiRequestException;
import com.extrawest.usermicroservice.model.User;
import com.extrawest.usermicroservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsServiceImpl")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new ApiRequestException("User already exist " + email));
        return SecurityUser.fromUser(user);
    }
}
