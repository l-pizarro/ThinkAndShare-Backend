package com.example.thinkAndShare.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ideadores")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Ideador {
    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    private String run;

    @NotBlank
    @Size(max=100)
    private String nombre;

    @NotBlank
    @Size(max=200)
    private String correoAlaya;

    private String celular;
    private String telefono;
    private String facebook;
    private String linkedIn;
    private String instagram;

    private Date createdAt = new Date();

    public Ideador() {
        super();
    }

    public Ideador(String run, String nombre, String correoAlaya) {
        this.run = run;
        this.nombre = nombre;
        this.correoAlaya = correoAlaya;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCorreoAlaya() {
        return this.correoAlaya;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
