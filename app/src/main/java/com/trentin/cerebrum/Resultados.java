package com.trentin.cerebrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity implements View.OnClickListener{
    private Button menu, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(this);
        exit = (Button) findViewById(R.id.sair2);
        exit.setOnClickListener(this);
        final TextView respostasCorretas = findViewById(R.id.respostascorretas);
        final TextView respostasIncorretas = findViewById(R.id.respostasincorretas);

        final int getRespostasCorretas = getIntent().getIntExtra("correta",0);
        final int getRespostasIncorretas = getIntent().getIntExtra("incorreta",0);

        respostasCorretas.setText(String.valueOf(getRespostasCorretas));
        respostasIncorretas.setText(String.valueOf(getRespostasIncorretas));

    }


    @Override
    public void onClick(View view) {
        if (view == menu) {
            Intent i = new Intent(this, Tela1.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == exit) {
            finishAffinity();
        }
    }
}