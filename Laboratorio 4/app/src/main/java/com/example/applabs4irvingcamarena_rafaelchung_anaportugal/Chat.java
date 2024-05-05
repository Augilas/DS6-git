package com.example.applabs4irvingcamarena_rafaelchung_anaportugal;

public class Chat {
    private String titulo;
    private String subtitulo;
    private String nota;

    public Chat(String titulo, String subtitulo, String nota) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.nota = nota;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getSubtitulo() {
        return subtitulo;
    }

    public String getNota() {
        return nota;
    }
}

