package com.example.thinkAndShare.models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="desafios")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Desafio {
    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    private String titulo;

    @NotBlank
    @Size(max=280)
    private String descripcion;

    private Date inicio = new Date();
    private Date termino = new Date();
    private Date createdAt = new Date();

    public Desafio() {
        super();
    }

    public Desafio(String titulo, String descripcion, String inicio, String termino) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        try {
            this.inicio = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
            this.inicio = new SimpleDateFormat("dd/MM/yyyy").parse(termino);
        }
        catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto");
        }
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
