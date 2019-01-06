package com.example.csoro.ejerciciodosspinners;

public class Autores {

    public String nombre;
    public int edad;
    public int num_libros;

    public Autores(String nombre, int edad, int num_libros){
        this.nombre = nombre;
        this.edad = edad;
        this.num_libros = num_libros;
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

    public int getNum_libros() {
        return num_libros;
    }

    public void setNum_libros(int num_libros) {
        this.num_libros = num_libros;
    }

}
