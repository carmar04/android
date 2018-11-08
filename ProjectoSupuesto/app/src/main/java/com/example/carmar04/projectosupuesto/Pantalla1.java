package com.example.carmar04.projectosupuesto;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pantalla1 extends AppCompatActivity {

    private Zona[] zona = new Zona[]{
            new Zona("Asia", "China", 20,0,"", false, false, R.drawable.paquete),
            new Zona("Africa", "Uganda", 30,0, "",false, false, R.drawable.paquete),
            new Zona("America", "Ohio", 10,0, "",false, false, R.drawable.paquete)
    };
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorZonas miAdaptador = new AdaptadorZonas(this);
        spinner.setAdapter(miAdaptador);
    }
    class AdaptadorZonas extends ArrayAdapter{
        Activity context;

        AdaptadorZonas(Activity context){
            super(context, R.layout.listzonas, zona);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listzonas, null);

            TextView continente = (TextView) item.findViewById(R.id.continente);
            TextView nombre = (TextView) item.findViewById(R.id.zona);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);

            continente.setText(zona[position].getContinente());
            nombre.setText(zona[position].getNombre());
            precio.setText(String.valueOf(zona[position].getPrecio()));
            imagen.setBackground(getDrawable(zona[position].getImagen()));

            return item;
        }
    }
}
