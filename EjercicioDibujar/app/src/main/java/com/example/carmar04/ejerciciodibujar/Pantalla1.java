package com.example.carmar04.ejerciciodibujar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new miDibujo(this));
        Toast.makeText(this, "Dibujar Circulo", Toast.LENGTH_SHORT).show();
        //view = (View) findViewById(R.id.vista);

        //reDraw(view);
    }
    class miDibujo extends View {
        private ShapeDrawable miDrawable;

        public miDibujo(Context c) {
            super(c);
        }

        public miDibujo(Context c, AttributeSet a){
            super(c, a);
        }

        protected void onDraw(Canvas lienzo) {
            Paint mipincel = new Paint();
            mipincel.setColor(Color.RED);
            mipincel.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 300, mipincel);

            Paint mipincel3 = new Paint();
            mipincel3.setColor(Color.GRAY);
            mipincel3.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 250, mipincel3);

            Paint mipincel4 = new Paint();
            mipincel4.setColor(Color.RED);
            mipincel4.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 200, mipincel4);

            Paint mipincel5 = new Paint();
            mipincel5.setColor(Color.GRAY);
            mipincel5.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 150, mipincel5);

            Paint mipincel6 = new Paint();
            mipincel6.setColor(Color.RED);
            mipincel6.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 100, mipincel6);

            Paint mipincel7 = new Paint();
            mipincel7.setColor(Color.GRAY);
            mipincel7.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 50, mipincel7);

            Paint mipincel8 = new Paint();
            mipincel8.setColor(Color.RED);
            mipincel8.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(530, 525, 10, mipincel8);

            mipincel.setTextSize(60);
            lienzo.drawText("MI CIRCULO", 280, 1300, mipincel);
            String mensaje = "Ancho: " + getWidth() + " Alto: " + getHeight();
            lienzo.drawText(mensaje, 200, 1500, mipincel);
            Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();

            //int x = 500; int y = 1300;
            //int ancho = 300, alto = 500;
            //miDrawable = new ShapeDrawable(new OvalShape());

            Paint mipincel2 = new Paint();
            mipincel2.setColor(Color.BLACK);
            mipincel2.setStyle(Paint.Style.FILL_AND_STROKE);

            lienzo.drawRect(100,100,850,200, mipincel2);
            lienzo.drawRect(850,100,950,850, mipincel2);
            lienzo.drawRect(100,100,200,950, mipincel2);
            lienzo.drawRect(100,850,950,950, mipincel2);
        }
    }
    public static void reDraw(View v){
        v.invalidate();
    }
}
