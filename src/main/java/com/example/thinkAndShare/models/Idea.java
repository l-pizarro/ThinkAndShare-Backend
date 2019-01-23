package com.example.thinkAndShare.models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
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
    private String idDesafio;
    private int idIdeador;
    private String nombreIdeador;
    private int numeroComentarios;
    private ArrayList<ArrayList<String>> comentarios;

    private Date createdAt = new Date();

    public Idea() {
        super();
    }

    public Idea(String titulo, String descripcion, String idDesafio, String nombreIdeador) {
        this.nota = 0;
        this.titulo = titulo;
        this.meGusta = 0;
        this.idDesafio = idDesafio;
        this.descripcion = descripcion;
        this.numeroComentarios = 0;
        this.nombreIdeador = nombreIdeador;
        this.comentarios = new ArrayList<ArrayList<String>>();
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

    public String getNombreIdeador() {
        return this.nombreIdeador;
    }

    public void setNombreIdeador(String nombreIdeador) {
        this.nombreIdeador = nombreIdeador;
    }

    public int getNumeroComentarios() {
        return this.numeroComentarios;
    }

    public void setNumeroComentarios(int numeroComentarios) {
        this.numeroComentarios = numeroComentarios;
    }

    public ArrayList<ArrayList<String>> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(ArrayList<ArrayList<String>> comentarios) {
        this.comentarios = comentarios;
    }

    public String getIdDesafio() {
        return this.idDesafio;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
