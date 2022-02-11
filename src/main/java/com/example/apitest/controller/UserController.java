package com.example.apitest.controller;

import com.example.apitest.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private Map<Long, User> userMap;

    @PostConstruct
    public void post(){

        userMap = new HashMap<Long, User>();
        userMap.put(1L, new User(1L, 28, "EarlyBird", "Busan", "1234-5678"));
        userMap.put(2L, new User(2L, 28, "CottonWood", "Busan", "1234-5678"));
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){

        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<User> getUserAll(){

        return new ArrayList<User>(userMap.values());
    }

    @PutMapping("/user/{id}")
    public void putUser(@PathVariable("id") Long id, @RequestParam("age") int age, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone){

        User user = new User(id, age, name, address, phone);
        userMap.put(id, user);
    }

    @PostMapping("/user/{id}")
    public void postUser(@PathVariable("id") Long id, @RequestParam("age") int age, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone){

        User user = userMap.get(id);
        user.setAge(age);
        user.setName(name);
        user.setAddress(address);
        user.setPhone(phone);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){

        userMap.remove(id);
    }
}
