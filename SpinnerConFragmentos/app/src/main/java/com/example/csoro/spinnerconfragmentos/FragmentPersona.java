package com.example.csoro.spinnerconfragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentPersona extends Fragment {

    Persona persona;

    static FragmentPersona newInstance(Persona persona){
        FragmentPersona fragmentPersona = new FragmentPersona();
        Bundle args = new Bundle();
        args.putSerializable("Persona", persona);
        fragmentPersona.setArguments(args);
        return fragmentPersona;
    }

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        persona = (Persona) getArguments().getSerializable("Persona");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View nombre_fragment;
        View edad_fragment;
        View descripcion_fragment;
        View imagen_fragment;
        View view = inflater.inflate(R.layout.fragment, container, false);
        nombre_fragment = view.findViewById(R.id.nombre_fragment_persona);
        edad_fragment = view.findViewById(R.id.edad_fragment_persona);
        descripcion_fragment = view.findViewById(R.id.descripcion_fragment_persona);
        imagen_fragment = view.findViewById(R.id.imagen_fragment_persona);

        ((TextView)nombre_fragment).setText(persona.getNombre());
        ((TextView)edad_fragment).setText(String.valueOf(persona.getEdad()));
        ((TextView)descripcion_fragment).setText(persona.getDescripcion());
        ((ImageView)imagen_fragment).setImageResource(persona.getImagen());

        return view;
    }
}
