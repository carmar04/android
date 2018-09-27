package com.example.carmar04.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Factorial1 extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button button;

    public int calcularFactorial(int numero){
        for(int index = numero -1;index > 0;index--){
            numero = numero * index;
        }
        return numero;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial1);

        editText = (EditText) findViewById(R.id.myEditText1);
        textView = (TextView) findViewById(R.id.myTextView1);
        button = (Button) findViewById(R.id.myButton1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(editText.getText().toString());
                int numero2 = calcularFactorial(numero);

                textView.setText(String.valueOf(numero2).toString());
                String numeroString = String.valueOf(numero2).toString();

                Intent intent = new Intent(Factorial1.this, Factorial2.class);
                Bundle bundle = new Bundle();

                bundle.putString("factorial", numeroString);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
