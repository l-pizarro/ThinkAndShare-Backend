package com.example.thinkAndShare.repositories;

import com.example.thinkAndShare.models.Ideador;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface IdeadorRepository extends MongoRepository<Ideador, String> {
    Ideador findByid(String id);
}
