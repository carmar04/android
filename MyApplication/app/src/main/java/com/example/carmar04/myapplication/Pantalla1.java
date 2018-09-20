package com.example.carmar04.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        final EditText miTexto = (EditText)findViewById(R.id.miTxt);
        final Button miBoton = (Button)findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView)findViewById(R.id.miLbl);

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Bundle myBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                Intent mio = new Intent(Pantalla1.this, Pantalla2.class);
                elSaludo.setText("");
                miTexto.setText("");
                myBundle.putString("TEXTO", mensajePaso);

                mio.putExtras(myBundle);
                startActivity(mio);
            }
        });
        Toast.makeText(this, "esto es un TOAST",Toast.LENGTH_LONG).show();
        //new AlertDialog.Builder(this).setMessage("el texto").setPositiveButton(android.R.string.ok, null).show();
    }
}

