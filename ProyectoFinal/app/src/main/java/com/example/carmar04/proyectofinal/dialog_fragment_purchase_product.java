package com.example.carmar04.proyectofinal;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class dialog_fragment_purchase_product extends DialogFragment {

    Product product;

    public interface sendingProduct{
        void sendProduct(Product product);
    }
    public sendingProduct sendingProduct;
    static dialog_fragment_purchase_product newInstance(Product product){
        dialog_fragment_purchase_product dialogFragmentPurchaseProduct = new dialog_fragment_purchase_product();
        Bundle args = new Bundle();
        args.putSerializable("Product", product);
        dialogFragmentPurchaseProduct.setArguments(args);
        return dialogFragmentPurchaseProduct;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product = (Product) getArguments().getSerializable("Product");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_purchase_product, container, false);

        TextView productName = view.findViewById(R.id.ProductName);
        TextView productStock = view.findViewById(R.id.ProductStock);
        TextView productPrice = view.findViewById(R.id.ProductPrice);
        ImageView productImage = view.findViewById(R.id.ProductImage);

        Button buttonCancel = view.findViewById(R.id.FragmentButtonCancel);
        Button buttonAdd = view.findViewById(R.id.FragmentButtonAdd);

        productName.setText(product.getProductName());
        productStock.setText(product.getProductStock());
        productPrice.setText(String.valueOf(product.getProductPrice()));
        productImage.setImageResource(product.getProductImage());

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingProduct.sendProduct(product);
                getDialog().dismiss();
            }
        });

        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sendingProduct = (dialog_fragment_purchase_product.sendingProduct) getActivity();
        }catch(ClassCastException e){
            Toast.makeText(getContext(), "Sending error", Toast.LENGTH_SHORT ).show();
        }
    }
}
