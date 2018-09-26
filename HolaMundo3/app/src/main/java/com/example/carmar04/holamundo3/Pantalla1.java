package com.example.carmar04.holamundo3;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Console;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.the_trashmen);
        miMusica.start();

        final TextView textView1 = (TextView) findViewById(R.id.myTextView1);
        final EditText editText1 = (EditText) findViewById(R.id.myEditText1);
        Button button1 = (Button) findViewById(R.id.myButton1);

        button1.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Bundle myBundle = new Bundle();
                String message = "Te saludo " + editText1.getText();
                Intent intent = new Intent(Pantalla1.this, Pantalla2.class);
                textView1.setText("");
                editText1.setText("");
                myBundle.putString("1st message", message);

                intent.putExtras(myBundle);
                startActivity(intent);


            }
        });

    }
    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(Pantalla1.this, "A1: onStart", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onStart");
    }
    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(Pantalla1.this, "A1: onResume", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onResume");
    }
    @Override protected void onPause() {
        Toast.makeText(Pantalla1.this, "A1: onPause", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onPause");
        super.onPause();
    }
    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(Pantalla1.this, "A1: onStop", Toast.LENGTH_SHORT).show();
        System.out.println("A1: onStop");
    }
}
