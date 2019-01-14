package com.example.thinkAndShare.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ideas")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Idea {
    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    private String titulo;

    @NotBlank
    @Size(max=280)
    private String descripcion;

    private int nota;
    private int meGusta;
    private int idDesafio;
    private int idIdeador;
    private int numeroComentarios;

    private Date createdAt = new Date();

    public Idea() {
        super();
    }

    public Idea(String titulo, String descripcion, int idDesafio) {
        this.nota = 0;
        this.titulo = titulo;
        this.meGusta = 0;
        this.idDesafio = idDesafio;
        this.descripcion = descripcion;
        this.numeroComentarios = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getMeGusta() {
        return this.meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getNumeroComentarios() {
        return this.numeroComentarios;
    }

    public void setNumeroComentarios(int numeroComentarios) {
        this.numeroComentarios = numeroComentarios;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
