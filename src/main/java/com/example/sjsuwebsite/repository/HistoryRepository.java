package com.example.sjsuwebsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.sjsuwebsite.model.History;

import java.util.List;

public interface HistoryRepository extends MongoRepository<History, String> {
    List<History> findByUsername(String username);
}
