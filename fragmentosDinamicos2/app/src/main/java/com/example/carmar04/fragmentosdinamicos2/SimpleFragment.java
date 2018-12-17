package com.example.carmar04.fragmentosdinamicos2;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.support.v7.content.res.AppCompatResources.getDrawable;


public class SimpleFragment extends Fragment {
    int mNum;
    int Imagen;
    int [] imagenes = new int[]{
            R.drawable.fiesta3, R.drawable.fiesta2, R.drawable.ferrari1, R.drawable.ferrari2
    };

     int random = (int) (Math.random() * imagenes.length);

    static SimpleFragment newInstance(int number, int laImagen) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);// Mantenemos el numero para usarlo en cualquier momento.
        //args.putInt("imagen", laImagen);
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el nÃºmero que se habia pasado como argumento en
        // la creaciÃ³n de la instancia
        mNum = getArguments().getInt("num");
        //Imagen = getArguments().getInt("imagen");

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v  = null;

        if (mNum % 2 == 0){// dependiendo de si es par o impar mostramos distintos layouts
            v = inflater.inflate(R.layout.fragment_simple2, container, false);
            Toast.makeText(getActivity(),String.valueOf(random), Toast.LENGTH_SHORT).show();
            View tv = v.findViewById(R.id.text2);
            View img = v.findViewById(R.id.image2);
            //informamos el nÃºmero de Fragment
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
            ((ImageView)img).setImageResource(imagenes[random]);
        }
        else{
            Toast.makeText(getActivity(),String.valueOf(random), Toast.LENGTH_SHORT).show();
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            View tv = v.findViewById(R.id.text1);//informamos el numero de Fragment
            View img = v.findViewById(R.id.image1);
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
            ((ImageView)img).setImageResource(imagenes[random]);
        }
        return v;
    }
}
