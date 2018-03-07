package com.peterfarber.main.core;

import java.util.UUID;

public class User {


    private final String id;
    private final String name;
    private final String username;
    private String password;

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void save(){

    }

    public void delete(){

    }


}
