package com.example.carmar04.fragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Pantalla1 extends AppCompatActivity {
    View miFragmento;
    Button apareceFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        miFragmento = (View) findViewById(R.id.ejemplo);
        apareceFrag = (Button) findViewById(R.id.checkFrag);

        apareceFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miFragmento.getVisibility() == View.INVISIBLE){
                    apareceFrag.setText("Desaparece");
                    miFragmento.setVisibility(View.VISIBLE);

                }else{
                    miFragmento.setVisibility(View.INVISIBLE);
                    apareceFrag.setText("Aparece");
                }
            }
        });
    }
}
