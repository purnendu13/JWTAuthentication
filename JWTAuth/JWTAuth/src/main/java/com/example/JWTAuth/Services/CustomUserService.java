package com.example.JWTAuth.Services;

import com.example.JWTAuth.Repo.UserRepo;
import com.example.JWTAuth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load user from database
    User user=userRepo.findByEmail(username).orElseThrow(()-> new RuntimeException("User not found"));

        return user;
    }
}
