package com.example.thinkAndShare.controllers;

import com.example.thinkAndShare.models.Idea;
import com.example.thinkAndShare.models.Desafio;
import com.example.thinkAndShare.repositories.IdeaRepository;
import com.example.thinkAndShare.repositories.DesafioRepository;

import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
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

    @PutMapping("/{id}/megusta")
    public Idea darMeGustaIdea(@PathVariable String id) {
        Idea idea = ideaRepository.findByid(id);
        System.out.println(idea.getId());
        idea.setMeGusta(idea.getMeGusta() + 1);
        return ideaRepository.save(idea);
    }

    @PutMapping("/{id}/comentar")
    public Idea comentarIdea(@PathVariable String id, String comentario) {
        Idea idea = ideaRepository.findByid(id);
        idea.setNumeroComentarios(idea.getNumeroComentarios() + 1);
        return ideaRepository.save(idea);
    }
}
