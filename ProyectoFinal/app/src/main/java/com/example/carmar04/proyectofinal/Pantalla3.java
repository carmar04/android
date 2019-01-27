package com.example.carmar04.proyectofinal;

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

public class Pantalla3 extends AppCompatActivity {

    Product [] products = new Product[]{
            new Product("AMD Radeon RX580 GIGABYTE", "stock", 198.70,R.drawable.rx580gigabyte),
            new Product("AMD Radeon RX580 ASUS", "stock", 223.60, R.drawable.rx580asus),
            new Product("AMD Radeon RX580 SAPPHIRE", "stock", 198.70, R.drawable.rx580sapphire),
            new Product("NVIDIA GTX 1060 ASUS", "stock", 270.70, R.drawable.gtx1060asus),
            new Product("NVIDIA GTX 1060 GIGABYTE", "stock", 258.40, R.drawable.gtx1060gigabyte),
            new Product("NVIDIA GTX 1060 MSI", "stock", 298.70, R.drawable.gtx1060msi),
            new Product("AMD Radeon RX64 GIGABYTE", "stock", 498.10,R.drawable.vega64gigabyte),
            new Product("NVIDIA GTX 1080 GIGABYTE", "stock", 530.70, R.drawable.gtx1080gigabyte),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        ListView ProductListView = (ListView) findViewById(R.id.ListComponents);
        ProductAdapter productAdapter = new ProductAdapter(this);
        ProductListView.setAdapter(productAdapter);
        ProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), products[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });

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
            TextView prodcutPrice = (TextView) convertView.findViewById(R.id.ProductPrice);
            ImageView productImage = (ImageView) convertView.findViewById(R.id.ProductImage);

            productName.setText(products[position].getProductName());
            productStock.setText(products[position].getProductStock());
            prodcutPrice.setText(String.valueOf(products[position].getProductPrice()));
            productImage.setImageDrawable(getDrawable(products[position].getProductImage()));

            return convertView;
        }
    }
}
