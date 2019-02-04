package com.example.carmar04.proyectofinal;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla3 extends AppCompatActivity implements dialog_fragment_purchase_product.sendingProduct {

    ArrayList chosenProducts = new ArrayList();
    ArrayList <Product> products = new ArrayList();
    ArrayList product = new ArrayList();
    ArrayList <Integer> images = new ArrayList();

    User user;

    @Override
    public void sendProduct(Product product) {
        chosenProducts.add(product);
    }

    SQLSentences.DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        Intent intent = getIntent();
        //product = intent.getParcelableArrayListExtra("Products");
        user = (User) intent.getSerializableExtra("UserRegistered");
        //chosenProducts = intent.getParcelableArrayListExtra("ChosenProducts");

        images.add(R.drawable.rx580gigabyte);
        images.add(R.drawable.rx580asus);
        images.add(R.drawable.rx580sapphire);
        images.add(R.drawable.gtx1060asus);
        images.add(R.drawable.gtx1060gigabyte);
        images.add(R.drawable.gtx1060msi);
        images.add(R.drawable.vega64gigabyte);
        images.add(R.drawable.gtx1080gigabyte);

        dbHelper = new SQLSentences.DatabaseHelper(this);
        dbHelper.open();

        //if(product.size() > 0) {
            //for (int i = 0; i < product.size(); i++) {
                //products.add((Product) product.get(i));
            //}
        //}
        Cursor cursor1;
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

        TextView UserTextView = findViewById(R.id.UserId);
        UserTextView.setText(user.getNickName());

        ListView ProductListView = (ListView) findViewById(R.id.ListComponents);
        ProductAdapter productAdapter = new ProductAdapter(this);
        ProductListView.setAdapter(productAdapter);
        ProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), products[position].toString(), Toast.LENGTH_SHORT).show();
                Product product = new Product(products.get(position).getProductId(),
                        products.get(position).getProductName(),products.get(position).getProductStock(),
                        products.get(position).getProductPrice(), products.get(position).getProductImage());
                showDialog(product);
            }
        });
        Cursor cursor2;
        cursor2 = dbHelper.getItems("SELECT nickName,id FROM Users",null);

        if(cursor2 != null) {
            if (cursor2.moveToFirst()) {
                String user = "";
                int id = 0;
                do {
                    user = cursor2.getString(0);
                    id = cursor2.getInt(1);
                    Toast.makeText(getApplicationContext(), user + " id = "+ String.valueOf(id), Toast.LENGTH_SHORT).show();

                } while (cursor2.moveToNext());
                cursor2.close();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Cursor User nulo", Toast.LENGTH_SHORT).show();
        }

    }


    public class ProductAdapter extends ArrayAdapter{
        Activity context;

        ProductAdapter(Activity context){
            super(context, R.layout.list_components, products);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_components, parent, false);


            TextView productName = (TextView) convertView.findViewById(R.id.ProductName);
            TextView productStock = (TextView) convertView.findViewById(R.id.ProductStock);
            TextView productPrice = (TextView) convertView.findViewById(R.id.ProductPrice);
            ImageView productImage = (ImageView) convertView.findViewById(R.id.ProductImage);

            productName.setText(products.get(position).getProductName());
            productStock.setText(products.get(position).getProductStock());
            productPrice.setText(String.valueOf(products.get(position).getProductPrice()));
            productImage.setImageDrawable(getDrawable(products.get(position).getProductImage()));

            return convertView;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflate  = getMenuInflater();
        inflate.inflate(R.menu.menu_principal, menu);
        return true;
    }
    //recoge los valores por tocar los diferentes botones del menú
    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje = "";
        switch (item.getItemId()){
            case R.id.MenuOption1:
                Intent intentOption1 = new Intent(Pantalla3.this, BasketScreen.class);
                Bundle bundleOption1 = new Bundle();
                bundleOption1.putSerializable("User", user);
                bundleOption1.putParcelableArrayList("ChosenProducts", chosenProducts);
                intentOption1.putExtras(bundleOption1);
                startActivity(intentOption1);
                return true;
            case R.id.MenuOption2:
                Intent intentOption2 = new Intent(Pantalla3.this, OrderScreen.class);
                Bundle bundleOption2 = new Bundle();
                bundleOption2.putSerializable("User", user);
                intentOption2.putExtras(bundleOption2);
                startActivity(intentOption2);

                return true;
            case R.id.MenuOption3:
                //Intent intentOption3 = new Intent(Pantalla3.this,);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void showDialog(Product product) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("NewPurchase");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = dialog_fragment_purchase_product.newInstance(product);
        dialogFragment.show(ft,"NewPurchase");
    }
}
