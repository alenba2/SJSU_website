package com.example.sjsuwebsite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
    @Id
    public String id;
    public String username;
    public String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Users = { " +
                "Username: " + username + "\'" +
                "Password: " + password + " }";
    }
}
