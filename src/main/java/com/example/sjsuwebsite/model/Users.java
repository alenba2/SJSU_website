package com.example.sjsuwebsite.model;

import com.example.sjsuwebsite.Item;
import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Document(collection = "users")
public class Users {
    @Id
    public String id;
    public String username;
    public String password;
    public String newPassword;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     */
    public Users() {

    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * @return
     */
    public String getNewPassword() { return newPassword; }

    /**
     * @param newPassword
     */
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    @Override
    public String toString(){
        return "Users = { " +
                "Username: " + username + "\t" +
                "Password: " + password + " }";
    }
}
