package com.example.thinkAndShare.repositories;

import com.example.thinkAndShare.models.Desafio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRepository extends MongoRepository<Desafio, String> {
    Desafio findByid(String id);
}
