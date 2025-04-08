package com.spring.JWTSecurity.Service;

import com.spring.JWTSecurity.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Sidd","sidd@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Kishan","kishan@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Ashish","ashish@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Raj","raj@gmail.com"));


    }
    public List<User> getUser(){
        return this.store;
    }


}
