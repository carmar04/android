package com.example.csoro.ejerciciodosspinners;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {

    Spinner spinnerAutores;
    Spinner spinnerLibros;
    int indice;

    Autores[] autores = new Autores[]{
            new Autores("Perez Reverte", 50, 7),
            new Autores("Markus Zuzak", 45, 5),
            new Autores("Jhon Boyne", 60, 4),
            new Autores("Reyes Monforte", 34, 10)
    };

    Libros[][] libros = new Libros[][]{

            {new Libros("España", "Espasa", 1987), new Libros("Sueño de una noche", "planeta", 2014)},
            {new Libros("Filosofia", "Critica", 1999), new Libros("El hombre", "Critica", 2015)},
            {new Libros("El niño con el pijama de rallas", "Critica", 2016), new Libros("El hombre en la cima de la montaña", "planeta", 2007)},
            {new Libros("Un burka por amor", "Agostini", 1990), new Libros("amor cruel", "el pais", 2018)}
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        spinnerAutores = (Spinner) findViewById(R.id.spinnerAutores);
        AdaptadorAutores adaptadorAutores = new AdaptadorAutores(this);
        spinnerAutores.setAdapter(adaptadorAutores);
        spinnerAutores.setSelection(-1);
        spinnerAutores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                indice = pos;
                spinnerLibros.setSelection(-1);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerLibros = (Spinner) findViewById(R.id.spinnerLibros);
        AdaptadorLibros adaptadorLibros = new AdaptadorLibros(this);
        spinnerLibros.setAdapter(adaptadorLibros);
        spinnerLibros.setSelection(-1);

    }
    class AdaptadorAutores extends ArrayAdapter {
        Activity context;
        AdaptadorAutores(Activity context){
            super(context, R.layout.spinner_autores, autores);
            this.context = context;

        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.spinner_autores, null);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            TextView edad = (TextView) item.findViewById(R.id.edad);
            TextView libros = (TextView) item.findViewById(R.id.libros);

            nombre.setText(autores[position].getNombre());
            edad.setText(String.valueOf(autores[position].getEdad()));
            libros.setText(String.valueOf(autores[position].getNum_libros()));
            return item;
        }
    }
    class AdaptadorLibros extends ArrayAdapter {
        Activity context;
        AdaptadorLibros(Activity context){
            super(context, R.layout.spinner_libros, libros[indice]);
            this.context = context;

        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.spinner_libros, null);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            TextView año = (TextView) item.findViewById(R.id.año);
            TextView editorial = (TextView) item.findViewById(R.id.editorial);

            nombre.setText(libros[indice][position].getNombre());
            año.setText(String.valueOf(libros[indice][position].getAño()));
            editorial.setText(libros[indice][position].getEditorial());
            return item;
        }
    }
}
