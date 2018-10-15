package com.example.carmar04.spinnerclases;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    public static Titular[] datos = new Titular[]{
            new Titular("Titulo 1", "Subtitulo largo 1",R.drawable.img1),
            new Titular("Titulo 2", "Subtitulo largo 1",R.drawable.img2),
            new Titular("Titulo 3", "Subtitulo largo 1",R.drawable.img3)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptadorTitulares);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg1, View view, int position, long id) {
                String mensaje = "Titulo: " + datos[position].getTitulo() + " Subtitulo: " + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
 /*   class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        public AdaptadorTitulares(Activity context){
            super(context, R.layout.listitem_titular);
            this.context = context;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int i, View converView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular,null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.tvTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
            lblSubtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen = (ImageView) item.findViewById(R.id.tvImagen);
            imagen.setBackground(getDrawable(datos[i].getDrawable()));

            return item;
        }
    }*/
 class AdaptadorTitulares extends ArrayAdapter {
     Activity context;

     AdaptadorTitulares(Activity context) {
         super(context, R.layout.listitem_titular, datos);
         this.context = context;
     }

     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
     public View getView(int position, View convertView, ViewGroup parent) {
         LayoutInflater inflater = context.getLayoutInflater();
         View item = inflater.inflate(R.layout.listitem_titular, null);

         TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
         lblTitulo.setText(datos[position].getTitulo());

         TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
         lblSubtitulo.setText(datos[position].getSubtitulo());

         ImageView imagen = (ImageView) item.findViewById(R.id.tvImagen);
         imagen.setBackground(getDrawable(datos[position].getDrawable()));

         return (item);
     }
 }
}
