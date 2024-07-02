package com.example.JWTAuth.Services;

import com.example.JWTAuth.Repo.UserRepo;
import com.example.JWTAuth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    public UserService() {
//       store.add(new User(UUID.randomUUID().toString(),"Purnendu","p@gmail.com"));
//       store.add(new User(UUID.randomUUID().toString(),"Manty","m@gmail.com"));
//       store.add(new User(UUID.randomUUID().toString(),"Megha","s@gmail.com"));
//       store.add(new User(UUID.randomUUID().toString(),"Nayak","k@gmail.com"));
//    }
    public List<User> getUser(){
        return userRepo.findAll();

    }
    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
