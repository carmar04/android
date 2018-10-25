package com.example.carmar04.spinnerclases;

import java.io.Serializable;

public class Titular implements Serializable{
    private String titulo, subtitulo;
    private int drawable;

    public Titular(){
    }
    public Titular(String titulo, String subtitulo, int drawable){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.drawable = drawable;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setSubtitutlo(String subtitulo){
        this.subtitulo = subtitulo;
    }
    public String getSubtitulo(){
        return this.subtitulo;
    }
    public void setDrawable(int drawable){
        this.drawable = drawable;
    }
    public int getDrawable(){
        return this.drawable;
    }
    public String toString(){
        return "Titulo" + this.titulo + ", Subtitulo: " + this.subtitulo;
    }

}
