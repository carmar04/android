package com.example.csoro.spinnerconfragmentos;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
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

    int indice;

    Persona persona;

    Spinner spinner_personas;

    Persona [] personas = new Persona[]{
            new Persona("Matt Damon", 50, "Actor inglés, originariamente dedicado a la peliculas de acción", R.drawable.mattdaemon),
            new Persona("Michael Fassbender", 45, "Actor aleman que ha protagonizado diversas peliculas de la saga Aliens", R.drawable.michaelfassbender),
            new Persona("Tom Hanks", 60, "Actor estadounidense que ha participado en multitud de rodajes y repartos", R.drawable.tomhanks)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        spinner_personas = (Spinner) findViewById(R.id.spinnerPersonas);
        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(this);
        spinner_personas.setAdapter(adaptadorPersonas);
        spinner_personas.setSelection(0);
        spinner_personas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice = position;
                addFragment();
            }

            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
    void addFragment(){
        FragmentPersona fragmentPersona = FragmentPersona.newInstance(personas[indice]);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment1, fragmentPersona);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("Persona", personas[indice]);
    }

    public class AdaptadorPersonas extends ArrayAdapter{
        Activity context;
        AdaptadorPersonas(Activity context){
            super(context, R.layout.spinner_personas, personas);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.spinner_personas, null);

            TextView nombre_persona = (TextView) item.findViewById(R.id.nombre_persona);
            TextView edad_persona = (TextView) item.findViewById(R.id.edad_persona);
            ImageView imagen_persona = (ImageView) item.findViewById(R.id.imagen_persona);

            nombre_persona.setText(personas[position].getNombre());
            edad_persona.setText(String.valueOf(personas[position].getEdad()));
            imagen_persona.setImageDrawable(getDrawable(personas[position].getImagen()));

            return item;
        }
    }
}
