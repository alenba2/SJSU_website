package com.example.sjsuwebsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.sjsuwebsite.model.History;

public interface HistoryRepository extends MongoRepository<History, String> {
}
