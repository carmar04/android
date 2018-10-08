package com.example.carmar04.animaciones_transiciones;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Pantalla1 extends AppCompatActivity {

    ImageView imagen;
    TransitionDrawable transicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

            imagen = (ImageView) findViewById(R.id.img);

            transicion = (TransitionDrawable)getResources().getDrawable(R.drawable.transicion);
            imagen.setImageDrawable(transicion);
            transicion.startTransition(2000);
    }
}
