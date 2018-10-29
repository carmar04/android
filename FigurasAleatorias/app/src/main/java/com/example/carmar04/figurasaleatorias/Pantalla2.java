package com.example.carmar04.figurasaleatorias;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pantalla2 extends AppCompatActivity {

    private RandomShapeView mDrawingArea;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        mDrawingArea = (RandomShapeView) findViewById(R.id.drawing_area);
    }
    public void redraw(View clickedButton){
        mDrawingArea.invalidate();
    }
}
