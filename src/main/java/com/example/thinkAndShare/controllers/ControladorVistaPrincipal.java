package com.example.thinkAndShare.controllers;

import javax.validation.Valid;
import com.example.thinkAndShare.models.Idea;
import com.example.thinkAndShare.models.Desafio;
import com.example.thinkAndShare.repositories.IdeaRepository;
import com.example.thinkAndShare.repositories.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ControladorVistaPrincipal {

    @Autowired
    IdeaRepository ideaRepository;

    @Autowired
    DesafioRepository desafioRepository;

    @PostMapping("/ideas")
    public Idea publicarIdea(String titulo, String descripcion, int idDesafio) {
        Idea idea = new Idea(titulo, descripcion, idDesafio);
        return ideaRepository.save(idea);
    };

    @GetMapping("/ideas")
    public List<Idea> listarIdeas() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return ideaRepository.findAll(sortByCreatedAtDesc);
    };


    @PostMapping("/desafios")
    public Desafio publicarDesafio(String titulo, String descripcion, String inicio, String termino) {
        Desafio desafio = new Desafio(titulo, descripcion, inicio, termino);
        return desafioRepository.save(desafio);
    };

    @GetMapping("/desafios")
    public List<Desafio> listarDesafios() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return desafioRepository.findAll(sortByCreatedAtDesc);
    };

}
