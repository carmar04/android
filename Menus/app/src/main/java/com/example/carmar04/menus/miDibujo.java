package com.example.carmar04.menus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class miDibujo extends View {

    public miDibujo(Context context) {
        super(context);
    }
    protected void onDraw(Canvas lienzo) {
        Paint mipincel = new Paint();
        mipincel.setColor(Color.RED);
        mipincel.setStyle(Paint.Style.FILL_AND_STROKE);
        lienzo.drawCircle(530, 525, 300, mipincel);
    }
}
