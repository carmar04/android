package com.example.carmar04.spinnerclases;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView titulo = (TextView) findViewById(R.id.titulo2);
        TextView subtitulo = (TextView) findViewById(R.id.subtitulo2);
        ImageView imagen = (ImageView) findViewById(R.id.imagen2);

        Intent intent = getIntent();

        Titular titular = (Titular) getIntent().getSerializableExtra("Objeto");
        Toast.makeText(getApplicationContext(), titular.toString(), Toast.LENGTH_SHORT).show();
        titulo.setText(titular.getTitulo());
        subtitulo.setText(titular.getSubtitulo());
        imagen.setBackground(getDrawable(titular.getDrawable()));
    }
}
