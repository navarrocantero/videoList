package com.example.navarrocantero.youtubelist.model;

/**
 * Created by navarrocantero on 10/11/2018.
 */


public class Video {
    private String titulo;
    private String usuario;
    private String image;
    private String visitas;
    private String id;

    // Constructores

    public Video() {
    }

    // Accesores

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVisitas() {
        return visitas;
    }

    public void setViews(String visitas) {
        this.visitas = visitas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getTitulo() + ": " + getUsuario() + ". " + getVisitas();
    }
}
