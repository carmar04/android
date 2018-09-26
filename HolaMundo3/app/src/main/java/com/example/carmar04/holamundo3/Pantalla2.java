package com.example.carmar04.holamundo3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView textView1 = (TextView) findViewById(R.id.myTextView2);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.myImgButton1);

        Bundle myBundle = getIntent().getExtras();
        textView1.setText(myBundle.getString("1st message"));

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pantalla2.this, Pantalla1.class);
                startActivity(intent);
            }
        });
    }
    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(Pantalla2.this, "A2: onStart", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onStart");

    }
    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(Pantalla2.this, "A2: onResume", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onResume");

    }
    @Override protected void onPause() {
        Toast.makeText(Pantalla2.this, "A2: onPause", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onPause");
        super.onPause();
        //miMusica.pause();
    }
    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(Pantalla2.this, "A2: onStop", Toast.LENGTH_SHORT).show();
        System.out.println("A2: onStop");
        //miMusica.stop();
    }
}
