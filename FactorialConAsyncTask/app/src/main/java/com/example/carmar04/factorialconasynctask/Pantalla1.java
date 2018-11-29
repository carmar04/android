package com.example.carmar04.factorialconasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {
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
        setContentView(R.layout.activity_pantalla1);

        editText = (EditText) findViewById(R.id.myEditText1);
        textView = (TextView) findViewById(R.id.myTextView1);
        button = (Button) findViewById(R.id.myButton1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacion(this);
            }
        });
    }
    public void calcularOperacion(View.OnClickListener view){
        textView.setText("");
        int n = Integer.parseInt(editText.getText().toString());
        textView.append(n + "\n");
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }
    class MiTarea extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected Integer doInBackground(Integer... n) {
            return calcularFactorial(n[0]);
        }

        @Override
        protected void onPostExecute(Integer res) {
            textView.append(res + "\n");
        }
    }
}
