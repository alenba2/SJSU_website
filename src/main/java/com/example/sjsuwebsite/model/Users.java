package com.example.sjsuwebsite.model;

import com.example.sjsuwebsite.Item;
import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Model
 *
 * This class is supposed to hold the user's information when they first sign up
 */
@Document(collection = "users")
public class Users {
    @Id
    public String id;
    public String username;
    public String password;
    public String newPassword;

    /**
     * @param username
     *
     * Sets the user's username
     *
     * @param password
     *
     * Sets the user's password
     */
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Initializes as an empty user
     */
    public Users(){

    }

    /**
     * @return
     *
     * Puts out the User's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return
     *
     * return the user's current password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *
     * changes the current user's password to the new password
     */
    public void setPassword(String password) { this.password = password; }


}
