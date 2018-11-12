package com.example.carmar04.examenpmm;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pantalla_imagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_imagen);

        ImageView imageView = (ImageView) findViewById(R.id.imagen23);
        registerForContextMenu(imageView);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu, v, menuinfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public boolean onContextItemSelected(MenuItem item) {
        // Previamente creamos el objeto TextView y lo inicializamos para poder
        // asignarle aquí el texto en función de la opción seleccionada.
        if(item.getItemId() == R.id.imagen23){
            Toast.makeText(getApplicationContext(), "Acerca De: @Carles Soro" , Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return true;
        }
    }
}
