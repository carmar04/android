package com.example.carmar04.figurasaleatorias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
    }
    public void launchDrawShape1(View clickedButton){
        Intent activityIntent = new Intent(this, Pantalla2.class);
        startActivity(activityIntent);
    }
    public void launchDrawShape2(View clickedButton){
        Intent activityIntent = new Intent(this, Pantalla3.class);
        startActivity(activityIntent);
    }
}
