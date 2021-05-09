package com.example.sjsuwebsite.model;

import com.example.sjsuwebsite.Item;
import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class Users {
    @Id
    public String id;
    public String username;
    public String password;
//    public String oldPassword;
    public String newPassword;

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

    public void setPassword(String password) { this.password = password; }

//    public String getOldPassword() { return oldPassword; }
//
    public String getNewPassword() { return newPassword; }

//    public void setOldPassword(String oldPassword) {  this.oldPassword = oldPassword; }

    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    @Override
    public String toString(){
        return "Users = { " +
                "Username: " + username + "\t" +
                "Password: " + password + " }";
    }
}
