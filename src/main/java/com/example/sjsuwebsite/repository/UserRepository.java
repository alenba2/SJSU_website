package com.example.sjsuwebsite.Repository;

import com.example.sjsuwebsite.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {
    public Boolean existsUsersByUsername(String username);
    public Boolean existsUsersByUsernameAndPassword(String username,String password);
}
