package com.example.carmar04.ejemplocanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        public MiDibujo(Context c){

            super(c);
        }

        protected void onDraw(Canvas lienzo){

            Paint miPincel= new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStyle(Paint.Style.STROKE);

            int anchura = getWidth();
            int altura = getHeight();
            for(int  i = 0;i < getWidth(); i++){
                lienzo.drawCircle(500,500,300,miPincel);
            }



        }
    }

}
