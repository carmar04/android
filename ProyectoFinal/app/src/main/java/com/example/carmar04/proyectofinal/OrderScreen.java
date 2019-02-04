package com.example.carmar04.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderScreen extends AppCompatActivity {

    ArrayList chosenProducts = new ArrayList();
    SQLSentences.DatabaseHelper dbHelper;
    ArrayList <Orders> Orders = new ArrayList();
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");
        chosenProducts = intent.getParcelableArrayListExtra("ChosenProducts");
        dbHelper = new SQLSentences.DatabaseHelper(this);
        dbHelper.open();

        TextView OrderScreenUser = findViewById(R.id.OrderScreenUser);
        OrderScreenUser.setText(user.getNickName() + " " + String.valueOf(user.getUserId()));

        Button buttonOrderScreenBack = findViewById(R.id.OrderScreenButtonBack);
        buttonOrderScreenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderScreen.this, Pantalla3.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("UserRegistered", user);
                bundle.putParcelableArrayList("ChosenProducts", chosenProducts);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        String [] userName = {user.getNickName()};
        int userId = 0;
        Cursor cursor;
        cursor = dbHelper.getItems("SELECT id FROM Users WHERE nickname=?", userName);

        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    userId = cursor.getInt(0);
                    Toast.makeText(getApplicationContext(), "User Id = " +String.valueOf(userId), Toast.LENGTH_SHORT).show();
                }while(cursor.moveToNext());

            }

        }

        //String [] UserId ={String.valueOf(user.getUserId())};
        String User = String.valueOf(userId);
        String [] UserId = {User};
        Cursor cursor2 = dbHelper.getItems("SELECT * FROM Orders WHERE user_id=?", UserId);
        if(cursor2.moveToFirst()){
            do{
                Orders.add(new Orders(cursor2.getInt(0), cursor2.getInt(1),
                        cursor2.getInt(2), cursor2.getDouble(3)));
            }while(cursor2.moveToNext());
        }

        TextView OrderDescription = findViewById(R.id.OrderScreenDescription);
        OrderDescription.setText(String.valueOf(Orders.size()));

        ListView OrderlistView = (ListView) findViewById(R.id.OrderScreenListView);
        OrderAdapter OrderAdapter = new OrderAdapter(this);
        OrderlistView.setAdapter(OrderAdapter);
    }


    public class OrderAdapter extends ArrayAdapter {
        Activity context;

        OrderAdapter(Activity context){
            super(context, R.layout.list_orders, Orders);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_orders, parent, false);

            TextView OrderId = (TextView) convertView.findViewById(R.id.ListOrderId);
            TextView OrderArticles = (TextView) convertView.findViewById(R.id.ListOrderArticles);
            TextView OrderAmount = (TextView) convertView.findViewById(R.id.ListOrderAmount);

            OrderId.setText(String.valueOf(Orders.get(position).getOrderId()));
            OrderArticles.setText(String.valueOf(Orders.get(position).getOrderArticles()));
            OrderAmount.setText(String.valueOf(Orders.get(position).getOrderAmount()));

            return convertView;
        }
    }
}
