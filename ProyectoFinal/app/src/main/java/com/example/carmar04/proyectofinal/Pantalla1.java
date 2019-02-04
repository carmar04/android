package com.example.carmar04.proyectofinal;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.app.DialogFragment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla1 extends AppCompatActivity implements dialog_fragment_new_user.OnInputListener {

    final ArrayList arrayList1 = new ArrayList();
    final ArrayList arrayList2 = new ArrayList();
    SQLSentences.DatabaseHelper dbHelper = null;

    Cursor cursor1;
    Cursor cursor2;

    ArrayList <Integer> images = new ArrayList();
    ArrayList products = new ArrayList();


    @Override
    public void sendInput(ArrayList arrayList) {
        dbHelper.insertItem("INSERT INTO Users (nickName, password) " +
               "VALUES ('" + arrayList.get(0) + "', '" + arrayList.get(1) + "')");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        Button NewUser = (Button) findViewById(R.id.NewUser);
        Button NewLogin = (Button) findViewById(R.id.NewLogin);
        final EditText UserInput = (EditText) findViewById(R.id.UserInput);
        final EditText PasswordInput = (EditText) findViewById(R.id.PasswordInput);

        images.add(R.drawable.rx580gigabyte);
        images.add(R.drawable.rx580asus);
        images.add(R.drawable.rx580sapphire);
        images.add(R.drawable.gtx1060asus);
        images.add(R.drawable.gtx1060gigabyte);
        images.add(R.drawable.gtx1060msi);
        images.add(R.drawable.vega64gigabyte);
        images.add(R.drawable.gtx1080gigabyte);


        dbHelper = new SQLSentences.DatabaseHelper(this);
        //DBVC = new UserSQLiteHelper(this, "DBVC", null, 1);
        //bd = DBVC.getWritableDatabase();

        dbHelper.open();

        cursor1 = dbHelper.getItems("SELECT id, name, stock, price FROM Products", null);

        if(cursor1 != null) {
            if (cursor1.moveToFirst()) {
                int index = 1;
                do {
                    int cursor = cursor1.getInt(0);
                    if (cursor == index) {
                        products.add(new Product(cursor1.getInt(0), cursor1.getString(1),
                                cursor1.getString(2), cursor1.getDouble(3), images.get(index-1)));
                    }
                    index++;

                } while (cursor1.moveToNext());
            }else{
                Toast.makeText(getApplicationContext(), "no se mueve Cursor Product nulo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Cursor Product nulo", Toast.LENGTH_SHORT).show();
        }



        //bd.execSQL("INSERT INTO Users ( nickName, password) " +
         //       "VALUES ('" + "carles" + "', '" + "1234" + "')");


        //String [] tables1 = new String[]{"nickName", "password", "mail"};
        //String [] selectUser1 = new String[]{UserInput.getText().toString()};


        cursor2 = dbHelper.getItems("SELECT nickName,id FROM Users",null);

        if(cursor2 != null) {
            if (cursor2.moveToFirst()) {
                String user = "";
                int id = 0;
                do {
                    user = cursor2.getString(0);
                    id = cursor2.getInt(1);
                    arrayList2.add(user);
                    Toast.makeText(getApplicationContext(), user + " id = "+ String.valueOf(id), Toast.LENGTH_SHORT).show();

                } while (cursor2.moveToNext());
                cursor2.close();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Cursor User nulo", Toast.LENGTH_SHORT).show();
        }

        //dbHelper.drop();

        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        NewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String user = "";
                 String password = "";
                 String mail = "";

                cursor2 = dbHelper.getItems("SELECT nickName FROM Users",null);

                if(cursor2.moveToFirst()){
                    do{
                        user = cursor2.getString(0);
                        arrayList1.add(user);
                        //Toast.makeText(getApplicationContext(), "Usuario: " + user, Toast.LENGTH_SHORT).show();
                    }while(cursor2.moveToNext());
                    cursor2.close();
                }
                boolean checker = false;
                for(int i = 0; i < arrayList1.size(); i++){
                    if(((String) arrayList1.get(i)).equalsIgnoreCase(UserInput.getText().toString())){
                        checker = true;
                    }
                }
                if(checker){
                    User userRegistered = new User(UserInput.getText().toString(), PasswordInput.getText().toString());
                    Toast.makeText(getApplicationContext(), "Login succeed",Toast.LENGTH_LONG).toString();
                    Intent intent = new Intent(Pantalla1.this, Pantalla3.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("UserRegistered", userRegistered);
                    //bundle.putParcelableArrayList("Products", products);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Login failed",Toast.LENGTH_LONG).show();
                    PasswordInput.setText("");
                }


            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        cursor2 = dbHelper.getItems("SELECT nickName FROM Users",null);
    }

    void showDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("NewUser");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = dialog_fragment_new_user.newInstance(arrayList2);
        dialogFragment.show(ft,"NewUser");
    }
}
