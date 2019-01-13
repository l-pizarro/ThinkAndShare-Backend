package com.example.thinkAndShare.controllers;

import javax.validation.Valid;
import com.example.thinkAndShare.models.Idea;
import com.example.thinkAndShare.repositories.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InicioController {

    @Autowired
    IdeaRepository ideaRepository;

    @GetMapping("/ideas")
    public List<Idea> obtenerIdeas() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return ideaRepository.findAll(sortByCreatedAtDesc);
    };

    @PostMapping("/ideas")
    public Idea publicarIdea(String titulo, String descripcion, int idDesafio) {
        Idea idea = new Idea(titulo, descripcion, idDesafio);
        return ideaRepository.save(idea);
    };


}
