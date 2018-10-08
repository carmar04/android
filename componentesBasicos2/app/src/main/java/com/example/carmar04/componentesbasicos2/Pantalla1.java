package com.example.carmar04.componentesbasicos2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.R.color.holo_red_dark;

public class Pantalla1 extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        final Button button = (Button) findViewById(R.id.button12);
        rg.clearCheck();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /* lblMensaje.setText("Opcion seleccionada: " + checkedId); */

                String textoOpcion="";
                if(group.getCheckedRadioButtonId()==R.id.radio1){
                    lblMensaje.setText("Opcion selecionada: Opción 1");
                }
                if(group.getCheckedRadioButtonId()==R.id.radio2){
                    lblMensaje.setText("Opcion selecionada: Opción 2");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pantalla1.this, Nucleo.class);
                startActivity(intent);
            }
        });


    }
}
