package com.example.carmar04.spinnerclases;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
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
            new Titular("Titulo 3", "Subtitulo largo 1",R.drawable.img3),
            new Titular("Titulo 1", "Subtitulo largo 1",R.drawable.img1),
            new Titular("Titulo 2", "Subtitulo largo 1",R.drawable.img2),
            new Titular("Titulo 3", "Subtitulo largo 1",R.drawable.img3),
            new Titular("Titulo 1", "Subtitulo largo 1",R.drawable.img1),
            new Titular("Titulo 2", "Subtitulo largo 1",R.drawable.img2),
            new Titular("Titulo 3", "Subtitulo largo 1",R.drawable.img3)
    };
    Titular tit;
    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView image;
    }
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

                tit = new Titular(
                        datos[position].getTitulo(),
                        datos[position].getSubtitulo(),
                        datos[position].getDrawable());
                Intent intent = new Intent(Pantalla1.this, Pantalla2.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("Objeto", tit);

                intent.putExtras(bundle);
                startActivity(intent);

            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
 class AdaptadorTitulares extends ArrayAdapter {
     Activity context;

     AdaptadorTitulares(Activity context) {
         super(context, R.layout.listitem_titular, datos);
         this.context = context;
     }

     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
     public View getView(int position, View convertView, ViewGroup parent) {
         View item = convertView;
         ViewHolder holder;
         if(item == null) {
             LayoutInflater inflater = context.getLayoutInflater();
             item = inflater.inflate(R.layout.listitem_titular, null);

             holder = new ViewHolder();
             holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
             holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
             holder.image = (ImageView)item.findViewById(R.id.tvImagen);

             item.setTag(holder);
         }else{
             holder = (ViewHolder)item.getTag();
         }
         holder.titulo.setText(datos[position].getTitulo());
         holder.subtitulo.setText(datos[position].getSubtitulo());
         holder.image.setBackground(getDrawable(datos[position].getDrawable()));
         return(item);
        }
    }
}
