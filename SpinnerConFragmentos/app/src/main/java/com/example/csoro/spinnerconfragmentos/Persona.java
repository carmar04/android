package com.example.csoro.spinnerconfragmentos;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre;
    int edad;
    String descripcion;
    int imagen;

    public Persona(String nombre, int edad, String descripcion, int imagen){
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
