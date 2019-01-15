package com.example.thinkAndShare.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ComentarioRequest {
    private String nombreIdeador;
    private String comentario;

    public ComentarioRequest() {
        super();
    }

    public ComentarioRequest(String nombreIdeador, String comentario) {
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
