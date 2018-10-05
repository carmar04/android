package com.example.carmar04.componentesbasicas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        //btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        chkBoxCycling.setOnCheckedChangeListener(new mia());
        chkBoxBlogging.setOnCheckedChangeListener(new mia());
        chkBoxTeaching.setOnCheckedChangeListener(new mia());

/*        btnHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });
    }
    public void getHobbyClick(View v){
        String mensaje = "";
        if(chkBoxTeaching.isChecked() == true){
            mensaje += "enseñar ";
        }
        if(chkBoxBlogging.isChecked() == true){
            mensaje += "bloguear ";
        }
        if(chkBoxCycling.isChecked() == true){
            mensaje += "pedalear ";
        }
        txtHobby.setText(mensaje); */
    }

    class mia implements CheckBox.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                String mensaje = "";
                if (chkBoxTeaching.isChecked()) {
                    mensaje += "enseñar ";
                }
                if (chkBoxBlogging.isChecked()) {
                    mensaje += "bloguear ";
                }
                if (chkBoxCycling.isChecked()) {
                    mensaje += "pedalear ";
                }

            txtHobby.setText(mensaje);
        }
    }
}
