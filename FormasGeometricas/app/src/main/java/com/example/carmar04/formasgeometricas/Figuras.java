package com.example.carmar04.formasgeometricas;

import java.io.Serializable;

public class Figuras implements Serializable {

    public int altura, base, imagen;
    public String forma;

    public Figuras(String forma, int altura, int base, int imagen){
        this.forma = forma;
        this.altura = altura;
        this.base = base;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
}
