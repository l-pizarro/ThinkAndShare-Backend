package com.example.thinkAndShare.controllers;

import com.example.thinkAndShare.models.Idea;
import com.example.thinkAndShare.models.Desafio;
import com.example.thinkAndShare.requests.Comentario;
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
    public Idea publicarIdea(@Valid @RequestBody Idea idea) {
        Idea nuevaIdea = new Idea(idea.getTitulo(), idea.getDescripcion(), idea.getIdDesafio(), idea.getNombreIdeador());
        return ideaRepository.save(nuevaIdea);
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
    public Desafio publicarDesafio(@Valid @RequestBody Desafio desafio) {
        Desafio nuevoDesafio = new Desafio(desafio.getTitulo(), desafio.getDescripcion(), desafio.getInicio(), desafio.getTermino());
        return desafioRepository.save(nuevoDesafio);
    };

    @GetMapping("/desafios")
    public List<Desafio> listarDesafios() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return desafioRepository.findAll(sortByCreatedAtDesc);
    };

    @GetMapping("/desafio/{id}")
    public Desafio obtenerDesafio(@PathVariable String id) {
        return desafioRepository.findByid(id);
    };

    @PostMapping("/{id}/megusta")
    public Idea darMeGustaIdea(@PathVariable String id) {
        Idea idea = ideaRepository.findByid(id);
        idea.setMeGusta(idea.getMeGusta() + 1);
        return ideaRepository.save(idea);
    }

    @PostMapping("/{id}/comentar")
    public Idea comentarIdea(@PathVariable String id, @Valid @RequestBody Comentario request) {
        Idea idea = ideaRepository.findByid(id);
        ArrayList<ArrayList<String>> comentarios = idea.getComentarios();
        ArrayList<String> nuevoComentario = new ArrayList<String>();
        nuevoComentario.add(request.getComentario());
        nuevoComentario.add(request.getNombreIdeador());
        comentarios.add(nuevoComentario);
        idea.setComentarios(comentarios);
        idea.setNumeroComentarios(idea.getNumeroComentarios()+1);
        return ideaRepository.save(idea);
    }

    @GetMapping("/ideas/filtrar/{termino}")
    public ArrayList<Idea> filtrarIdeas(@PathVariable String termino) {
        List<Idea> ideas = ideaRepository.findAll();
        ArrayList<Idea> ideasFiltradas = new ArrayList<Idea>();

        for (int i = 0; i < ideas.size(); i++) {
            if (ideas.get(i).getTitulo().toLowerCase().contains(termino.toLowerCase())) {
                ideasFiltradas.add(ideas.get(i));
            }
            else if (ideas.get(i).getDescripcion().toLowerCase().contains(termino.toLowerCase())) {
                ideasFiltradas.add(ideas.get(i));
            }
        }
        return ideasFiltradas;
    };

    @GetMapping("/ideas/ordenar/{criterio}")
    public List<Idea> ordenarIdeas(@PathVariable int criterio) {
        Sort ordenamiento = new Sort(Sort.Direction.DESC, "createdAt");

        if (criterio == 1) {
            ordenamiento = new Sort(Sort.Direction.DESC, "meGusta");
        }
        else if (criterio == 2) {
            ordenamiento = new Sort(Sort.Direction.DESC, "numeroComentarios");
        }
        else if (criterio == 3) {
            ordenamiento = new Sort(Sort.Direction.ASC, "createdAt");
        }

        return ideaRepository.findAll(ordenamiento);
    };

    @GetMapping("/desafios/filtrar/{termino}")
    public ArrayList<Desafio> filtrarDesafios(@PathVariable String termino) {
        List<Desafio> desafios = desafioRepository.findAll();
        ArrayList<Desafio> desafiosFiltrados = new ArrayList<Desafio>();

        for (int i = 0; i < desafios.size(); i++) {
            if (desafios.get(i).getTitulo().toLowerCase().contains(termino.toLowerCase())) {
                desafiosFiltrados.add(desafios.get(i));
            }
            else if (desafios.get(i).getDescripcion().toLowerCase().contains(termino.toLowerCase())) {
                desafiosFiltrados.add(desafios.get(i));
            }
        }
        return desafiosFiltrados;
    };

    @GetMapping("/desafios/ordenar/{criterio}")
    public List<Desafio> ordenarDesafios(@PathVariable int criterio) {
        Sort ordenamiento = new Sort(Sort.Direction.DESC, "createdAt");

        if (criterio == 1) {
            ordenamiento = new Sort(Sort.Direction.ASC, "createdAt");
        }

        return desafioRepository.findAll(ordenamiento);
    };

}
