package com.example.thinkAndShare.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Comentario {
    private String nombreIdeador;
    private String comentario;

    public Comentario() {
        super();
    }

    public Comentario(String nombreIdeador, String comentario) {
        this.nombreIdeador = nombreIdeador;
        this.comentario = comentario;
    }

    public String getNombreIdeador() {
        return this.nombreIdeador;
    }

    public String getComentario() {
        return this.comentario;
    }
}
