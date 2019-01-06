package com.example.csoro.ejerciciodosspinners;

public class Libros {

    public String nombre;
    public String editorial;
    public int año;

    public Libros(String nombre, String editorial, int año){
        this.nombre = nombre;
        this.editorial = editorial;
        this.año = año;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}
