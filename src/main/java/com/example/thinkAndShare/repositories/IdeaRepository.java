package com.example.thinkAndShare.repositories;

import com.example.thinkAndShare.models.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends MongoRepository<Idea, String> {

}
