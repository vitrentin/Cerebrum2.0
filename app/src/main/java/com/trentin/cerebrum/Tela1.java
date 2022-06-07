package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Tela1 extends AppCompatActivity implements View.OnClickListener{
    private Button portugues, matematica, quimica, geografia, todos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        portugues = (Button) findViewById(R.id.portugues);
        portugues.setOnClickListener(this);
        matematica = (Button) findViewById(R.id.matematica);
        matematica.setOnClickListener(this);
        quimica = (Button) findViewById(R.id.quimica);
        quimica.setOnClickListener(this);
        geografia = (Button) findViewById(R.id.geografia);
        geografia.setOnClickListener(this);
        todos = (Button) findViewById(R.id.todas);
        todos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == portugues) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == matematica) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == quimica) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == geografia) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == todos) {
            Intent i = new Intent(this, Todas.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}