package com.example.thinkAndShare.controllers;

import com.example.thinkAndShare.models.Idea;
import com.example.thinkAndShare.models.Desafio;
import com.example.thinkAndShare.repositories.IdeaRepository;
import com.example.thinkAndShare.repositories.DesafioRepository;

import java.util.List;
import java.util.ArrayList;
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
    public Idea publicarIdea(String titulo, String descripcion, int idDesafio, String nombreIdeador) {
        Idea idea = new Idea(titulo, descripcion, idDesafio, nombreIdeador);
        return ideaRepository.save(idea);
    };

    @GetMapping("/ideas")
    public List<Idea> listarIdeas() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return ideaRepository.findAll(sortByCreatedAtDesc);
    };

    @GetMapping("/idea/{id}")
    public Idea obtenerIdea(@PathVariable String id) {
        return ideaRepository.findByid(id);
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

    @PostMapping("/{id}/megusta")
    public Idea darMeGustaIdea(@PathVariable String id) {
        Idea idea = ideaRepository.findByid(id);
        System.out.println(idea.getId());
        idea.setMeGusta(idea.getMeGusta() + 1);
        return ideaRepository.save(idea);
    }

    @PutMapping("/{id}/comentar")
    public Idea comentarIdea(@PathVariable String id, @RequestParam(value = "comentario")String comentario,
                            @RequestParam(value = "idIdeador")String idIdeador) {

        Idea idea = ideaRepository.findByid(id);
        ArrayList<ArrayList<String>> comentarios = idea.getComentarios();
        ArrayList<String> nuevoComentario = new ArrayList<String>();
        nuevoComentario.add(comentario);
        nuevoComentario.add(idIdeador);
        comentarios.add(nuevoComentario);
        idea.setComentarios(comentarios);
        return ideaRepository.save(idea);
    }

    @GetMapping("/ideas/filtrar/{termino}")
    public ArrayList<Idea> filtrarIdeas(@PathVariable String termino) {
        List<Idea> ideas = ideaRepository.findAll();
        ArrayList<Idea> ideasFiltradas = new ArrayList<Idea>();

        for (int i = 0; i < ideas.size(); i++) {
            if (ideas.get(i).getTitulo().contains(termino)) {
                ideasFiltradas.add(ideas.get(i));
            }
            else if (ideas.get(i).getDescripcion().contains(termino)) {
                ideasFiltradas.add(ideas.get(i));
            }
        }
        return ideasFiltradas;
    };

    // @GetMapping("/ideas/ordenar/{criterio}")
    // public ArrayList<Idea> ordenarIdeas(@PathVariable int criterio) {
    //     List<Idea> ideas = ideaRepository.findAll();
    //     ArrayList<Idea> ideasOrdenadas = new ArrayList<Idea>();
    //
    //     return ideasOrdenadas;
    // };

}
