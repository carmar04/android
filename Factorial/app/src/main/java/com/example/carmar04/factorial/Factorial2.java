package com.example.carmar04.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Factorial2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial2);

        TextView textView = (TextView) findViewById(R.id.myTextView2);

        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.get("factorial").toString());

    }
}
