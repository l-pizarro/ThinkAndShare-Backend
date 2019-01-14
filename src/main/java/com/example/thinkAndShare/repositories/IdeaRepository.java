package com.example.thinkAndShare.repositories;

import com.example.thinkAndShare.models.Idea;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface IdeaRepository extends MongoRepository<Idea, String> {
    Idea findByid(String id);
}
