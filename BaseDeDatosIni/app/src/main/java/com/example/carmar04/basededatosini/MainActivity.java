package com.example.carmar04.basededatosini;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Este codigo es para probar, no esta bien estructurado
    //c/Users/APPData(esta oculto)/local/Android/sdk adb. devices    -s emulator-5554 shell

    ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

    //Obtenemos referencia a la base de datos para poder modificarla.
    SQLiteDatabase bd = cliBDh.getWritableDatabase();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buscar = (Button) findViewById(R.id.buscar);
        TextView textView = (TextView) findViewById(R.id.respuesta);
        final Cursor c;
        
        //Abrimos la base de datos en modo escritura

        

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont=1; cont<=3; cont++) {

                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Insert con metodo de la BD
                ContentValues contentValues = new ContentValues();
                contentValues.put("nombre","Cliente" + cont);
                contentValues.put("telefono",telefono);
                bd.insert("Clientes",null,contentValues);

                //Creamos los datos


                //Introducimos los datos en la tabla Clientes
                //bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                //        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }

            //Update con metodo de la BD
            ContentValues contentValues1 = new ContentValues();
            contentValues1.put("telefono", "1111111");
            bd.update("Clientes", contentValues1, "codigo=1",null);

            bd.delete("Clientes", "codigo=3", null);

            //Ejemplo Select1
            
        		//String[] args3 = new String[]{"Cliente1"};
        		//c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);
        		//textView.setText(c.toString());


        		//Ejemplo Select2
        		String[] campos = new String[] {"nombre", "telefono"};
        		String[] args4 = new String[] {"cli1"};
        		c = bd.query("Clientes", campos, "nombre=?", args4, null, null, null);
        		textView.setText(c.toString());


        		//Nos aseguramos de que exista al menos un registro

        		if (c.moveToFirst()) {
        			//Recorremos el cursor hasta que no haya mas registros
        			do {
        				String nombreCli = c.getString(0);
        				String telefonoCli = c.getString(1);
        				textView.setText(nombreCli + ", " + telefonoCli);
                        Toast.makeText(this, nombreCli +", "+ telefonoCli, Toast.LENGTH_SHORT).show();
        			} while (c.moveToNext());
        		}
            //Cerramos la base de datos
            bd.close();
        } //del if
    }

}
