package com.example.apitest.domain;

import lombok.Data;

@Data
public class User {

    private Long id;

    private int age;

    private String name;
    private String address;
    private String phone;

    public User(Long id, int age, String name, String address, String phone) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
