package com.example.carmar04.proyectofinal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class dialog_fragment_dismiss_product extends DialogFragment {
    private EditText UserInput;
    private EditText PasswordInput;
    private Button DeleteProduct;
    private Button CancelAction;
    ArrayList arrayList;
    int position;
    Boolean checker = true;

    public interface OnDismissedProduct{
        void dismissProduct(int position);
    }
    public OnDismissedProduct dismissedProduct;

    static dialog_fragment_dismiss_product newInstance(int position){
        dialog_fragment_dismiss_product dialog_fragment_dismiss_product = new dialog_fragment_dismiss_product();
        Bundle args = new Bundle();
        args.putInt("ChosenProductPosition", position);
        dialog_fragment_dismiss_product.setArguments(args);
        return dialog_fragment_dismiss_product;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList = getArguments().getParcelableArrayList("ChosenProducts");
        position = getArguments().getInt("ChosenProductPosition");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_dismiss_product, container, false);
        DeleteProduct = view.findViewById(R.id.FragmentButtonDismissDelete);
        CancelAction = view.findViewById(R.id.FragmentButtonDismissCancel);

        CancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        DeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissedProduct.dismissProduct(position);
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
            dismissedProduct = (dialog_fragment_dismiss_product.OnDismissedProduct) getActivity();
        }catch(ClassCastException e){
            Toast.makeText(getContext(), "Sending error", Toast.LENGTH_SHORT ).show();
        }
    }
}