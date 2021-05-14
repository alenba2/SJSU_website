package com.example.sjsuwebsite.repository;

import com.example.sjsuwebsite.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository with the Mongodb for User Class
 */
public interface UserRepository extends MongoRepository<Users, String> {
    /**
     * @param username
     * gets username
     * @return
     * pushes a boolean variable depending if the username exists in the database
     */
    public Boolean existsUsersByUsername(String username);

    /**
     * @param username
     * gets username
     * @param password
     * gets password
     * @return
     * pushes a boolean variable depending if the username and the password exists in the database
     */
    public Boolean existsUsersByUsernameAndPassword(String username,String password);
}
