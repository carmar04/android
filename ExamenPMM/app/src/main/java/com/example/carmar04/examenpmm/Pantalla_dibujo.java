package com.example.carmar04.examenpmm;

import android.content.Context;
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

public class Pantalla_dibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new miDibujo(this));
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
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        protected void onDraw(Canvas lienzo) {
            Paint rueda = new Paint();
            rueda.setColor(Color.BLACK);
            rueda.setStyle(Paint.Style.FILL_AND_STROKE);

            lienzo.drawCircle(400, 600, 100, rueda);
            lienzo.drawCircle(700, 600, 100, rueda);

            Paint coche = new Paint();
            coche.setColor(Color.GRAY);
            coche.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawRect(200, 400, 900, 600, coche);

            lienzo.drawRect(400, 200, 700, 600, coche);

            lienzo.drawOval(150, 500, 200, 400, rueda);

            Paint cristales = new Paint();
            cristales.setColor(Color.WHITE);
            cristales.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawRect(450, 220, 680, 350, cristales);
        }
    }
    public static void reDraw(View v){
        v.invalidate();
    }
}
