package com.example.carmar04.formasgeometricas;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {
    String forma = "";
    int base = 0;
    int altura = 0;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DibujarFiguras(this));

        Intent intent = getIntent();
        Figuras figuras = (Figuras) intent.getSerializableExtra("Objeto");

        forma = figuras.getForma();
        base = figuras.getBase();
        altura = figuras.getAltura();

    }
    class DibujarFiguras extends View {
        private ShapeDrawable miDrawable;

        public DibujarFiguras(Context c) {
            super(c);
        }

        public DibujarFiguras(Context c, AttributeSet a){
            super(c, a);
        }

        protected void onDraw(Canvas lienzo) {

            Paint mipincel = new Paint();
            mipincel.setColor(Color.BLACK);
            mipincel.setStyle(Paint.Style.FILL_AND_STROKE);
            mipincel.setTextSize(60);

            if(forma.equalsIgnoreCase("Triangulo")){
                Path path = new Path();
                path.moveTo(500, 400);
                path.lineTo(250, 800);
                path.lineTo(750, 800);
                lienzo.drawPath(path, mipincel);

                mipincel.setTextSize(60);
                lienzo.drawText(forma, 380, 1000, mipincel);
                String mensaje = "Area:  " + ((base * altura) / 2);
                lienzo.drawText(mensaje, 380, 1150, mipincel);

            }else if(forma.equalsIgnoreCase("Cuadrado")){
                lienzo.drawRect(300,400, 700, 800, mipincel);
                mipincel.setTextSize(60);
                lienzo.drawText(forma, 380, 1000, mipincel);
                String mensaje = "Area:  " + (base * base);
                lienzo.drawText(mensaje, 380, 1150, mipincel);
            }else{
                lienzo.drawRect(200 , 400, 900, 800, mipincel);
                mipincel.setTextSize(60);
                lienzo.drawText(forma, 380, 1000, mipincel);
                String mensaje = "Area:  " + (base * altura);
                lienzo.drawText(mensaje, 380, 1150, mipincel);
            }

        }
    }
    public static void reDraw(View v){
        v.invalidate();
    }
}

