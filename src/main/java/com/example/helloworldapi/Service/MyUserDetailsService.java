package com.example.helloworldapi.Service;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("USERNAME NOT FOUND")
                );
        UserDetails userDetails = new User(username,myUser.getPassword(), AuthorityUtils.createAuthorityList(myUser.getRole()));

        return userDetails;
    }
}
