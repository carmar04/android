package com.example.carmar04.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    Spinner miSpinner1;
    Spinner miSpinner2;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    final static String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        String mensaje;
        miSpinner1 = (Spinner) findViewById(R.id.spinner1);
        miSpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> miAdaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, semana);
        ArrayAdapter<String> miAdaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, meses);

        miAdaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); /* MIRAR BIEN( es diferente al ListaView) */
        miSpinner1.setAdapter(miAdaptador1);
        miSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*evento distinto al ListView */
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + semana[position];
                showToast(mensaje);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        miAdaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner2.setAdapter(miAdaptador2);
        miSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + meses[position];
                showToast(mensaje);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
