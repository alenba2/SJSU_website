package com.example.sjsuwebsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.sjsuwebsite.model.History;

import java.util.ArrayList;

public interface HistoryRepository extends MongoRepository<History, String> {
    public ArrayList<History> findAllByUsername(String name);
}