package com.example.sjsuwebsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.sjsuwebsite.model.History;
import java.util.ArrayList;

/**
 * Repository for interacting with Mongodb for History class
 */
public interface HistoryRepository extends MongoRepository<History, String> {
    /**
     *
     * @param name
     * takes in String name
     *
     * @return
     * returns and ArrayList based on the name
     */
    public ArrayList<History> findAllByUsername(String name);
}
