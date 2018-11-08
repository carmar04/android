package com.example.carmar04.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    TextView etiqueta;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        etiqueta = (TextView) findViewById(R.id.etiqueta);
        imageView = (ImageView) findViewById(R.id.imageView);

        registerForContextMenu(imageView);
        registerForContextMenu(etiqueta);
    }
    //para crear menus en la parte de arriba de la aplicación
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflate  = getMenuInflater();
        inflate.inflate(R.menu.menu_principal, menu);
        return true;
    }
    //recoge los valores por tocar los diferentes botones del menú
    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje = "";
        switch (item.getItemId()){
            case R.id.MenuOpc1:
                mensaje = "Opción 1: Ayuda";
                etiqueta.setText(mensaje.toString());
                Toast.makeText(getApplicationContext(), "Opción 1 : Ayuda", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MenuOpc2:
                mensaje = "Opción 2: Copyright";
                etiqueta.setText(mensaje.toString());
                Toast.makeText(getApplicationContext(), "Opción 2 : Copyright", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MenuOpc3:
                mensaje = "Opción 1: Más";
                etiqueta.setText(mensaje.toString());
                Toast.makeText(getApplicationContext(), "Opción 3 :Más", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //para crear menus contextuales
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu, v, menuinfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_imagenes, menu);
    }
}
