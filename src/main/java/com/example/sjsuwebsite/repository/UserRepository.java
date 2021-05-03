package com.example.sjsuwebsite.repository;

import com.example.sjsuwebsite.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {
    public Boolean existsUsersByUsername(String username);
    public Boolean existsUsersByUsernameAndPassword(String username,String password);
    //public void changePassword(String username, String password, String newPassword);
}
