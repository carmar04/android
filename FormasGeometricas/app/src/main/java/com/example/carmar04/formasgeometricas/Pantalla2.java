package com.example.carmar04.formasgeometricas;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Intent intent = getIntent();
        Figuras figuras = (Figuras) intent.getSerializableExtra("Objeto");

        TextView textView = (TextView) findViewById(R.id.textoFiguras);
        ImageView imageView = (ImageView) findViewById(R.id.imagenFiguras);

        textView.setText(figuras.getForma());
        imageView.setBackground(getDrawable(figuras.getImagen()));
    }
}
